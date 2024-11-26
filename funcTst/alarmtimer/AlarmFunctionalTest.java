package alarmtimer;

import static org.junit.Assert.*;

import org.junit.Test;


public class AlarmFunctionalTest {

	@Test
	public void test_functional_0() {
		Alarm a = new Alarm(0);
		assertEquals(a.isExpired(), true);
	}
	
	@Test
	public void test_functional_1second() throws InterruptedException {
		Alarm a = new Alarm(1);
		assertEquals(a.isExpired(), false);	// could fail!
		Thread.sleep(1 * 1000L);
		assertEquals(a.isExpired(), true);		
	}
}
