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
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "unique_email"),
        @UniqueConstraint(columnNames = "username", name = "unique_username")
})
@Serdeable
public class User extends EntityPattern {

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String username;

    @NotNull
    @Column(nullable = false)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String password;

    @NotNull
    private boolean firstAccess = true;

    @ManyToOne
    @JoinColumn(
            name = "assignment_id",
            foreignKey = @ForeignKey(name = "fk_user_assignment"),
            nullable = false
    )
    private Assignment assignment;

}
