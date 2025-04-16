package AddressBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Contact class
class ContactData {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public ContactData(String firstName, String lastName, String address, String city, String state,
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

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAddress(String address) { this.address = address; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setZip(String zip) { this.zip = zip; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "\n--- Contact ---" +
               "\nName      : " + firstName + " " + lastName +
               "\nAddress   : " + address + ", " + city + ", " + state + " - " + zip +
               "\nPhone     : " + phoneNumber +
               "\nEmail     : " + email;
    }
}

// AddressBook service class
class ContactBook {
    private List<ContactData> contactList = new ArrayList<>();

    public void addContact(ContactData contact) {
        contactList.add(contact);
        System.out.println("Contact added.");
    }

    public void displayContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to display.");
        } else {
            for (ContactData c : contactList) {
                System.out.println(c);
            }
        }
    }

    public void editContact(String firstName, Scanner scanner) {
        for (ContactData contact : contactList) {
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

                System.out.println("Contact updated.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact(String firstName) {
        for (int i = 0; i < contactList.size(); i++) {
            if (contactList.get(i).getFirstName().equalsIgnoreCase(firstName)) {
                contactList.remove(i);
                System.out.println("Contact deleted.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

// Main class
public class AddressBookMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactBook book = new ContactBook();
        String option;

        do {
            System.out.println("\n--- Address Book ---");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("City: ");
                    String city = scanner.nextLine();
                    System.out.print("State: ");
                    String state = scanner.nextLine();
                    System.out.print("ZIP: ");
                    String zip = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    ContactData newContact = new ContactData(firstName, lastName, address, city, state, zip, phone, email);
                    book.addContact(newContact);
                    break;

                case "2":
                    book.displayContacts();
                    break;

                case "3":
                    System.out.print("Enter First Name of contact to edit: ");
                    String nameToEdit = scanner.nextLine();
                    book.editContact(nameToEdit, scanner);
                    break;

                case "4":
                    System.out.print("Enter First Name of contact to delete: ");
                    String nameToDelete = scanner.nextLine();
                    book.deleteContact(nameToDelete);
                    break;

                case "5":
                    System.out.println("Exiting Address Book.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (!option.equals("5"));

        scanner.close();
    }
}
