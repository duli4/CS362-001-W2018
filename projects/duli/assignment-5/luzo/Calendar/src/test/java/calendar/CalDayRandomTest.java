package calendar;


import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

		private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
		private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests CalDay Class.
     */

	 @Test
	  public void radnomtest()  throws Throwable  {

			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

			System.out.println("Start testing CalDay class");

			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			int thisYear;
			int thisMonth;
			int thisDay;
			thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
			CalDay calendar = new CalDay(today);
			int coutNumber = 0;
		try{
			for(int i=0;elapsed < TestTimeout;i++){
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 //Construct a new Appointment object with the initial data
				 Appt appt = new Appt(startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
			 calendar.addAppt(appt);
			 if(appt.getValid()){
			 // System.out.println("Appointment number is " + calendar.getSizeAppts());
			 	coutNumber++;
			  assertEquals(coutNumber,calendar.getSizeAppts());
			}
			 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
						if((i%100)==0 && i!=0 )
									System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		}catch(NullPointerException e){

		}

	 }



}
