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

    public void addContact() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите номер: ");
        String phoneNumber = scanner.nextLine();

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

    public void editContact() {
        displayContacts();
        System.out.print("Введите имя контакта: ");
        String targetName = scanner.nextLine();

        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(targetName)) {
                System.out.print("Введите новый номер: ");
                String newPhoneNumber = scanner.nextLine();
                contact.setPhoneNumber(newPhoneNumber);

                System.out.println("Контакт отредактиован!\n");
                return;
            }
        }

        System.out.println("Контакт не найден.\n");
    }

    public void deleteContact() {
        displayContacts();
        System.out.print("Введите имя контакта: ");
        String targetName = scanner.nextLine();

        if (contacts.removeIf(contact -> contact.getName().equalsIgnoreCase(targetName)))
        System.out.println("Контакт удален!\n");
        else System.out.println("Нет такого контакта!\n");
    }

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить контакт");
            System.out.println("2. Отобразить контакты");
            System.out.println("3. Редактировать контакт");
            System.out.println("4. Удалить контакт");
            System.out.println("5. Выход");

            System.out.print("Ожидание ввода: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    contactBook.addContact();
                    break;
                case 2:
                    contactBook.displayContacts();
                    break;
                case 3:
                    contactBook.editContact();
                    break;
                case 4:
                    contactBook.deleteContact();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Неправильный ввод1.\n");
            }
        }
    }
}