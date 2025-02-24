package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "assignment", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "unique_name")
})
@Serdeable
public class Assignment extends EntityPattern {

    @NotNull
    @Column(nullable = false, unique = true)
    private String name;

    @ElementCollection
    @Column(name = "roles")
    private Set<Roles> roles;

}

