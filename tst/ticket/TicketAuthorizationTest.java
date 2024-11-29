package ticket;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class TicketAuthorizationTest {

    @Test(expected = org.json.JSONException.class)
    public void testNotValidJson() {
        TicketAuthorization.validateTicket(new JSONObject(""));
    }

    @Test
    public void test_Empty_JSON() {
        JSONObject ticketJson = new JSONObject("{}");
        assertFalse(TicketAuthorization.validateTicket(ticketJson));
    }
}
