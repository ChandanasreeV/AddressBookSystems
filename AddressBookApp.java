package AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address, String city, String state,
                   String zip, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nContact Details:" +
                "\nName: " + firstName + " " + lastName +
                "\nAddress: " + address + ", " + city + ", " + state + " - " + zip +
                "\nPhone: " + phoneNumber +
                "\nEmail: " + email;
    }
}

public class AddressBookApp {
    private List<Contact> contacts;

    public AddressBookApp() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void showContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts in address book.");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public static void main(String[] args) {
        AddressBookApp addressBook = new AddressBookApp();
        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Show Contacts");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter First Name: ");
                    String firstName = scanner.nextLine();

                    System.out.print("Enter Last Name: ");
                    String lastName = scanner.nextLine();

                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();

                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();

                    System.out.print("Enter State: ");
                    String state = scanner.nextLine();

                    System.out.print("Enter Zip: ");
                    String zip = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    Contact contact = new Contact(firstName, lastName, address, city, state, zip, phone, email);
                    addressBook.addContact(contact);
                    break;

                case "2":
                    addressBook.showContacts();
                    break;

                case "3":
                    System.out.println("Exiting Address Book.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (!choice.equals("3"));

        scanner.close();
    }
}

