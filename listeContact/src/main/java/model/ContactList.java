package model;

import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ContactList {

    List<Contact> contactList;

    public int lenght() {
        return contactList.size();
    }
}
