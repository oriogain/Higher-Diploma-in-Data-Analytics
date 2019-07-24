/*
 * Program: ST662 - Assignment 4.sas
   Author : Sean O'Riogain (18145426)
   Date   : 6th April 2019
 */

/* Question 1 */

/*
 * The dataset Dates.csv contains 3000 dates from years 2000 to 2015. Read it into SAS.
 * 
 */

proc import datafile='/home/seanoriogain200/ST662/Dates.csv'
	out=dates
	replace
	dbms=csv;
	getnames=yes;
run;

/*
 * (a) Create a new variable which contains the date in format DD/MM/YYYY.
 */

data dates;
	set dates;
	date = mdy(month, day, year);
	format date ddmmyy10.;
run;

/*
 * (b) Write code to screen the dataset.
 * (c) List any errors identied. 
 */

title 'Question 1c: *** Error: Day is out of range (0 - 31)';
proc print data=dates;
	var day;
	where day < 1 or day > 31;
run;

title 'Question 1c: *** Error: Day is too large for month';
proc print data=dates;
    var day month year;
	where day > 0 and ((day > 28 and month = 2 and mod(year, 4) <> 0) or
	                   (day > 29 and month = 2 and mod(year, 4) = 0) or
	                   (day > 30 and (month = 4 or month = 6 or month = 9 or month = 11)));
run;

title 'Question 1c: *** Error: Month is out of range (1 - 12)';
proc print data=dates;
	var month;
	where month < 1 or month > 12;
run;

title 'Question 1c: *** Error: Date is not specified';
proc print data=dates;
	var date;
	where date = .;
run;

title;

/* Question 2 */

/*
 * The dataset Bricks.csv contains information on Australian quarterly clay brick production from
 * 1956 to 1994. Read the data into SAS.
 */

proc import datafile='/home/seanoriogain200/ST662/Bricks.csv'
	out=bricks
	dbms=csv
	replace;
	getnames=yes;
run;

/*
 * (a) Create a single date variable from the year and quarter variables, and format it so that it
 *     reads as quarterly data. Hint: explore the YYQ function and format `yyqs8.'.
 */

data bricks;
	set bricks;
	YYQ = yyq(year, quarter);
	format yyq yyqs8.;
run;

/*
 * (b) Create a time series plot of the data and comment (briefly - one to two sentences) on the
 *     effects (or not) of season, cycle and trend.
 */

proc sgplot data=bricks;
	title 'Question 2b: Australian Clay Brick Production (1956 - 1994)';
	series x=yyq y=bricks;
	xaxis labelattrs=(size=12pt) valueattrs=(size=12pt) label='Year';
	yaxis labelattrs=(size=12pt) valueattrs=(size=12pt) label='Bricks (Millions)';
run;

title;

/*
 * The above time series plot shows a generally increasing trend and this trend is cyclical
 * with a significant correction taking place around 1983. We can also see that there is a seasonal
 * component to the series: with production typically increasing during the first 3 quarters of 
 * each year, peaking during the 3rd quarter and falling back during the 4th quarter and the 
 * 1st quarter of the following year, as illustrated by the following sample data extract.
 */

title 'Bricks Data - First 20 Observations';
proc sql number outobs=20;
	select *
	from bricks
	order by yyq;
quit;

/*
 * (c) Use an appropriate exponential smoothing method to forecast to the end of 1996. In your
 *     answer, state which type of exponential smoothing you used and why, provide a graph illus-
 *     trating the forecasts, and give a table of the forecasts with confidence limits.
 */

/* Let's see when the time series data actually ends... */

title 'Question 2c: End of time series - last year & quarter';
proc sql;
	select max(yyq) format=yyqs8.
	from bricks;
quit;

title;

/*
 * The results of the previous query tells us that the time series data ends with 1994 Q3, which
 * means that we will need to forecast forward for 9 quarters to get us to the end of 1996.
 */

title 'Question 2c: Lake Huron Depth Forecast to the end of 1996';
proc esm data=bricks out=bricks_to_1996 plot=forecasts print=forecasts lead=9;
	id yyq interval=qtr;
	forecast bricks /  model=addwinters use=predict transform=log;
run;

title;

/*
 * In the ESM statements above we use the Winters type of exponential smoothing because of the
 * presence of both trend and seasonality in the bricks dataset.
 */

/* Question 3 */

/*
 * The dataset LakeHuron.csv contains annual depth measurements at a specic site on Lake Huron
 * from 1875 to 1972. Read the data into SAS.
 */

proc import datafile='/home/seanoriogain200/ST662/LakeHuron.csv'
	out=huron
	dbms=csv
	replace;
	getnames=yes;
run;

/*
 * (a) Create four new variables that contain the time series depth measurements at lag 1 to 4.
 */

data huron;
	set huron;
	Depth1 = lag1(depth);
	Depth2 = lag2(depth);
	Depth3 = lag3(depth);
	Depth4 = lag4(depth);
run;

/*
 * (b) Generate scatterplots of depth versus each lag variable.
 */

proc sgscatter data=huron;
	title "Question 3b: Scatter Plot Matrix for Depth versus its 4 Lag Variables";
	matrix depth depth1 depth2 depth3 depth4 / group=year;
run;

title;

/*
 * (c) Comment on autocorrelation in the data.
 */

ods text="Question 3c: The matrix scatter plots printed above indicate that the level of correlation between the Depth variable and its lagged versions decreases as the lag level increases.";

/*
 * The matrix scatter plots printed above indicate that the level of correlation between the 
 * Depth variable and its lagged versions decreases as the lag level increases.
 */