package github.sagubr.model;

import github.sagubr.entities.Assignment;
import github.sagubr.entities.Roles;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Serdeable
public class UserDto {

    private String email;
    private String name;
    private String password;
    private String username;
    private Assignment assignment;

    public UserDto(String username, String password, Assignment assignment) {
        this.password = password;
        this.assignment = assignment;
        this.username = username;
    }

}