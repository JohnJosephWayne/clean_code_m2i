package dao;

import model.Contact;
import java.util.Optional;

public interface ContactDAO {
    Optional<Contact> findByName(String lastname, String firstname);
    Optional<Contact> deleteByName(String lastname, String firstname);
    Optional<Contact> getByName(String lastname);

}
