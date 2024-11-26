/**
 * 
 */
package leapyear;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LeapYearTest {

	private LeapYear leapYear;

	@Before
	public void before() {
		leapYear = new LeapYear();
	}

	@Test
	public void testAnno4() {
		assertTrue(leapYear.isLeap(4));
	}

	@Test
	public void testNatale() {
		assertFalse(leapYear.isLeap(0));
	}

	@Test
	public void test2000() {
		assertTrue(leapYear.isLeap(2000));
	}

	@Test
	public void testFirstGregorianLeapYear1584() {
		assertTrue(leapYear.isLeap(1584));
	}

	@Test
	public void testSulBisestileDel1900() { assertFalse(leapYear.isLeap(1900)); }

	@Test
	public void testSulBisestileDel1100() {
		assertTrue(leapYear.isLeap(1100));
	}
}
