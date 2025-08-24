package ContactService;
/*
This class defines Contact object and enforces all reuired constraints. 
Provides getters for all fields and setters for updateable ones. 
*/

public class Contact {

    // = = Fields = =
    private final String contactId;   // Cannot change after creation
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // = = Constructor = =
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        validateFirstName(firstName);
        validateLastName(lastName);
        validatePhone(phone);
        validateAddress(address);
        
        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // = = Getters (all fields) = =
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    // = = Setters (only updatable fields) = =
    public void setFirstName(String firstName) {
        validateFirstName(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateLastName(lastName);
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        validatePhone(phone);
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateAddress(address);
        this.address = address;
    }

    // = = Private Validation Methods = =
    private void validateContactId(String contactId) {
        if (contactId == null || contactId.length() > 10) {
        throw new IllegalArgumentException("Contact ID cannot be null or longer than 10 characters.");
        }
    }

    private void validateFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
        throw new IllegalArgumentException("First name cannot be null or longer than 10 characters.");
        }
    }

    private void validateLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
        throw new IllegalArgumentException("Last name cannot be null or longer than 10 characters.");
        }
    }

    private void validatePhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) { // regex for exactly 10 digits
        throw new IllegalArgumentException("Phone must be exactly 10 digits.");
        }
    }

    private void validateAddress(String address) {
        if (address == null || address.length() > 30) {
        throw new IllegalArgumentException("Address cannot be null or longer than 30 characters.");
        }
    }
}