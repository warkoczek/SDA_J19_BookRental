package pl.awarkoczewski.friends.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Friend {
    @Setter
    private Long id;

    private String firstName;
    private String lastName;
    @Setter
    private String email;

    public String getFullName(){
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
