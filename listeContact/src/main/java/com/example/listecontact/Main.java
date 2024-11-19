package com.example.listecontact;

import UI.UIConsole;
import dao.ContactDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ContactService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ContactService contactService = context.getBean(ContactService.class);
        UIConsole uiConsole = new UIConsole(contactService);

        uiConsole.run();
    }
}
