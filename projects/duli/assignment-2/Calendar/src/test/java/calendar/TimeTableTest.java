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
}
