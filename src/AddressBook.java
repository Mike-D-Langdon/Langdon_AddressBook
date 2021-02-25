import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * This class simulates an address book using a <code>TreeMap<>()</code>.
 * It is designed to be used as a singleton object.
 * @author Michael Langdon
 * @since 02/15/2021
 */
public final class AddressBook {

    // This is the only instance of this class since it is a singleton class.
    private static AddressBook INSTANCE;

    // Using a TreeMap since the values are stored in order and retrieval/removal is quick.
    private TreeMap<String, AddressEntry> addressEntryList;

    /**
     * Sets up a list to hold entries for the address book.
     * Must be called by <code>getInstance()</code>.
     */
    private AddressBook() {
        addressEntryList = new TreeMap<>();
    }

    /**
     * Calls the constructor to instantiate the address book.
     *
     * @return an instance of the <code>AddressBook</code> class.
     */
    public static AddressBook getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AddressBook();
        }
        return INSTANCE;
    }

    /**
     * Adds an entry to the address book.
     *
     * @param addressEntry an AddressEntry object.
     */
    public void add(AddressEntry addressEntry) {
        // Entries are indexed by the last name
        addressEntryList.put(addressEntry.getLastName(), addressEntry);
    }

    /**
     * Calls the <code>toString()</code> method for each item in the address book
     * and prints it to the screen.
     */
    public void list() {
        // Create a set of the entries
        Set set = addressEntryList.entrySet();
        // Create an iterator
        Iterator iterator = set.iterator();
        // Iterate through the set
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(entry.getValue());
        }
    }

    /**
     * Searches the address book for an entry indexed by the given last name.  If
     * more than one entry is found, a set of all matches is displayed.
     *
     * @param startOfLastName A <code>String</code> used as a key to search the entries
     *                        in the address book.
     */
    public void find(String startOfLastName) {
        // Create a set of the entries from startOfLastName to end of addressEntryList
        Set set = addressEntryList.subMap(startOfLastName, true, addressEntryList.lastKey(), true).entrySet();
        // Create an iterator
        Iterator iterator = set.iterator();
        // To enumerate the results
        int i = 0;
        // Iterate through the set and print out the results
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println(++i + ":");
            System.out.println(entry.getValue());
        }
    }

    /**
     * Removes the entry indexed by the given last name.
     *
     * @param startOfLastName A <code>String</code> used as a key to search the entries
     *                        in the address book.
     */
    public void remove(String startOfLastName) {
        addressEntryList.remove(startOfLastName);
    }

    /**
     * Reads a file listing a file in the form:
     * first name
     * last name
     * street
     * city
     * state
     * zip
     * phone
     * email
     *
     * @param filename Name of the file containing the address entries to be added
     *                 to the address book.  Must be a txt file with each field
     *                 of the address entry on a separate line.
     * @throws IOException if the file is not found or is not formatted as above.
     */
    public void readFromFile(String filename) throws IOException {
        // Stores a single line read from the file.
        String line;
        // Stores the first name, given on first (9th, 17th...) line of file, if valid.
        String lineFirstName;
        // Stores the last name, given on second (10th, 18th...) line of file, if valid.
        String lineLastName;
        // Stores the street, given on third (11th, 19th...) line of file, if valid.
        String lineStreet;
        // Stores the city, given on the fourth (12th, 20th...) line of file, if valid.
        String lineCity;
        // Stores the state, given on the fifth (13th, 21st...) line of file, if valid.
        String lineState;
        // Stores the zip, given on the sixth (14th, 22nd...) line of file, if valid.
        Integer lineZip;
        // Stores the phone number, given on the seventh (15th, 23rd...) line of file, if valid.
        String linePhone;
        // Stores the email, given on the eighth (16th, 24th...) line of file, if valid.
        String lineEmail;

        try {
            // Open file with FileReader
            FileReader fileReader = new FileReader(filename);
            // Create BufferedReader from FileReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read contents of file until end of file
            while ((line = bufferedReader.readLine()) != null) {
                lineFirstName = line;
                // Get the next lines.
                lineLastName = bufferedReader.readLine();
                lineStreet = bufferedReader.readLine();
                lineCity = bufferedReader.readLine();
                lineState = bufferedReader.readLine();
                // Must first convert string value in line to Integer.
                lineZip = Integer.valueOf(bufferedReader.readLine());
                linePhone = bufferedReader.readLine();
                lineEmail = bufferedReader.readLine();

                // Call AddressEntry constructor for this group of related lines.
                AddressEntry addressEntry = new AddressEntry(lineFirstName, lineLastName, lineStreet, lineCity, lineState, lineZip,
                        linePhone, lineEmail);
                // Add this entry to the address book.
                addressEntryList.put(addressEntry.getLastName(), addressEntry);
            }
            // Close streams
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}


