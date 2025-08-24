package ContactService;
/*
This JUnit test class verifies that the ContactService class correctly manages contacts
It tests:
  - Adding a new contact and preventing duplicate contactIds
  - Deleting a contact by contactId
  - Updating allowed fields (firstName, lastName, phone, address) for existing contacts
*/
import static org.junit.Assert.*;  // JUnit 4, not jupiter
import org.junit.Test;             // JUnit 4 annotation

public class ContactServiceTest {

    @Test
    public void testAddContactValid() {
    ContactService service = new ContactService();

    // Add a contact
    service.addContact("Mathew", "Masar", "0987645187", "9187 Happay Lane");

    // Retrieve the first contact from the HashMap
    Contact addedContact = service.getAllContacts().values().iterator().next();


    // Assertions
    assertNotNull(addedContact);
    assertEquals("Mathew", addedContact.getFirstName());
    assertEquals("Masar", addedContact.getLastName());
    assertEquals("0987645187", addedContact.getPhone());
    assertEquals("9187 Happay Lane", addedContact.getAddress());
}    

    @Test
    public void testDeleteContactValid() {
        ContactService service = new ContactService();

        // Add a contact first
        service.addContact("Mathew", "Masar", "0987645187", "9187 Happay Lane");

        // Get the generated contact ID
        String contactId = service.getAllContacts().keySet().iterator().next();

        // Delete the contact
        service.deleteContact(contactId);

        // Verify it's deleted
        assertFalse(service.getAllContacts().containsKey(contactId));
    }
    
    @Test
    public void testDeleteContactNonExistent() {
        ContactService service = new ContactService();

        try {
            service.deleteContact("ZZZZZZZZZZ"); // Random ID that doesn't exist
            fail("Expected IllegalArgumentException for deleting non-existent contact.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testUpdateContactValid() {
        ContactService service = new ContactService();

        // Add a contact first
        service.addContact("Mathew", "Masar", "0987645187", "9187 Happay Lane");

        // Get the generated contact ID
        String contactId = service.getAllContacts().keySet().iterator().next();

        // Update the contact
        service.updateContact(contactId, "Wehtam", "Rasam", "1234567890", "13 Sad Street");

        // Retrieve updated contact
        Contact updatedContact = service.getContact(contactId);

        // Assertions
        assertEquals("Wehtam", updatedContact.getFirstName());
        assertEquals("Rasam", updatedContact.getLastName());
        assertEquals("1234567890", updatedContact.getPhone());
        assertEquals("13 Sad Street", updatedContact.getAddress());
    }

    @Test
    public void testUpdateContactNonExistent() {
        ContactService service = new ContactService();

        try {
            service.updateContact("ZZZZZZZZZZ", "Wehtam", "Rasam", "1234567890", "13 Sad Street");
            fail("Expected IllegalArgumentException for updating non-existent contact.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
    @Test
    public void testUpdateContactInvalidField() {
        ContactService service = new ContactService();

        // Add a valid contact first
        service.addContact("Mathew", "Masar", "0987645187", "9187 Happay Lane");

        // Get the generated contact ID
        String contactId = service.getAllContacts().keySet().iterator().next();

        try {
            // Attempt to update with invalid phone number
            service.updateContact(contactId, null, null, "12345abcde", null);
            fail("Expected IllegalArgumentException for invalid phone format.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

}