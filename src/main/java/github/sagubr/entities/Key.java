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
@Table(name = "keys", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "unique_name"),
})
@Serdeable
public class Key extends EntityPattern{

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(
            name = "environment_id",
            foreignKey = @ForeignKey(name = "fk_key_environment"),
            nullable = false
    )
    private Environment environment;
}
