package controller;

import model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import service.ContactService;

import java.util.List;
import java.util.Scanner;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    Scanner input = new Scanner(System.in);

    public  ShowListContacts() {

    }

    public Contact ShowContactByName() {

    }

}
