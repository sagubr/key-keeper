package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
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

    @ElementCollection(targetClass = Screen.class, fetch = FetchType.EAGER)
    @CollectionTable(
            name = "assignment_screens",
            joinColumns = @JoinColumn(name = "assignment_id")
    )
    @Enumerated(EnumType.STRING)
    @Column(name = "screen")
    private Set<Screen> screens;

}

