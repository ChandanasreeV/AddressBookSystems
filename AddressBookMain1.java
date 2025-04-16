package AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Contact class
class ContactDetails {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public ContactDetails(String firstName, String lastName, String address, String city, String state,
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

    // Setters
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZip(String zip) { this.zip = zip; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }

    public String getFirstName() { return firstName; }

    @Override
    public String toString() {
        return "\n--- Contact Details ---" +
               "\nName      : " + firstName + " " + lastName +
               "\nAddress   : " + address + ", " + city + ", " + state + " - " + zip +
               "\nPhone     : " + phoneNumber +
               "\nEmail     : " + email;
    }
}

// Address Book class
class AddressBookService {
    private List<ContactDetails> contactList;

    public AddressBookService() {
        contactList = new ArrayList<>();
    }

    public void addContact(ContactDetails contact) {
        contactList.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (ContactDetails contact : contactList) {
                System.out.println(contact);
            }
        }
    }

    public void editContact(String firstName, Scanner scanner) {
        for (ContactDetails contact : contactList) {
            if (contact.getFirstName().equalsIgnoreCase(firstName)) {
                System.out.print("Enter new Last Name: ");
                contact.setLastName(scanner.nextLine());

                System.out.print("Enter new Address: ");
                contact.setAddress(scanner.nextLine());

                System.out.print("Enter new City: ");
                contact.setCity(scanner.nextLine());

                System.out.print("Enter new State: ");
                contact.setState(scanner.nextLine());

                System.out.print("Enter new ZIP: ");
                contact.setZip(scanner.nextLine());

                System.out.print("Enter new Phone Number: ");
                contact.setPhoneNumber(scanner.nextLine());

                System.out.print("Enter new Email: ");
                contact.setEmail(scanner.nextLine());

                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact with first name '" + firstName + "' not found.");
    }
}

// Main class
public class AddressBookMain1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBookService addressBook = new AddressBookService();
        String choice;

        do {
            System.out.println("\n--- Address Book Menu ---");
            System.out.println("1. Add New Contact");
            System.out.println("2. Show All Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Exit");
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

                    System.out.print("Enter ZIP: ");
                    String zip = scanner.nextLine();

                    System.out.print("Enter Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    ContactDetails newContact = new ContactDetails(firstName, lastName, address, city, state, zip, phone, email);
                    addressBook.addContact(newContact);
                    break;

                case "2":
                    addressBook.displayContacts();
                    break;

                case "3":
                    System.out.print("Enter First Name of the contact to edit: ");
                    String nameToEdit = scanner.nextLine();
                    addressBook.editContact(nameToEdit, scanner);
                    break;

                case "4":
                    System.out.println("Exiting Address Book.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (!choice.equals("4"));

        scanner.close();
    }
}
