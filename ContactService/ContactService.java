package ContactService;
/*
Manages Contact objects in memory using a Hashmap.

-Add new contact with unique contactID
-Delete existing contact by contactID
-Update firstName, lastName, phone, address of existing contact

contactID cannot be changed after created
*/

import java.util.HashMap;
import java.util.Random;

public class ContactService {

    // Store contacts in a HashMap (Key = contactId, Value = Contact object)
    private HashMap<String, Contact> contacts = new HashMap<>();

    // = = Add Contact = =
    public void addContact(String firstName, String lastName, String phone, String address) {
        
        String contactId;
        // Generate a unique 10-character ID
        do {
            contactId = generateContactId();
        } while (contacts.containsKey(contactId)); // Repeat ID gen until unique contactId not in Hashmap
        
        Contact newContact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, newContact);
    }

    // = = Delete Contact = =
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID does not exist.");  
        }
        contacts.remove(contactId); 
    }
    
    // = = Update Contact = =
    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist.");
        }
        
        // Update only allowed fields
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    // === Getter for Testing ===
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }

    // === Getter for Testing (All Contacts) ===
    public HashMap<String, Contact> getAllContacts() {
        return contacts;
    }

    // = = Generate Unique 10-Character Contact ID = =
    private String generateContactId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder id = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            id.append(characters.charAt(random.nextInt(characters.length())));// Append a random character from the characters string to build the ID
        }
        return id.toString();
    }    
}