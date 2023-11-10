package seminar5.ContactBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactBook {
    private List<Contact> contacts;
    private Scanner scanner;

    public ContactBook() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact(String name, String phoneNumber) {
        Contact newContact = new Contact(name, phoneNumber);
        contacts.add(newContact);

        System.out.println("Контакт добавлен успешно!\n");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Контакты отсутсвуют.\n");
        } else {
            System.out.println("Список контактов:");
            for (Contact contact : contacts) {
                System.out.println("Имя: " + contact.getName() + ", Номер: " + contact.getPhoneNumber());
            }
            System.out.println();
        }
    }

    public void editContact(String targetName, String newNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(targetName)) {
                contact.setPhoneNumber(newNumber);
                System.out.println("Контакт отредактиован!\n");
                return;
            }
        }

        System.out.println("Контакт не найден.\n");
    }

    public void deleteContact(String targetName) {
        if (contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(targetName)))
        System.out.println("Контакт удален!\n");
        else System.out.println("Нет такого контакта!\n");
    }
}