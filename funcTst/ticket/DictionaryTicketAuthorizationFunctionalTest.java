package ticket;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DictionaryTicketAuthorizationFunctionalTest {

    @Test
    public void testValidateTicketPositive() {
        Map<String, String> validTicket = new HashMap<>();
        validTicket.put("name", "JohnDoe");
        validTicket.put("authorization", "Auth_JohnDoe");
        validTicket.put("start_date", LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        validTicket.put("end_date", LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        boolean result = DictionaryTicketAuthorization.validateTicket(validTicket);
        assertTrue("Expected ticket validation to pass for a valid ticket.", result);
    }

    @Test
    public void testValidateTicketNegative() {
        Map<String, String> invalidTicket = new HashMap<>();
        invalidTicket.put("name", "JaneDoe");
        invalidTicket.put("authorization", "WrongAuth");
        invalidTicket.put("start_date", LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        invalidTicket.put("end_date", LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        boolean result = DictionaryTicketAuthorization.validateTicket(invalidTicket);
        assertFalse("Expected ticket validation to fail for an invalid ticket.", result);
    }

    @Test
    public void testValidateTicketMissingField() {
        Map<String, String> ticketWithMissingField = new HashMap<>();
        ticketWithMissingField.put("name", "JohnDoe");
        // Missing authorization field
        ticketWithMissingField.put("start_date", LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        ticketWithMissingField.put("end_date", LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        boolean result = DictionaryTicketAuthorization.validateTicket(ticketWithMissingField);
        assertFalse("Expected ticket validation to fail for a ticket missing required fields.", result);
    }

    @Test
    public void testValidateTicketInvalidDate() {
        Map<String, String> ticketWithInvalidDate = new HashMap<>();
        ticketWithInvalidDate.put("name", "JohnDoe");
        ticketWithInvalidDate.put("authorization", "Auth_JohnDoe");
        ticketWithInvalidDate.put("start_date", "invalid_date_format");
        ticketWithInvalidDate.put("end_date", LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        boolean result = DictionaryTicketAuthorization.validateTicket(ticketWithInvalidDate);
        assertFalse("Expected ticket validation to fail for a ticket with invalid date formats.", result);
    }
}

