package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.*;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable timeTable=new TimeTable();
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Calendar rightnow = Calendar.getInstance();
		 int thisyear = rightnow.get(Calendar.YEAR);
		 int thismonth = rightnow.get(Calendar.MONTH)+1;
		 int thisday = rightnow.get(Calendar.DAY_OF_MONTH);
		 GregorianCalendar today = new GregorianCalendar(thisyear,thismonth,thisday);
		 GregorianCalendar tomorrow = new GregorianCalendar(thisyear,thismonth,thisday+1);

    // first appointment
		 int startHour=17;
		 int startMinute=50;
		 int startDay=thisday;
		 int startMonth=thismonth;
		 int startYear=thisyear;
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
			listAppts.add(appt);

			// second appointment
			startMinute=30;
			startDay=thisday+1;
			startMonth=thismonth;
			startYear=thisyear;
			title="Class";
			description="Rescheduled class.";
			Appt appt2 = new Appt(startHour,
			startMinute ,
			startDay ,
			startMonth ,
			startYear ,
			title,
		 description
			);
			listAppts.add(appt2);
			//test for getApptRange function
		 assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());

		 //new list appts
			LinkedList<Appt> listAppts_1 = new LinkedList<Appt>();
			listAppts_1.add(appt2);
			listAppts_1.add(appt);
			assertEquals(listAppts.get(1),listAppts_1.get(0));
			LinkedList<Appt> listAppts_after_permute = new LinkedList<Appt>();
			int []pv;
			pv = new int[2];
			pv[0] = 1;
			pv[1] = 0;
			listAppts_after_permute = timeTable.permute(listAppts,pv);
			//after permute
			assertEquals(listAppts.get(1),listAppts_after_permute.get(1));
		 //test deleteAppt
		 //before delete, appt is 2
		 assertEquals(2,listAppts.size());
		 //after delete, appt is 1
		 //System.out.println("Delete  "+ listAppts.get(0) );
		 assertEquals(1,timeTable.deleteAppt(listAppts,listAppts.get(1)).size());
	 }
	 @Test
	  public void test02()  throws Throwable  {
			TimeTable timeTable=new TimeTable();
			LinkedList<Appt> listAppts = new LinkedList<Appt>();
			Calendar rightnow = Calendar.getInstance();
			int thisyear = rightnow.get(Calendar.YEAR);
			int thismonth = rightnow.get(Calendar.MONTH)+1;
			int thisday = rightnow.get(Calendar.DAY_OF_MONTH);
			GregorianCalendar today = new GregorianCalendar(thisyear,thismonth,thisday);
			GregorianCalendar tomorrow = new GregorianCalendar(thisyear,thismonth,thisday+1);

			// first appointment
			int startHour=17;
			int startMinute=50;
			int startDay=thisday;
			int startMonth=thismonth;
			int startYear=thisyear;
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
					int []recurdays = new int[7];
				appt.setRecurrence(recurdays,1,1,3);
				assertTrue(appt.isRecurring());
				listAppts.add(appt);
				assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
				assertEquals(null,timeTable.deleteAppt(listAppts,null));
				assertEquals(null,timeTable.deleteAppt(null,appt));
				Appt appt2 = new Appt(
					24,1,1,1,1,"none","none"
				);
				assertEquals(null,timeTable.deleteAppt(listAppts,appt2));
	 }
//add more unit tests as you needed
	@Test
	public void test03()  throws Throwable  {
		TimeTable timeTable=new TimeTable();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Calendar rightnow = Calendar.getInstance();
		int thisyear = rightnow.get(Calendar.YEAR);
		int thismonth = rightnow.get(Calendar.MONTH)+1;
		int thisday = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisyear,thismonth,thisday);
		GregorianCalendar tomorrow = new GregorianCalendar(thisyear,thismonth,thisday+1);

		// first appointment
		int startHour=17;
		int startMinute=50;
		int startDay=thisday;
		int startMonth=thismonth;
		int startYear=thisyear;
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
				int []recurdays = new int[7];
			appt.setRecurrence(recurdays,2,1,3);
			assertTrue(appt.isRecurring());
			listAppts.add(appt);
			assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
	}

	@Test
	public void test04()  throws Throwable  {
		TimeTable timeTable=new TimeTable();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Calendar rightnow = Calendar.getInstance();
		int thisyear = rightnow.get(Calendar.YEAR);
		int thismonth = rightnow.get(Calendar.MONTH)+1;
		int thisday = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisyear,thismonth,thisday);
		GregorianCalendar tomorrow = new GregorianCalendar(thisyear,thismonth,thisday+1);

		// first appointment
		int startHour=17;
		int startMinute=50;
		int startDay=thisday;
		int startMonth=thismonth;
		int startYear=thisyear;
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
				int []recurdays = new int[7];
			appt.setRecurrence(recurdays,3,1,3);
			assertTrue(appt.isRecurring());
			listAppts.add(appt);
			assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
	}

	@Test
	public void test05()  throws Throwable  {
		TimeTable timeTable=new TimeTable();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Calendar rightnow = Calendar.getInstance();
		int thisyear = rightnow.get(Calendar.YEAR);
		int thismonth = rightnow.get(Calendar.MONTH)+1;
		int thisday = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisyear,thismonth,thisday);
		GregorianCalendar tomorrow = new GregorianCalendar(thisyear,thismonth,thisday+1);

		// first appointment
		int startHour=17;
		int startMinute=50;
		int startDay=thisday;
		int startMonth=thismonth;
		int startYear=thisyear;
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
				int []recurdays = new int[7];
			appt.setRecurrence(recurdays,4,1,3);
			assertTrue(appt.isRecurring());
			listAppts.add(appt);
			assertEquals(1,timeTable.getApptRange(listAppts, today, tomorrow).size());
	}

	@Test
	public void test06()  throws Throwable  {
		TimeTable timeTable=new TimeTable();
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		Calendar rightnow = Calendar.getInstance();
		int thisyear = rightnow.get(Calendar.YEAR);
		int thismonth = rightnow.get(Calendar.MONTH)+1;
		int thisday = rightnow.get(Calendar.DAY_OF_MONTH);
		GregorianCalendar today = new GregorianCalendar(thisyear,thismonth,thisday);
		GregorianCalendar tomorrow = new GregorianCalendar(thisyear,thismonth,thisday+1);

		// first appointment
		int startHour=17;
		int startMinute=50;
		int startDay=thisday;
		int startMonth=thismonth;
		int startYear=thisyear;
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
			listAppts.add(appt);
			try{
			timeTable.getApptRange(listAppts,tomorrow, tomorrow);
		}catch(DateOutOfRangeException e){}
		}

		@Test
		public void test07()  throws Throwable  {
			System.out.println("----------------------------------------------------------");
			TimeTable timeTable=new TimeTable();
			LinkedList<Appt> listAppts = new LinkedList<Appt>();
			Calendar rightnow = Calendar.getInstance();
			int thisyear = rightnow.get(Calendar.YEAR);
			int thismonth = rightnow.get(Calendar.MONTH)+1;
			int thisday = rightnow.get(Calendar.DAY_OF_MONTH);
			GregorianCalendar today = new GregorianCalendar(thisyear,thismonth,thisday);
			GregorianCalendar tomorrow = new GregorianCalendar(thisyear,thismonth,thisday+1);
			GregorianCalendar Day03 = new GregorianCalendar(thisyear,thismonth,thisday+2);
			GregorianCalendar Yesterday = new GregorianCalendar(thisyear,thismonth,thisday-1);
			GregorianCalendar LongDay = new GregorianCalendar(thisyear,thismonth,thisday+100);


			assertEquals(1,timeTable.getApptRange(listAppts,today,tomorrow).size());

			TimeTable timeTable02=new TimeTable();
			Appt appt01 = new Appt(30,-1,2,2,2,"none","none");
			LinkedList<Appt> listAppts01 = new LinkedList<Appt>();
			listAppts01.add(appt01);
			assertFalse(listAppts01.get(0).getValid());
			assertEquals(1,timeTable02.getApptRange(listAppts01,today,tomorrow).size());
			Appt appt02 = new Appt(13,4,2,2,2,"none","none");
			listAppts01.add(appt02);
			assertTrue(listAppts01.get(1).getValid());
			assertEquals(1,timeTable02.getApptRange(listAppts01,today,tomorrow).size());
			Appt appt03 = new Appt(13,4,43,2,2,"none","none");
			listAppts01.add(appt03);
			assertFalse(listAppts01.get(2).getValid());
			assertEquals(1,timeTable02.getApptRange(listAppts01,today,tomorrow).size());

			Appt appt05 = new Appt(13,4,2,2,2,"none","none");
			TimeTable timeTable03=new TimeTable();
			int[] recurringDays = null;
			appt05.setRecurrence(recurringDays, 1, 1, 10);
			listAppts01.add(appt05);
			assertTrue(listAppts01.get(3).getValid());
			assertEquals(4,listAppts01.size());
			assertNotNull(timeTable03.getApptRange(listAppts01,today,Day03));
			Appt appt06 = new Appt(13,4,2,2,2,"none","none");
			int[] recurringDays01 = new int[3];
			recurringDays01[0] = 4;
			recurringDays01[1] = 4;
			recurringDays01[2] = 4;
			appt06.setRecurrence(recurringDays01, 1, 1, -1);
			listAppts01.add(appt06);
			assertEquals(5,listAppts01.size());
			assertNotNull(timeTable03.getApptRange(listAppts01,today,Day03));
			Appt appt04 = new Appt(13,4,2,2,2,"none","none");
			int[] recurringDays02 = new int[0];
			appt04.setRecurrence(recurringDays02, 1, 1, 0);
			listAppts01.add(appt04);
			assertEquals(2,timeTable03.getApptRange(listAppts01,today,Day03).size());


			TimeTable timeTable04=new TimeTable();
			try{
			timeTable04.getApptRange(listAppts01,Day03, today);
		}catch(DateOutOfRangeException e){}

				TimeTable timeTable05=new TimeTable();
				assertNotNull(timeTable05.getApptRange(listAppts01,Yesterday, LongDay));

				assertNull(timeTable03.deleteAppt(listAppts,appt04));

				Appt appt07 = new Appt(1,4,5,1,8,"none","none");
				assertNull(timeTable03.deleteAppt(listAppts01,appt07));

				int[] pv = new int[0];
				assertNotNull(timeTable03.permute(listAppts,pv));

				int[] pv01 = new int[1];
				LinkedList<Appt> listAppts02 = new LinkedList<Appt>();
				listAppts02.add(appt04);

				assertNotNull(timeTable03.permute(listAppts02,pv01));

				TimeTable timeTable06=new TimeTable();
				LinkedList<Appt> listAppts03 = new LinkedList<Appt>();
				Appt appt08 = new Appt(30,100,2,2,2,"none","none");
				Appt appt09 = new Appt(100,4,2,2,2,"none","none");
				Appt appt10 = new Appt(12,4,79,2,2,"none","none");
				listAppts03.add(appt08);
				listAppts03.add(appt09);
				listAppts03.add(appt10);
				assertNotNull(timeTable06.getApptRange(listAppts03,Yesterday,today));

				TimeTable timeTable07=new TimeTable();
				LinkedList<Appt> listAppts04 = new LinkedList<Appt>();
				Appt appt11 = new Appt(1,1,2,2,2,"none","none");
				Appt appt12 = new Appt(2,4,2,2,2,"none","none");
				Appt appt13 = new Appt(12,4,5,2,2,"none","none");
				listAppts04.add(appt11);
				listAppts04.add(appt12);
				listAppts04.add(appt13);
				assertNotNull(timeTable07.getApptRange(listAppts04,Yesterday,today));

				Appt appts20 = new Appt(12,80,thisday,thismonth,thisyear,"none","none");
				Appt appts21 = new Appt(12,12,thisday,thismonth,thisyear,"none","none");
				Appt appts22 = new Appt(13,19,thisday,thismonth,thisyear,"none","none");
				listAppts04.add(appts20);
				listAppts04.add(appts21);
				listAppts04.add(appts22);
				assertNotNull(timeTable07.getApptRange(listAppts04,tomorrow,Day03));
		}
}
