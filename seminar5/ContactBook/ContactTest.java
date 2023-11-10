package seminar5.ContactBook;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ContactTest {
     @Test
    void testContactConstructor() {
        Contact contact = new Contact("John Doe", "123456789");
        assertEquals("John Doe", contact.getName());
        assertEquals("123456789", contact.getPhoneNumber());
    }

    @Test
    void testSetPhoneNumber() {
        Contact contact = new Contact("John Doe", "123456789");
        contact.setPhoneNumber("987654321");
        assertEquals("987654321", contact.getPhoneNumber());
    }
}
