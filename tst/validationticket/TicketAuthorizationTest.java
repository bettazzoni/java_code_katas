package validationticket;

import org.json.JSONObject;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class DateHelper{
    static String toString(ZonedDateTime zdt) {
        return zdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME);
    }
    static String buildTestJSON(String name, String auth, ZonedDateTime startTime, ZonedDateTime endTime) {
        return "{ \"name\": \"" + name + "\" , \"authorization\": \"" + auth + "\", \"start_date\": \"" +
                DateHelper.toString(startTime) + "\", \"end_date\": \"" +
                DateHelper.toString(endTime)  + "\" }";
    }
}

public class TicketAuthorizationTest {

    ZonedDateTime TIME_NOW = ZonedDateTime.now();
    ZonedDateTime TIME_NOW_PLUS_10_SEC = TIME_NOW.plusSeconds(10);
    ZonedDateTime TIME_NOW_MINUS_10_SEC = TIME_NOW.minusSeconds(10);

    @Test(expected = org.json.JSONException.class)
    public void testNotJsonStrings() {
        TicketAuthorization.validateTicket(new JSONObject(""));
    }

    @Test
    public void test_no_empty_JSON() {
        JSONObject ticketJson = new JSONObject("{}");
        assertFalse(TicketAuthorization.validateTicket(ticketJson));
    }

    @Test
    public void test_okay_1() {
        String ticketJsonString = """
       { "name": "JohnDoe",  "authorization": "Auth_JohnDoe",
          "start_date": "2024-01-01T08:00:00+01:00",
          "end_date": "2024-12-31T18:00:00+01:00" }
       """;
        JSONObject ticketJson = new JSONObject(ticketJsonString);
        assertTrue(TicketAuthorization.validateTicket(ticketJson));
    }

    @Test
    public void test_okay_2() {
        String ticketJsonString = DateHelper.buildTestJSON("JohnDoe", "Auth_JohnDoe",
                TIME_NOW_MINUS_10_SEC, TIME_NOW_PLUS_10_SEC);
        JSONObject ticketJson = new JSONObject(ticketJsonString);
        assertTrue(TicketAuthorization.validateTicket(ticketJson));
    }

    @Test
    public void test_no_name() {
        String ticketJsonString = """
        {   "authorization": "Auth_JohnDoe",
            "start_date":""" + " \"" + DateHelper.toString(TIME_NOW_MINUS_10_SEC) + "\"," + """
            "end_date":""" + " \"" + DateHelper.toString(TIME_NOW_PLUS_10_SEC) + "\" }";
        JSONObject ticketJson = new JSONObject(ticketJsonString);
        assertFalse(TicketAuthorization.validateTicket(ticketJson));
    }

    @Test
    public void test_bad_name() {
        String ticketJsonString = DateHelper.buildTestJSON("", "Auth_",
                TIME_NOW_MINUS_10_SEC, TIME_NOW_PLUS_10_SEC);
        JSONObject ticketJson = new JSONObject(ticketJsonString);
        assertFalse(TicketAuthorization.validateTicket(ticketJson));
    }

    @Test
    public void test_no_authorization() {
        String ticketJsonString = """
        {   "name": "JohnDoe",
            "start_date":""" + " \"" + DateHelper.toString(TIME_NOW_MINUS_10_SEC) + "\"," + """
            "end_date":""" + " \"" + DateHelper.toString(TIME_NOW_PLUS_10_SEC) + "\" }";
        JSONObject ticketJson = new JSONObject(ticketJsonString);
        assertFalse(TicketAuthorization.validateTicket(ticketJson));
    }

    @Test
    public void test_bad_authorization() {
        String ticketJsonString = DateHelper.buildTestJSON("JohnDoe", "Auth_XXXXXXX",
                TIME_NOW_MINUS_10_SEC, TIME_NOW_PLUS_10_SEC);
        JSONObject ticketJson = new JSONObject(ticketJsonString);
        assertFalse(TicketAuthorization.validateTicket(ticketJson));
    }
    @Test
    public void test_no_stat_date() {
        String ticketJsonString = """
       { "name": "JohnDoe",  "authorization": "Auth_JohnDoe",
          "end_date": "2024-12-31T18:00:00+01:00" }
       """;
        JSONObject ticketJson = new JSONObject(ticketJsonString);
        assertFalse(TicketAuthorization.validateTicket(ticketJson));
    }

    @Test
    public void test_no_end_date() {
        String ticketJsonString = """
       { "name": "JohnDoe",  "authorization": "Auth_JohnDoe",
          "start_date": "2024-01-01T08:00:00+01:00"  }
       """;
        JSONObject ticketJson = new JSONObject(ticketJsonString);
        assertFalse(TicketAuthorization.validateTicket(ticketJson));
    }


}
