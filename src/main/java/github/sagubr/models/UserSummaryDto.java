package github.sagubr.models;

import github.sagubr.entities.Assignment;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record UserSummaryDto(
        String name,
        String username,
        String email,
        String assignment) {
}
