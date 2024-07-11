package github.sagubr.entities.dtos;


import github.sagubr.entities.Roles;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class UserDto {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    private final Set<Roles> role;

    public UserDto(String username, String password, Set<Roles> role) {
        this.role = role;
        this.password = password;
        this.username = username;
    }

    public @NotBlank String getUsername() {
        return username;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public Set<Roles> getRole() {
        return role;
    }
}