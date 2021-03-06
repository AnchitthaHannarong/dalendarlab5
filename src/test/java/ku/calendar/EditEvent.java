package ku.calendar;

import static org.junit.Assert.*;

import org.junit.Test;

public class EditEvent {
	@Test
	public void test() {
		CalendarPanel view = new CalendarPanel();
		view.rander();
		view.meeting.add(new Date("30","8",2017,"03.00","04.00","eat with mom"));
		System.out.println(view.meeting.get(0).getDay());
		System.out.println(view.meeting.get(0).getYear());
		System.out.println(view.meeting.get(0).getStartTime());
		System.out.println(view.meeting.get(0).getEndTime());
		System.out.println(view.meeting.get(0).getMeeting());
		view.meeting.get(0).setMeeting("working");
		assertEquals(view.meeting.get(0).getDay(),"30");
		assertEquals(view.meeting.get(0).getMonth(),"8");
		assertEquals(view.meeting.get(0).getYear(),2017);
		assertEquals(view.meeting.get(0).getStartTime(),"03.00");
		assertEquals(view.meeting.get(0).getEndTime(),"04.00");
		assertEquals(view.meeting.get(0).getMeeting(),"working");
	}

}
