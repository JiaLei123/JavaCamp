package jialei.com.spitter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Spitter {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    public Spitter(String username, String password, String firstName, String lastName, String email) {
        this(null, username, password, firstName, lastName, email);
    }
}
