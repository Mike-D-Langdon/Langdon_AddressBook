import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    // Set up an AddressBook to test with
    AddressBook ab = AddressBook.getInstance();
    AddressEntry addressEntry1 = new AddressEntry("Peggy",
            "Sue", "123 Broadway St.", "Missoula",
            "MO", 44354, "498-355-8675", "p.sue@email.com");


    @Test
    void testDisplayMenu_ThrowsException() {
        Exception exception = assertThrows(IOException.class, () ->
                Menu.displayMenu());
        assertEquals("char expected", exception.getStackTrace());
    }


    @Test
    void testLoadSelected_Pass() throws IOException {
        Menu.loadSelected();
        System.out.println("Should see a prompt to enter a file name.");
    }

    @Test
    void testAddSelected() {
        Menu.addSelected();
        System.out.println("Should see a prompt to enter a first name.");
    }

    @Test
    void testRemoveSelected() {
        Menu.removeSelected();
        System.out.println("Should see a prompt to search for a last name.");
    }

    @Test
    void testFindSelected() {
        Menu.findSelected();
        System.out.println("Should see a prompt to search for a last name.");
    }

    @Test
    void testListSelected() {
        ab.add(addressEntry1);
        Menu.listSelected();
        System.out.println("Should see a listing of 1 entry.");
    }

    @Test
    void testQuitSelected() {
        Menu.quitSelected();
        System.out.println("Should see a message saying Goodbye!");
    }

    @Test
    void testPrompt_FirstName() {
        Menu.prompt_FirstName();
        System.out.println("Should see a message prompting for first name.");
    }

    @Test
    void testPrompt_LastName() {
        Menu.prompt_LastName();
        System.out.println("Should see a message prompting for last name.");
    }

    @Test
    void testPrompt_Street() {
        Menu.prompt_Street();
        System.out.println("Should see a message prompting for street.");
    }

    @Test
    void testPrompt_City() {
        Menu.prompt_City();
        System.out.println("Should see a message prompting for city.");
    }

    @Test
    void testPrompt_State() {
        Menu.prompt_State();
        System.out.println("Should see a message prompting for state.");
    }

    @Test
    void testPrompt_Zip() {
        Menu.prompt_Zip();
        System.out.println("Should see a message prompting for zip code.");
    }

    @Test
    void testPrompt_Telephone() {
        Menu.prompt_Telephone();
        System.out.println("Should see a message prompting for telephone number.");
    }

    @Test
    void testPrompt_Email() {
        Menu.prompt_Email();
        System.out.println("Should see a message prompting for email address.");
    }
}
