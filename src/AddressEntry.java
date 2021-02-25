/**
 * This class creates an address entry to be added to the address book.
 * @author Michael Langdon
 * @since 02/15/2021
 */
public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private Integer zip;
    private String phone;
    private String email;

    /**
     * The default constructor.
     */
    public AddressEntry() {
    }

    /**
     * The constructor which builds the entry from the given parameters.
     * @param firstName The first name.  A <code>String</code>
     * @param lastName The last name.  A <code>String</code>
     * @param street The street address.  A <code>String</code>
     * @param city The city.  A <code>String</code>
     * @param state The state.  A <code>String</code>
     * @param zip The zip code.  An <code>Integer</code>
     * @param phone  The phone number.  A <code>String</code>
     * @param email  The email address.  A <code>String</code>
     */
    public AddressEntry(String firstName, String lastName, String street,
                        String city, String state, Integer zip, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    /**
     * Prints out the components of the address entry in a nicely formatted way.
     * @return A formatted <code>String</code> with each field on its own line.
     */
    @Override
    public String toString() {
        return String.format("First name: %s%n%s: %s%n%s: %s%n%s: %s%n%s: %s%n%s: %d%n%s: %s%n%s: %s%n%n",
                getFirstName(), "Last name", getLastName(), "Street", getStreet(), "City",
                getCity(), "State", getState(), "Zip", getZip(), "Telephone", getPhone(),
                "Email", getEmail());
    }

    /**
     * Sets the first name to the parameter value.
     * @param firstName The first name to be set.  A <code>String</code>
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the first name.
     * @return The first name.  A <code>String</code>
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the last name to the parameter value.
     * @param lastName The last name to be set.  A <code>String</code>
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the last name.
     * @return The last name.  A <code>String</code>
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the street address.
     * @return The street address.  A <code>String</code>
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street address.
     * @param street The new street address.  A <code>String</code>
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the city.
     * @return The city.  A <code>String</code>
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city.
     * @param city The city.  A <code>String</code>
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state.
     * @return The state.  A <code>String</code>
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     * @param state The new state.  A <code>String</code>
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the zip code.
     * @return The zip code.  An <code>Integer</code>
     */
    public Integer getZip() {
        return zip;
    }

    /**
     * Sets the zip code.
     * @param zip The new zip code.  An <code>Integer</code>
     */
    public void setZip(Integer zip) {
        this.zip = zip;
    }

    /**
     * Gets the phone number.
     * @return The phone number.  A <code>String</code>
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone number.
     * @param phone The new phone number.  A <code>String</code>
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the email address.
     * @return The email address.  A <code>String</code>
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     * @param email The new email address.  A <code>String</code>
     */
    public void setEmail(String email) {
        this.email = email;
    }

}

