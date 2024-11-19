package service;

import dao.ContactDAO;
import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactDAO contactDAO;
    private final List<Contact> contactList = new ArrayList<>();

    @Autowired
    public ContactService(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    public List<Contact> getAllContacts() {
        return new ArrayList<>(contactList);
    }

    public Optional<Contact> getContactByName(String lastname) {
        return contactList.stream()
                .filter(contact -> contact.getLastName().equalsIgnoreCase(lastname))
                .findFirst();
    }

    public void addContact(Contact newContact) throws Exception {
        if (contactList.stream().anyMatch(contact ->
                contact.getLastName().equalsIgnoreCase(newContact.getLastName())
                        && contact.getFirstName().equalsIgnoreCase(newContact.getFirstName()))) {
            throw new Exception("Ce contact existe déjà !");
        }
        contactList.add(newContact);
    }

    public Optional<Contact> deleteContactByName(String lastname, String firstname) {
        Optional<Contact> contactOptional = contactList.stream()
                .filter(contact -> contact.getLastName().equalsIgnoreCase(lastname)
                        && contact.getFirstName().equalsIgnoreCase(firstname))
                .findFirst();

        contactOptional.ifPresent(contactList::remove);
        return contactOptional;
    }

    public int getNumberOfContacts() {
        return contactList.size();
    }
}
