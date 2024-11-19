package service;

import dao.ContactDAO;
import dao.ContactListDAO;
import model.Contact;
import model.ContactList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private final ContactDAO contactDAO;

    @Autowired
    private final ContactListDAO contactListDAO;

    public ContactService(ContactListDAO contactListDAO, ContactDAO contactDAO) {
        this.contactListDAO = contactListDAO;
        this.contactDAO = contactDAO;
    }
    @Autowired
    ContactList contactList;

    @Autowired
    Contact contact;


    public List<Contact> getAllContacts() {
        return (List<Contact>) contactList;
    }

    public List<Contact> getContactByName(String lastname) {
        return Contact.id;
    }

    public Contact addContact(String lastName, String firstName) {
        contactList.(lastName, firstName);
        return contact;
    }

    public Contact deleteContactByName(String lastName, String firstName){
        contactList.delete(lastName, firstName);
        return contact;
    }

    public int getNumberOfContacts() {
        return contactList.lenght();
    }
}
