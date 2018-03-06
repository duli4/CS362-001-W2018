package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.*;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
			int thisyear;
			int thismonth;
			int thisday;
			Calendar rightnow = Calendar.getInstance();
			thisyear = rightnow.get(Calendar.YEAR);
			thismonth = rightnow.get(Calendar.MONTH)+1;
			thisday = rightnow.get(Calendar.DAY_OF_MONTH);
			GregorianCalendar today = new GregorianCalendar(thisyear,thismonth,thisday);
			CalDay calendar = new CalDay(today);
				CalDay c2 = new CalDay();

				int startHour=21;
				int startMinute=30;
				int startDay=15;
				int startMonth=01;
				int startYear=2018;
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
				Appt appt2 = new Appt(
									23,1,1,1,1,"none","none"
								);
					calendar.addAppt(appt);
					assertEquals(1,calendar.getSizeAppts());
					calendar.addAppt(appt2);
					assertFalse(appt2.getValid());
					assertEquals(1,calendar.getSizeAppts());
					assertEquals(null,c2.iterator());

					StringBuilder sb = new StringBuilder();
					String todayDate = today.get(Calendar.MONTH) + "/" + today.get(Calendar.DAY_OF_MONTH) + "/" + thisyear;
					sb.append("\t --- " + todayDate + " --- \n");
					sb.append(" --- -------- Appointments ------------ --- \n");
					Iterator<Appt> itr = calendar.appts.iterator();
				    while(itr.hasNext()) {
				         Object element = itr.next();

				         sb.append(element + " ");
				      }
						sb.append("\n");
						assertEquals(sb.toString(),calendar.toString());
	 }
	 @Test
	  public void test02()  throws Throwable  {
			int thisyear;
			int thismonth;
			int thisday;
			Calendar rightnow = Calendar.getInstance();
			thisyear = rightnow.get(Calendar.YEAR);
			thismonth = rightnow.get(Calendar.MONTH)+1;
			thisday = rightnow.get(Calendar.DAY_OF_MONTH);
			GregorianCalendar today = new GregorianCalendar(thisyear,thismonth,thisday);
			CalDay calendar = new CalDay(today);
			assertNotNull(calendar.iterator());
			Appt appt2 = new Appt(
								14,1,1,1,1,"none","none"
							);
			calendar.addAppt(appt2);
			calendar.iterator();
			Iterator<Appt> itr = calendar.appts.iterator();
			assertTrue(itr.hasNext());
			Appt appt4 = new Appt(25,1,1,1,1,"none","none");
			calendar.addAppt(appt4);
			assertEquals(1,calendar.getSizeAppts());
			Appt appt5 = new Appt(
								14,5,5,5,5,"none","none"
							);
				calendar.addAppt(appt5);
				assertEquals(2,calendar.getSizeAppts());
				Appt appt6 = new Appt(
									12,5,5,5,5,"none","none"
								);
				calendar.addAppt(appt6);
				assertEquals(3,calendar.getSizeAppts());
				//assertEquals(appt6,calendar.getAppts().get(2));
				Appt appt7 = new Appt(
									12,2,2,2,2,"none","none"
								);
				calendar.addAppt(appt7);
				assertEquals(4,calendar.getSizeAppts());
				//assertEquals(appt7,calendar.getAppts().get(3));
	 }
//add more unit tests as you needed
}
