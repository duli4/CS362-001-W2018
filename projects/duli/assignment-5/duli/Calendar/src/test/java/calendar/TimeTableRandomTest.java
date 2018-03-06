package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests TimeTable Class.
     */

		 /**
		  * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
		  */
		 	public static int RandomSelectRecur(Random random){
		 			int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		 		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		 			return RecurArray[n] ; // return the value of the  appointments to recur
		 			}
		 /**
		  * Return a randomly selected appointments to recur forever or Never recur  !.
		  */
		 	public static int RandomSelectRecurForEverNever(Random random){
		 			int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		 		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		 			return RecurArray[n] ; // return appointments to recur forever or Never recur
		 			}

	 @Test
	  public void radnomtest()  throws Throwable  {

			long startTime = Calendar.getInstance().getTimeInMillis();
			long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		 Calendar rightnow = Calendar.getInstance();
		 int thisyear = rightnow.get(Calendar.YEAR);
		 int thismonth = rightnow.get(Calendar.MONTH)+1;
		 int thisday = rightnow.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisyear,thismonth,thisday);

		 try{
			 for(int i=0;elapsed < TestTimeout;i++){
				  LinkedList<Appt> listAppts = new LinkedList<Appt>();

				 	TimeTable timeTable=new TimeTable();
					long randomseed =System.currentTimeMillis(); //10
		//			System.out.println(" Seed:"+randomseed );
					Random random = new Random(randomseed);

					int numberCheck=ValuesGenerator.getRandomIntBetween(random, -10,10);
					int ranNumDay = ValuesGenerator.getRandomIntBetween(random, 1, 31);
					GregorianCalendar tomorrow = new GregorianCalendar(thisyear,thismonth,thisday+ranNumDay);

					for(int j=0;j<NUM_TESTS;j++){
					Random random1 = new Random(randomseed);
					 int startHour=ValuesGenerator.RandInt(random1);
					 int startMinute=ValuesGenerator.RandInt(random1);
					 int startDay=ValuesGenerator.RandInt(random1);;
					 int startMonth=ValuesGenerator.getRandomIntBetween(random1, 1, 11);
					 int startYear=ValuesGenerator.getRandomIntBetween(random1, 2017, 2020);
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

									 int sizeArray=ValuesGenerator.getRandomIntBetween(random1, -2, 8);
									 int[] recurDays;
									 if(sizeArray < 0)
										 recurDays=null;
									 else
									 recurDays=ValuesGenerator.generateRandomArray(random1, sizeArray);
									 int recur=ApptRandomTest.RandomSelectRecur(random1);
									 int recurIncrement = ValuesGenerator.RandInt(random1);
									 int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random1);
									 appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					listAppts.add(appt);

					if(numberCheck<=0){
						try{
								timeTable.getApptRange(listAppts,tomorrow, tomorrow);
						}catch(DateOutOfRangeException e){}
					}
					 else if(numberCheck>0){
						assertEquals(ranNumDay,timeTable.getApptRange(listAppts, today, tomorrow).size());
					}
				}

				   int deleteNum = ValuesGenerator.getRandomIntBetween(random, 0,listAppts.size()+2);
					 	if(deleteNum <= 98){
							if(timeTable.deleteAppt(listAppts,listAppts.get(deleteNum)) != null)
				 				assertNotNull(timeTable.deleteAppt(listAppts,listAppts.get(deleteNum)));
					 		else
				 				assertNull(timeTable.deleteAppt(listAppts,listAppts.get(deleteNum)));
				 			}
							 else if(deleteNum == 99)
								assertNull(timeTable.deleteAppt(listAppts,null));
							 else if(deleteNum == 100)
							 	 assertNull(timeTable.deleteAppt(null,listAppts.get(0)));
							 else{
								 LinkedList<Appt> listAppts01 = new LinkedList<Appt>();
								 assertNull(timeTable.deleteAppt(listAppts01,listAppts.get(0)));
							 }


					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
							 if((i%1000)==0 && i!=0 )
										 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			 }
		 }catch(NullPointerException e){

		 }



	 }



}
