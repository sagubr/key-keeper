package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "locations_type", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "unique_name")
})
@Serdeable
public class LocationType extends EntityPattern {

    @NotNull
    private String name;
}
