package AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Contact class renamed to PersonContact
class PersonContact {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public PersonContact(String firstName, String lastName, String address, String city, String state,
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
        return "\n--- Contact Details ---" +
               "\nName      : " + firstName + " " + lastName +
               "\nAddress   : " + address + ", " + city + ", " + state + " - " + zip +
               "\nPhone     : " + phoneNumber +
               "\nEmail     : " + email;
    }
}

// AddressBook class renamed to ContactManager
class ContactManager {
    private List<PersonContact> contactList;

    public ContactManager() {
        contactList = new ArrayList<>();
    }

    public void addContact(PersonContact person) {
        contactList.add(person);
        System.out.println("Contact added successfully.");
    }

    public void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (PersonContact contact : contactList) {
                System.out.println(contact);
            }
        }
    }
}

// Main class (entry point) remains AddressBookMain
public class AddressBookMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();
        String choice;

        do {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add New Contact");
            System.out.println("2. Show All Contacts");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
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

                    System.out.print("Enter ZIP Code: ");
                    String zip = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    PersonContact newContact = new PersonContact(firstName, lastName, address, city, state, zip, phoneNumber, email);
                    manager.addContact(newContact);
                    break;

                case "2":
                    manager.displayContacts();
                    break;

                case "3":
                    System.out.println("Exiting Address Book.");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (!choice.equals("3"));

        scanner.close();
    }
}
