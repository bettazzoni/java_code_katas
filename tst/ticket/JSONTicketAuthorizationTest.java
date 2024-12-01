package ticket;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class JSONTicketAuthorizationTest {

    @Test(expected = org.json.JSONException.class)
    public void testNotValidJson() {
        JSONTicketAuthorization.validateTicket(new JSONObject(""));
    }

    @Test
    public void test_Empty_JSON() {
        JSONObject ticketJson = new JSONObject("{}");
        assertFalse(JSONTicketAuthorization.validateTicket(ticketJson));
    }
}
