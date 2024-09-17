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
@Table(name = "environments", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "unique_name"),
})
@Serdeable
public class Environment extends EntityPattern {

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "place_id",
            foreignKey = @ForeignKey(name = "fk_position_place"),
            nullable = false
    )
    private Place place;

    @ManyToOne
    @JoinColumn(
            name = "type_environment_id",
            foreignKey = @ForeignKey(name = "fk_environment_type_environment"),
            nullable = false
    )
    private TypeEnvironment typeEnvironment;

}
