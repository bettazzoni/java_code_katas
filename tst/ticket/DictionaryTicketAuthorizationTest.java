package ticket;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;

public class DictionaryTicketAuthorizationTest {

    @Test
    public void testValidateTicketMissingField() {
        Map<String, String> emptyMap = new HashMap<>();
        assertFalse(DictionaryTicketAuthorization.validateTicket(emptyMap));
    }

}

