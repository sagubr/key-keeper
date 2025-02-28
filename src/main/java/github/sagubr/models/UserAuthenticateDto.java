package github.sagubr.models;

import github.sagubr.entities.Assignment;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record UserAuthenticateDto(String username,
                                  String password,
                                  Assignment assignment) {
}