/**
 * Class representing a single Contact (Name and Phone Number).
 * Encapsulates the contact data.
 */
class Contact {
    // Private fields for Encapsulation
    private String name;
    private String phoneNumber;

    // Constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Overrides the default toString method for clean list display.
     */
    @Override
    public String toString() {
        // Used for display in the JList
        return name + " - " + phoneNumber;
    }

    /**
     * Prepares the contact data for storage in a file.
     */
    public String toFileString() {
        return name + "," + phoneNumber;
    }
}
