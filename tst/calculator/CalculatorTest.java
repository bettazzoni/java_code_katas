package calculator;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator c;

	@Before
	public void setUp() {
		c = new Calculator();
	}
	
	@Test(expected = NotACommandException.class)
	public void testCalcEmptyStrings() {
		c.calc("", "", "");
	}
	
	@Test(expected = NumberFormatException.class)
	public void testCalcBadValues() {
		c.calc("add", "", "");
	}
	
	@Test(expected = NumberFormatException.class)
	public void testCalcBothBadValues() {
		c.calc("add", "2", "abc");
	}
	
	@Test
	public void testCalc_add_20_22_is_42() {
		assertEquals(c.calc("add", "20", "22"), "42");
	}

	@Test
	public void testCalc_sub_20_22_is_minus2() {
		assertEquals(c.calc("sub", "20", "22"), "-2");
	}

	@Test
	public void testCalc_mul_6_7_is_42() {
		assertEquals(c.calc("mul", "-6", "-7"), "42");
	}

	@Test(expected = ArithmeticException.class)
	public void testDivByZero() {
		c.calc("div", "2", "0");
	}
	
	@Test
	public void testCalc_div_2_3_is_42() {
		assertEquals( "0.6666667", c.calc("div", "2", "3"));
	}

}
