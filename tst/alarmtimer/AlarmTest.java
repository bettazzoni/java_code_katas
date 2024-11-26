package alarmtimer;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

class CurrentClockMock extends CurrentClock{
	public long seconds = 0L;
	
	long getSeconds() {
		return seconds;
	}	
}

public class AlarmTest {
	
	private CurrentClockMock mockCurrClock;
	private Alarm alarm;

	@Before
	public void setUp() {
		mockCurrClock = new CurrentClockMock();
		alarm = new Alarm(1000, mockCurrClock);
	}
	
	@Test
	public void test_before1000seconds() {
		mockCurrClock.seconds = 999;
		assertFalse(alarm.isExpired());
	}
	
	@Test
	public void test_after1000seconds() {
		mockCurrClock.seconds =  1000;
		assertTrue(alarm.isExpired());		
	}
}
