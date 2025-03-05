package github.sagubr.commands;

import github.sagubr.entities.Permissions;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Serdeable
public class AssignmentCommand {

    @NotNull
    private UUID assignmentId;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private Set<Permissions> permissions;

}
