package calculator;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JsonCalculatorTest {

	static private JsonCalculator jc;

	@BeforeClass
	static public void setUp() {
		jc = new JsonCalculator();
	}
	
	@Test(expected = org.json.JSONException.class)
	public void testNotJsonStrings() {
		jc.processJsonString("this is not a JSON");
	}

    @Test(expected = org.json.JSONException.class)
    public void testBadFormatJsonStrings() {
        jc.processJsonString("{ \"a\" : 21 }");
    }

    @Test(expected = org.json.JSONException.class)
    public void testAdd_bad_1st_value() {
        jc.processJsonString( "{ \"Cmd\": \"add\", \"val1\": \"**\", \"val2\": \"1\" }" );
    }

    @Test(expected = org.json.JSONException.class)
    public void testAdd_bad_2nd_value() {
        jc.processJsonString( "{ \"Cmd\": \"add\", \"val1\": \"-12\", \"val2\": \"bad\" }" );
    }

    @Test
    public void testAdd() {
        assertEquals(42, jc.processJsonString( "{ \"Cmd\": \"add\", \"val1\": 11, \"val2\": 31 }" )) ;
    }

    @Test
    public void testAdd_JSON_not_ordered() {
        assertEquals(50, jc.processJsonString( "{ \"val2\": \"3\", \"Cmd\": \"add\", \"val1\": \"47\",  }" )) ;
    }

    @Test
    public void testSub() {
        assertEquals(5, jc.processJsonString( "{ \"Cmd\": \"sub\", \"val1\": \"100\", \"val2\": \"95\" }" )) ;
    }

    @Test
    public void testMul() {
        assertEquals(120, jc.processJsonString( "{ \"Cmd\": \"mul\", \"val1\": \"30\", \"val2\": \"4\" }" )) ;
    }

    @Test
    public void testDiv() {
        assertEquals(10.5, jc.processJsonString( "{ \"Cmd\": \"div\", \"val1\": \"42\", \"val2\": \"4\" }" )) ;
    }

    @Test(expected = ArithmeticException.class)
    public void testDiv_divisionBy0() {
        jc.processJsonString( "{ \"Cmd\": \"div\", \"val1\": 1, \"val2\": \"0\" }" ) ;
    }
}
