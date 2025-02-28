package github.sagubr.commands;

import github.sagubr.entities.Permissions;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.HashSet;
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
