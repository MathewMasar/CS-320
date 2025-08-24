package ContactService;
/*
This JUnit test class verifies that the Contact class correctly enforces all validation rules and behaves as expected. 
It tests:
  - Successful creation of valid contacts
  - Rejection of invalid inputs (nulls, too long strings, wrong phone format)
  - Proper functioning of setters for updatable fields
 */
import static org.junit.Assert.*;  // JUnit 4, not jupiter
import org.junit.Test;             // JUnit 4 annotation

public class ContactTest {

    // = = Test Valid Contact Creation = =
    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("00001", "Mathew", "Masar", "0987645187", "9187 Happay Lane");
        assertEquals("00001", contact.getContactId());
        assertEquals("Mathew", contact.getFirstName());
        assertEquals("Masar", contact.getLastName());
        assertEquals("0987645187", contact.getPhone());
        assertEquals("9187 Happay Lane", contact.getAddress());
    }

    // = = Test Invalid Contact Creation = =
    @Test
    public void testInvalidFirstNameTooLong() {
        try {
            new Contact("00001", "MathewMathew", "Masar", "0987645187", "9187 Happay Lane");
            fail("Expected IllegalArgumentException for firstName longer than 10 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);        
        }
    }

    @Test
    public void testInvalidFirstNameNull() {
        try {
            new Contact("00001", null, "Masar", "0987645187", "9187 Happay Lane");
            fail("Expected IllegalArgumentException for null firstName.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidLastNameTooLong() {
        try {
            new Contact("00001", "Mathew", "MasarMasarMasar", "0987645187", "9187 Happay Lane");
            fail("Expected IllegalArgumentException for stName longer than 10 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);        
        }
    }

    @Test
    public void testInvalidLastNameNull() {
        try {
            new Contact("00001", "Mathew", null, "0987645187", "9187 Happay Lane");
            fail("Expected IllegalArgumentException for null lasttName.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testInvalidPhoneLength() {
        try {
            new Contact("00001", "Mathew", "Masar", "12345678y", "9187 Happay Lane");
            fail("Expected IllegalArgumentException for phone not 10 digits.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);        
        }
    }

    @Test
    public void testPhoneNull() {
        try {
            new Contact("00001", "Mathew", "Masar", null, "9187 Happay Lane");
            fail("Expected IllegalArgumentException for null phone.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
    
    @Test
    public void testInvalidAddressTooLong() {
        try {
            new Contact("00001", "Mathew", "Masar", "0987645187", 
                "123456789012345678901234567890123"); // 33 characters
            fail("Expected IllegalArgumentException for address longer than 30 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }    

    @Test
    public void testInvalidAddressNull() {
        try {
            new Contact("00001", "Mathew", "Masar", "0987645187", null);
            fail("Expected IllegalArgumentException for null address.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    // = = Valid Setter Updates = =
    @Test
    public void testValidSetters() {
        Contact contact = new Contact("00001", "Mathew", "Masar", "0987645187", "9187 Happay Lane");

        // Update with valid values
        contact.setFirstName("Wehtam");
        contact.setLastName("Rasam");
        contact.setPhone("1234567890");
        contact.setAddress("13 Sad Street");

        // Assertions to confirm updates
        assertEquals("Wehtam", contact.getFirstName());
        assertEquals("Rasam", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("13 Sad Street", contact.getAddress());
    }

        // = = Invalid Setter Updates = =

    @Test
    public void testSetFirstNameTooLong() {
        Contact contact = new Contact("00001", "Mathew", "Masar", "0987645187", "9187 Happay Lane");
        try {
            contact.setFirstName("MathewMathew");
            fail("Expected IllegalArgumentException for firstName longer than 10 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSetLastNameTooLong() {
        Contact contact = new Contact("00001", "Mathew", "Masar", "0987645187", "9187 Happay Lane");
        try {
            contact.setLastName("MasarMasarMasar");
            fail("Expected IllegalArgumentException for lastName longer than 10 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSetFirstNameNull() {
        Contact contact = new Contact("00001", "Mathew", "Masar", "0987645187", "9187 Happay Lane");
        try {
            contact.setFirstName(null);
            fail("Expected IllegalArgumentException for null firstName.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSetLastNameNull() {
        Contact contact = new Contact("00001", "Mathew", "Masar", "0987645187", "9187 Happay Lane");
        try {
            contact.setLastName(null);
            fail("Expected IllegalArgumentException for null lastName.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSetPhoneInvalid() {
        Contact contact = new Contact("00001", "Mathew", "Masar", "0987645187", "9187 Happay Lane");
        try {
            contact.setPhone("12345abcde");
            fail("Expected IllegalArgumentException for invalid phone.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSetPhoneNull() {
        Contact contact = new Contact("00001", "Mathew", "Masar", "0987645187", "9187 Happay Lane");
        try {
            contact.setPhone(null);
            fail("Expected IllegalArgumentException for null phone.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSetAddressTooLong() {
        Contact contact = new Contact("00001", "Mathew", "Masar", "0987645187", "9187 Happay Lane");
        try {
            contact.setAddress("123456789012345678901234567890123");
            fail("Expected IllegalArgumentException for address longer than 30 characters.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testSetAddressNull() {
        Contact contact = new Contact("00001", "Mathew", "Masar", "0987645187", "9187 Happay Lane");
        try {
            contact.setAddress(null);
            fail("Expected IllegalArgumentException for null address.");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}