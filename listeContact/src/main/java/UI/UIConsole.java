package UI;

import dao.ContactDAO;
import model.Contact;

import service.ContactService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static model.Contact.firstname;
import static model.Contact.lastname;

public class UIConsole {
    private final ContactService contactService;
    
    private final Scanner scanner = new Scanner(System.in);
    private ContactDAO contactDAO;

    public UIConsole(ContactService contactService) {
        this.contactService = contactService;
    }

    List<Contact> contactList = new java.util.ArrayList<>(List.of());

    public void run() {
        int choice;
        do {
            displayMenu();
            System.out.print("Entrez votre choix : ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer after integer input

            switch (choice) {
                case 1 -> {
                    try {
                        addContact();
                    } catch (Exception e) {
                        System.err.println("Erreur lors de l'ajout du contact : " + e.getMessage());
                    }
                }
                case 2 -> listAllContacts();
                case 3 -> getContactByName(lastname);
                case 4 -> deleteContactByName(lastname, firstname);
                case 5 -> displayNumberOfContacts();
                case 6 -> System.out.println("Programme terminé. À bientôt !");
                default -> System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choice != 6);
    }

    private void displayMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Ajouter un contact");
        System.out.println("2. Lister tous les contacts");
        System.out.println("3. Rechercher un contact par nom");
        System.out.println("4. Supprimer un contact par nom et prénom");
        System.out.println("5. Afficher le nombre de contacts");
        System.out.println("6. Quitter le programme");
        System.out.println("============");
    }

    private void addContact() {
        System.out.print("Entrez le nom du contact : ");
        String lastName = scanner.nextLine();
        System.out.print("Entrez le prénom du contact : ");
        String firstName = scanner.nextLine();

        Contact newContact = new Contact();
        newContact.setLastName(lastName);
        newContact.setFirstName(firstName);

        try {
            contactService.addContact(newContact);
            System.out.println("Contact ajouté avec succès !");
        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout du contact : " + e.getMessage());
        }
    }

    private void listAllContacts() {
        List<Contact> contactList = contactService.getAllContacts();
        if (contactList.isEmpty()) {
            System.out.println("Aucun contact à afficher.");
        } else {
            System.out.println("Liste des contacts :");
            contactList.forEach(contact -> System.out.println(contact.getLastName() + " " + contact.getFirstName()));
        }
    } 

    public Optional<Contact> getContactByName(String lastname) {
        return contactDAO.getByName(lastname); // Directement depuis le DAO
    }

    public Optional<Contact> deleteContactByName(String lastname, String firstname) {
        Optional<Contact> contactOptional = contactDAO.findByName(lastname, firstname);
        contactOptional.ifPresent(contact -> {
            contactDAO.deleteByName(lastname, firstname);
            contactList.remove(contact); // Mettre à jour la liste locale si nécessaire
        });
        return contactOptional;
    }
    private void displayNumberOfContacts() {
        int numberOfContacts = contactService.getNumberOfContacts();
        System.out.println("Nombre total de contacts : " + numberOfContacts);
    }
}
