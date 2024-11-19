package model;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contact {

    public static List<Contact> id;
    public static String lastname;
    public static String firstname;

    public Contact(String lastName, String firstName) {
    }
}
