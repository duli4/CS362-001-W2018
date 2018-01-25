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
					assertEquals(2,calendar.getSizeAppts());
					assertEquals(null,c2.iterator());

					StringBuilder sb = new StringBuilder();
					String todayDate = thismonth + "/" + thisday + "/" + thisyear;
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

			Appt appt2 = new Appt(
								23,1,1,1,1,"none","none"
							);
			calendar.addAppt(appt2);
			calendar.iterator();
			Iterator<Appt> itr = calendar.appts.iterator();
			assertTrue(itr.hasNext());
			Appt appt4 = new Appt(25,1,1,1,1,"none","none");
			calendar.addAppt(appt4);
			assertEquals(1,calendar.getSizeAppts());
			Appt appt5 = new Appt(
								23,5,5,5,5,"none","none"
							);
				calendar.addAppt(appt5);
				assertEquals(2,calendar.getSizeAppts());
	 }
//add more unit tests as you needed
}
