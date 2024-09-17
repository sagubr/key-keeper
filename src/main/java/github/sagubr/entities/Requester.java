package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "requesters", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "unique_email"),
        @UniqueConstraint(columnNames = "register", name = "unique_register")
})
@Serdeable
public class Requester extends EntityPattern {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String register;

    @ManyToOne
    @JoinColumn(
            name = "position_id",
            foreignKey = @ForeignKey(name = "fk_requester_position"),
            nullable = false
    )
    private Position position;

}
