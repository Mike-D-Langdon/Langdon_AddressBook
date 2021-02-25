import java.io.IOException;

/**
 * Driver class for setting up an address book.
 * @author Michael Langdon
 * @since 02/15/2021
 */
public class AddressBookApplication {

    /**
     * Starting point of the app.  Displays a menu of options from which a user
     * can select, and runs the command selected.  After the command finishes the
     * menu is displayed again.  The program ends when the user selects the option
     * to quit.
     * @param args command line arguments.  Not used.
     * @throws IOException if the file is unable to be opened.
     */
    public static void main(String[] args) throws IOException {
        // Default the selection with 'e', which lists the current address entries.
        char selection = 'e';
        // Display the menu options until 'f' for 'quit' is selected.
        while (selection != 'f') {
            selection = Menu.displayMenu();
        }
    }

    /**
     * Hard-coded entries that are then added to the address book.  Only used to test.
     * @param addressBook The address book instance to add the entries to.
     */
    public static void initAddressBookExercise(AddressBook addressBook) {
        AddressEntry addressEntry1 = new AddressEntry("Peggy",
                "Sue", "123 Broadway St.", "Missoula",
                "MO", 44354, "498-355-8675", "p.sue@email.com");
        AddressEntry addressEntry2 = new AddressEntry("Tammy",
                "Lee", "44 Main St.", "Salem",
                "TX", 77334, "266-857-2109", "t.lee@email.com");
        addressBook.add(addressEntry1);
        addressBook.add(addressEntry2);

        addressBook.list();
    }
}

