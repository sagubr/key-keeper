package github.sagubr.models;

import github.sagubr.entities.Assignment;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record UserDto(String email,
                      String name,
                      String password,
                      String username,
                      Assignment assignment) {
}