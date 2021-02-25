import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class AddressEntryTest {
    // Set up
    AddressEntry addressEntry1 = new AddressEntry("Peggy",
            "Sue", "123 Broadway St.", "Missoula",
            "MO", 44354, "498-355-8675", "p.sue@email.com");

    @Test
    void testToString_Prints() {
        System.out.println(addressEntry1);
        System.out.println("Should print 1 entry.");
    }

    @Test
    @DisplayName("Change the name.")
    void testSetFirstName_Pass() {
        addressEntry1.setFirstName("Chazz");
        assertNotEquals("Peggy", addressEntry1.getFirstName());
    }

    @Test
    void testGetFirstName_Pass() {
        assertEquals("Peggy", addressEntry1.getFirstName());
    }

    @Test
    @DisplayName("Supposed to fail.  Names should not match.")
    void testGetFirstName_Fail() {
        assertEquals("Jimbo", addressEntry1.getLastName());
    }

    @Test
    void testSetLastName_Pass() {
        addressEntry1.setLastName("Raskolnikov");
        assertEquals("Raskolnikov", addressEntry1.getLastName());
    }

    @Test
    @DisplayName("Supposed to fail.  Names should not match.")
    void testSetLastName_Fail() {
        addressEntry1.setLastName("Raskolnikov");
        assertEquals("Picasso", addressEntry1.getLastName());
    }

    @Test
    void testGetLastName_Pass() {
        assertEquals("Sue", addressEntry1.getLastName());
    }

    @Test
    @DisplayName("Supposed to fail.  Names should not match.")
    void testGetLastName_Fail() {
        assertEquals("Wednesday", addressEntry1.getLastName());
    }

    @Test
    void testGetStreet_Pass() {
        assertEquals("123 Broadway St.", addressEntry1.getStreet());
    }

    @Test
    @DisplayName("Supposed to fail.")
    void testGetStreet_Fail() {
        assertEquals("585 Electric Ave.", addressEntry1.getStreet());
    }

    @Test
    void testSetStreet_Pass() {
        addressEntry1.setStreet("1428 Elm St.");
        assertEquals("1428 Elm St.", addressEntry1.getStreet());
    }

    @Test
    @DisplayName("Should fail.")
    void testSetStreet_Fail() {
        addressEntry1.setStreet("1428 Elm St.");
        assertEquals("68 Oak St.", addressEntry1.getStreet());
    }

    @Test
    void testGetCity_Pass() {
        assertEquals("Missoula", addressEntry1.getCity());
    }

    @Test
    @DisplayName("Supposed to fail.")
    void testGetCity_Fail() {
        assertEquals("Synecdoche", addressEntry1.getCity());
    }

    @Test
    void testSetCity_Pass() {
        addressEntry1.setCity("Synecdoche");
        assertEquals("Synecdoche", addressEntry1.getCity());
    }

    @Test
    @DisplayName("Supposed to fail.")
    void testSetCity_Fail() {
        addressEntry1.setCity("Synecdoche");
        assertEquals("Devon on Trent", addressEntry1.getCity());
    }

    @Test
    void testGetState_Pass() {
        assertEquals("MO", addressEntry1.getState());
    }

    @Test
    @DisplayName("Supposed to fail.")
    void testGetState_Fail() {
        assertEquals("YO", addressEntry1.getState());
    }

    @Test
    void testSetState_Pass() {
        addressEntry1.setState("HC");
        assertEquals("HC", addressEntry1.getState());
    }

    @Test
    @DisplayName("Supposed to fail.")
    void testSetState_Fail() {
        addressEntry1.setState("HC");
        assertEquals("XZ", addressEntry1.getState());
    }

    @Test
    void testGetZip_Pass() {
        assertEquals(44354, addressEntry1.getZip());
    }

    @Test
    @DisplayName("Fail due to incorrect type.")
    void testGetZip_Fail() {
        assertEquals("44354", addressEntry1.getZip());
    }

    @Test
    void testSetZip_Pass() {
        addressEntry1.setZip(83383);
        assertEquals(83383, addressEntry1.getZip());
    }

    @Test
    @DisplayName("Fail due to incorrect type.")
    void testSetZip_Fail() {
        addressEntry1.setZip(Integer.valueOf("fdfdd"));
        assertEquals("fdfdd", addressEntry1.getZip());
    }

    @Test
    void testGetPhone_Pass() {
        assertEquals("498-355-8675", addressEntry1.getPhone());
    }

    @Test
    @DisplayName("Supposed to fail.")
    void testGetPhone_Fail() {
        assertEquals("800-355-8675", addressEntry1.getPhone());
    }

    @Test
    void testSetPhone_Pass() {
        addressEntry1.setPhone("999-555-5858");
        assertEquals("999-555-5858", addressEntry1.getPhone());
    }

    @Test
    @DisplayName("Supposed to fail.")
    void testSetPhone_Fail() {
        addressEntry1.setPhone("999-555-5858");
        assertEquals("499-555-5858", addressEntry1.getPhone());
    }

    @Test
    void testGetEmail_Pass() {
        assertEquals("p.sue@email.com", addressEntry1.getEmail());
    }

    @Test
    @DisplayName("Supposed to fail.")
    void testGetEmail_Fail() {
        assertEquals("ronnie.woo@email.com", addressEntry1.getEmail());
    }

    @Test
    void testSetEmail_Pass() {
        addressEntry1.setEmail("ronnie.woo@email.com");
        assertEquals("ronnie.woo@email.com", addressEntry1.getEmail());
    }

    @Test
    @DisplayName("Supposed to fail.")
    void testSetEmail_Fail() {
        addressEntry1.setEmail("ronnie.woo@email.com");
        assertEquals("mama.cass@email.com", addressEntry1.getEmail());
    }
}
