import java.io.IOException;
import java.util.Scanner;

/**
 * This class contains a group of prompts to acquire input from a user.
 * The input is used to fill out an address entry for the address book.
 * @author Michael Langdon
 * @since 02/15/2021
 */
public class Menu {
    // Shared instance of the address book.
    static AddressBook ab = AddressBook.getInstance();

    /**
     * Displays a list of options to choose from.  Calls the associated
     * method for the choice selected.
     */
    public static char displayMenu() throws IOException {
        System.out.println();
        System.out.println("*************************************");
        System.out.println("Please enter your menu selection.");
        System.out.println("a) Load From File");
        System.out.println("b) Add an Entry");
        System.out.println("c) Remove an Entry");
        System.out.println("d) Find by Last Name");
        System.out.println("e) List All Entries");
        System.out.println("f) Quit");
        System.out.println("*************************************");
        System.out.println();

        // Read in the letter chosen from the menu above
        // and call the appropriate method.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your selection > ");
        char selection = input.next().charAt(0);
        switch (selection) {
            case 'a':
                loadSelected();
                break;
            case 'b':
                addSelected();
                break;
            case 'c':
                removeSelected();
                break;
            case 'd':
                findSelected();
                break;
            case 'e':
                listSelected();
                break;
            case 'f':
                quitSelected();
                break;
            default:
                // Default to 'quit' if anything else selected.
                selection = 'f';
        }
        return selection;
    }

    /**
     * Asks for a file name then tries to load entries from the file
     * into the address book.
     * @throws IOException if file has an invalid name
     */
    public static void loadSelected() throws IOException {
        System.out.println("Enter a file name");
        // Read the file name
        Scanner filename = new Scanner(System.in);
        try {
            ab.readFromFile(filename.next());
        } catch (IOException e) {
            System.out.println("Invalid file name.  Try again.");;
        }
    }

    /**
     * Collects information from the user to use for an address entry which
     * is then added to the address book.  A confirmation message is given.
     */
    public static void addSelected() {
        // Gather the information needed to create a new address entry.
        String firstName = prompt_FirstName();
        String lastName = prompt_LastName();
        String street = prompt_Street();
        String city = prompt_City();
        String state = prompt_State();
        Integer zip = prompt_Zip();
        String phone = prompt_Telephone();
        String email = prompt_Email();
        // Add all of this information as an address entry in the address book.
        AddressEntry addressEntry = new AddressEntry(firstName, lastName, street, city, state, zip, phone, email);
        ab.add(addressEntry);
        // Give feedback
        System.out.println("Thank you.  The following contact has been added to your address book:");
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(street);
        System.out.println(city);
        System.out.println(state);
        System.out.println(zip);
        System.out.println(phone);
        System.out.println(email);
        System.out.println();
    }

    /**
     * Searches for the name entered by the user and presents a list of
     * results from which the user can select from to remove an entry
     * from the address book.  After the entry has been removed, the
     * search results are displayed again to confirm removal.
     */
    public static void removeSelected() {
        Scanner input = new Scanner(System.in);

        // Prompt for last name
        System.out.println("Enter the last name of the contact you wish to remove:");
        // Search for last name
        ab.find(input.next());
        System.out.println("Select the number of the entry you wish to remove:");
        // Remove the entry
        ab.remove(input.next());
        // Confirmation of removal
        System.out.println("The address has been removed from the address book.");
        // Display list again to confirm
        ab.find(input.next());
    }

    /**
     * Searches for the name entered by the user in the address book.
     */
    public static void findSelected() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter in all or the beginning of the last name of the contact you wish to find:");
        ab.find(input.next());
    }

    /**
     * Lists all the entries in the address book.
     */
    public static void listSelected() {
        ab.list();
    }

    /**
     * Ends the program.
     */
    public static void quitSelected() {
        System.out.println("Goodbye!");
    }

    /**
     * Prompts for a first name and reads it.
     * @return the name entered.
     */
    public static String prompt_FirstName() {
        Scanner input = new Scanner(System.in);
        System.out.println("First name: ");
        return input.nextLine();
    }

    /**
     * Prompts for a last name and reads it.
     * @return the name entered.
     */
    public static String prompt_LastName() {
        Scanner input = new Scanner(System.in);
        System.out.println("Last name: ");
        return input.nextLine();
    }

    /**
     * Prompts for a street address and reads it.
     * @return the street address entered.
     */
    public static String prompt_Street() {
        Scanner input = new Scanner(System.in);
        System.out.println("Street:");
        return input.nextLine();
    }

    /**
     * Prompts for a city and reads it.
     * @return the city entered.
     */
    public static String prompt_City() {
        Scanner input = new Scanner(System.in);
        System.out.println("City: ");
        return input.nextLine();
    }

    /**
     * Prompts for a state and reads it.
     * @return the state entered.
     */
    public static String prompt_State() {
        Scanner input = new Scanner(System.in);
        System.out.println("State: ");
        return input.nextLine();
    }

    /**
     * Prompts for a zip code and reads it.  If something other than an integer is entered
     * the prompt displays again.
     * @return an integer converted from the string entered.
     */
    public static int prompt_Zip() {
        Scanner input = new Scanner(System.in);
        int zip;
        do {
            System.out.println("Zip: ");
            // Keep asking until an integer is given.  Not checking for valid zip codes.
            while ((!input.hasNextInt())) {
                String tryAgain = input.next();
                System.out.printf("%s is not a valid zip code.", tryAgain);
                System.out.println();
                System.out.println("Please enter only numerals for the zip code.");
            }
            zip = input.nextInt();
        } while (zip < 0);   // We only want positive integer values for zip codes.
        return zip;
    }

    /**
     * Prompts for a telephone number and reads it.
     * @return the phone number entered.
     */
    public static String prompt_Telephone() {
        Scanner input = new Scanner(System.in);
        System.out.println("Telephone: xxx-aaa-bbbb");
        return input.nextLine();
    }

    /**
     * Prompts for an email and reads it.
     * @return the email address entered.
     */
    public static String prompt_Email() {
        Scanner input = new Scanner(System.in);
        System.out.println("Email: ");
        return input.nextLine();
    }

}


