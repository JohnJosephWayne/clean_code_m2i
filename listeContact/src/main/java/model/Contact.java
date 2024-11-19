package model;

import lombok.*;

@Getter
@Setter
public class Contact {

    public static String lastname;
    public static String firstname;

    public void setLastName(String lastName) {
        Contact.lastname = lastName;
    }

    public void setFirstName(String firstName) {
        Contact.firstname = firstName;
    }

    public String getLastName() {
        return Contact.lastname;
    }

    public String getFirstName() {
        return Contact.firstname;
    }
}
