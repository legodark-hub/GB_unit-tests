package seminar5.ContactBook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactBookTest {
    private ContactBook contactBook;

    @BeforeEach
    public void setUp() {
        contactBook = new ContactBook();
    }

    @Test
    public void testAddContact() {
        contactBook.addContact("Иван", "123456789");

        List<Contact> contacts = contactBook.getContacts();
        assertEquals(1, contacts.size());

        Contact addedContact = contacts.get(0);
        assertEquals("Иван", addedContact.getName());
        assertEquals("123456789", addedContact.getPhoneNumber());
    }

    @Test
    public void testDisplayContactsEmpty() {
        String expectedOutput = "Контакты отсутсвуют.";
        assertEquals(expectedOutput, getConsoleOutput(() -> contactBook.displayContacts()));
    }

    @Test
    public void testDisplayContactsWithContacts() {
        contactBook.addContact("Алиса", "987654321");

        String expectedOutput =  "Имя: Алиса, Номер: 987654321";
        assertEquals(expectedOutput, getConsoleOutput(() -> contactBook.displayContacts()));
    }

    @Test
    public void testEditContact() {
        contactBook.addContact("Вася", "111222333");
        contactBook.editContact("Вася", "999888777");

        Contact editedContact = contactBook.getContacts().get(0);
        assertEquals("999888777", editedContact.getPhoneNumber());
    }

    @Test
    public void testEditContactNotFound() {
        String expectedOutput = "Контакт не найден.";
        assertEquals(expectedOutput, getConsoleOutput(() -> contactBook.editContact("Равшан", "999888777")));
    }

    @Test
    public void testDeleteContact() {
        contactBook.addContact("Вася Пупкин", "444555666");
        contactBook.deleteContact("Вася Пупкин");

        assertTrue(contactBook.getContacts().isEmpty());
    }

    @Test
    public void testDeleteContactNotFound() {
        String expectedOutput = "Нет такого контакта!";
        assertEquals(expectedOutput, getConsoleOutput(() -> contactBook.deleteContact("Вова")));
    }

    private String getConsoleOutput(Runnable action) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        action.run();
        System.setOut(System.out);

        return outputStream.toString().trim();
    }
}
