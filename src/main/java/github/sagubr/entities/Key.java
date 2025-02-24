package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "keys", uniqueConstraints = {
        @UniqueConstraint(columnNames = "description", name = "unique_description"),
        @UniqueConstraint(columnNames = "code", name = "unique_code"),
})
@Serdeable
public class Key extends EntityPattern {

    @NotNull
    @Column(nullable = false, unique = true)
    private Long code;

    @NotNull
    @Column(nullable = false, unique = true)
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "location_id",
            foreignKey = @ForeignKey(name = "fk_key_location"),
            nullable = false
    )
    private Location location;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private KeyType keyType;
}
