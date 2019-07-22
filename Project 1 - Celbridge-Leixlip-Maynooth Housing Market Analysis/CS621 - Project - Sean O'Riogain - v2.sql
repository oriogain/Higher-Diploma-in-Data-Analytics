-- House Prices

-- Check for meter-based projection

select distinct ST_SRID(geom)
from house_prices_kildare;

-- House Prices in Celbridge, Leixlip and Maynooth

drop view if exists house_prices_clm;

create or replace view house_prices_clm as
	select h.*, a.geom as geom_small_area
	from small_areas_clm a, house_prices_kildare h
	where ST_Contains(a.geom, h.geom);

-- House Prices in Celbridge, Leixlip and Maynooth (2017 Prices Only)

drop view if exists house_prices_clm_2017;

create or replace view house_prices_clm_2017 as
	select h.*, a.geom as geom_small_area
	from small_areas_clm a, house_prices_kildare h
	where ST_Contains(a.geom, h.geom)
	  and h.year = 2017;

-- Public Transport Stops

-- Check for meter-based projection

select distinct ST_SRID(geom)
from  stop_points;

-- Create view to focus on public transport stops in the selected Celbridge, Leixlip & Maynooth small areas

drop view if exists stop_points_clm;

create or replace view stop_points_clm as
	select s.*, a.geom as geom_small_area
	from  stop_points s, small_areas_clm a
	where ST_Contains(a.geom,s.geom);

-- Average Percentage Price Rise per Annum

-- This is the 'density' value that we will use to graduate the small areas that are in scope for Celbridge, Lexilip and Maynooth.

-- Note that not all of the in-scope small areas have house price data for all of the years between 2012 and 2017, which we need to cater for in the
--   following calculation.

-- For each small area this 'density' value is calculated by:

--    1. Computing the average house price achieved during the most recent year for which data is available for it and subtracting the average house
--       price achieved during the ealiest year for which data is available for it.
--
--    2. This average house price difference is then divided by the earliest average house price figure and multiplied by 100 to derive the
--       percentage house price rise achieved within that area during the time interval in question.
--
--    3. Finally, that figure is then divided by that interval (in years) to yield the average precentage price rise per annum.
--
--    Note that the final result is rounded to the nearest integer value.

--    Also note that any small areas where the average house price decreased during the time interval for which such data is available for it is
--       omitted from the above calculations and, therefore, retains the default annual percentage price rise value of zero.


-- Add a new integer column (initialised with a default value of zero) to the Celbridge-Leixlip-Maynooth small areas table to store the results of
--    the above calculations.

alter table small_areas_clm drop column if exists avg_pct_price_rise_pa;

alter table small_areas_clm add column avg_pct_price_rise_pa integer default 0;

-- Begin the transaction to populate the column that was created above

BEGIN;

update small_areas_clm s
set avg_pct_price_rise_pa = Z.avg_pct_price_rise_pa
from
-- The following pseudo table (as Z) combines and uses the results of the two other pseudo tables (X and Y), which retrieve the required average
--    house price data for the earliest and latest year, respectively, for which house price data is available for the smll area in question.
(
select X.small_area, round((((Y.max_avg_price - X.min_avg_price)/X.min_avg_price)*100)/(Y.Year-X.Year)) as avg_pct_price_rise_pa
from
-- The following pseudo table (X) retrieves the average price house for the earliest year for which data exists for the in-scope small areas
(
select a.small_area, p.year, avg(p.price) as min_avg_price
from house_prices_clm p, small_areas_clm a
where ST_Contains(a.geom,p.geom)
  and p.year in
          (
          select min(p1.year)
          from house_prices_clm p1, small_areas_clm a1
          where ST_Contains(a1.geom,p1.geom)
            and a1.small_area = a.small_area
           ) 
group by a.small_area, p.year
order by 1, 2
) X,
-- The following pseudo table (Y) retrieves the average price house for the latest year for which data exists for the in-scope small areas
(
select a.small_area, p.year, avg(p.price) as max_avg_price
from house_prices_clm p, small_areas_clm a
where ST_Contains(a.geom,p.geom)
  and p.year in
          (
          select max(p1.year)
          from house_prices_clm p1, small_areas_clm a1
          where ST_Contains(a1.geom,p1.geom)
            and a1.small_area = a.small_area
           ) 
group by a.small_area, p.year
order by 1, 2
) Y
where X.small_area = Y.small_area    -- Join the result of pseudo tables X and Y
  and (Y.year - X.year) > 0          -- Skip the in-scope small areas for which only one year of house price data is available
  and X.min_avg_price <> 0           -- Ignore small areas whose average price for the earliest year is 0 (thereby avoiding a divide-by-zero error)
  and (Y.max_avg_price - X.min_avg_price) > 0  -- Skip the in-scope small areas where the house price rise is zero or negative during the interval
                                               --    for which data is availabe for it.
) Z
where s.small_area = Z.small_area;

ROLLBACK;                            -- Do not execute this statement if the results of the previous updated statement is as expected

COMMIT;                              -- If the previous step was NOT executed, execute this statement to commit the results of this transaction

