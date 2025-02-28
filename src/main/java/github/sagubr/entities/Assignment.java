package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assignment", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "unique_name")
})
@Serdeable
public class Assignment extends EntityPattern {

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @ElementCollection(targetClass = Permissions.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "assignment_permissions",
            joinColumns = @JoinColumn(name = "assignment_id")
    )
    @Enumerated(EnumType.STRING)
    private Set<Permissions> permissions = new HashSet<>();

}

