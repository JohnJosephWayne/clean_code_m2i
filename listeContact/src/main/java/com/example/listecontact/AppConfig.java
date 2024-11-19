package com.example.listecontact;

import dao.ContactDAO;
import model.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.ContactService;

import java.util.Optional;

@Configuration
@ComponentScan(basePackages = {"dao", "service", "model"})
public class AppConfig {

    @Bean
    public ContactDAO contactDAO() {
        return new ContactDAO() {
            @Override
            public Optional<Contact> findByName(String lastname, String firstname) {
                return Optional.empty();
            }

            @Override
            public Optional<Contact> deleteByName(String lastname, String firstname) {
                return Optional.empty();
            }

            @Override
            public Optional<Contact> getByName(String lastname) {
                return Optional.empty();
            }
        }; // Replace with your actual DAO implementation
    }

    @Bean
    public ContactService contactService(ContactDAO contactDAO) {
        return new ContactService(contactDAO);
    }

    @Bean
    public Contact contact() {
        return new Contact();
    }
}
