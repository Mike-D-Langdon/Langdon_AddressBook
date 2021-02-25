import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class AddressBookTest {

    // Set up:
    AddressBook ab = AddressBook.getInstance();
    AddressEntry addressEntry1 = new AddressEntry("Peggy",
            "Sue", "123 Broadway St.", "Missoula",
            "MO", 44354, "498-355-8675", "p.sue@email.com");
    AddressEntry addressEntry2 = new AddressEntry("Tammy",
            "Lee", "44 Main St.", "Salem",
            "TX", 77334, "266-857-2109", "t.lee@email.com");

    @Test
    @DisplayName("Test add() is not null after adding an entry.")
    void testAdd_NotNull() {
        // Add an entry to list
        ab.add(addressEntry1);
        // Check if list is null/empty
        assertNotNull(ab);
    }

    @Test
    @DisplayName("Test that a second entry was added.")
    void testAdd_aSecond() {
        ab.add(addressEntry1);
        ab.add(addressEntry2);
        ab.list();
        System.out.println("Should be 2 items now");
    }

    @Test
    @DisplayName("Test that 2 items are listed.")
    void testList_TwoEntries() {
        ab.add(addressEntry1);
        ab.add(addressEntry2);
        ab.list();
        System.out.println("Should be 2 items listed");
    }

    @Test
    @DisplayName("Test that 1 item is listed.")
    void testList_OneEntry() {
        ab.add(addressEntry1);
        ab.list();
        System.out.println("Should be 1 item listed");
    }

    @Test
    void testFind_Fail() {
        ab.add(addressEntry1);
        ab.find("L");
        System.out.println("Should not find anything.");
    }

    @Test
    void testFind_Pass() {
        ab.add(addressEntry2);
        ab.find("L");
        System.out.println("Should find 1 entry.");
    }

    @Test
    @DisplayName("2 items added, listed.  1 item removed, listed.")
    void testRemove_OneItem() {
        ab.add(addressEntry1);
        ab.add(addressEntry2);
        ab.list();
        System.out.println("Should be 2 items listed.");
        ab.remove("Lee");
        ab.list();
        System.out.println("Should now be 1 item listed.");
    }

    @Test
    void testRemove_FromEmpty() {
        ab.remove("Se");
        assertNull(ab);
    }

    @Test
    @DisplayName("Enter an invalid file name.")
    void testReadFromFile_IOException() {
        assertThrows(IOException.class, () -> ab.readFromFile("nonexistant"));
    }

    @Test
    @DisplayName("Enter a valid file name.")
    void testReadFromFile_Pass() throws IOException {
        ab.readFromFile("/Users/room237/Desktop/Spring2021/CS401/AddressBookApplication/src/file_with_addresses.txt");
        ab.list();
        System.out.println("Should list 2 items.");
    }
}
