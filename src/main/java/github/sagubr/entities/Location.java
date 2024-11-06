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
@Table(name = "locations", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "unique_name"),
})
@Serdeable
public class Location extends EntityPattern {

    @NotNull
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "facility_id",
            foreignKey = @ForeignKey(name = "fk_location_facility")
    )
    private Facility facility;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "location_type_id",
            foreignKey = @ForeignKey(name = "fk_location_location_type")
    )
    private LocationType locationType;

}
