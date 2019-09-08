package jialei.com.spitter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Spitter {
    private Long id;

    @NotNull
    @Size(min = 5, max = 16)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    public Spitter(String username, String password, String firstName, String lastName, String email) {
        this(null, username, password, firstName, lastName, email);
    }
}
