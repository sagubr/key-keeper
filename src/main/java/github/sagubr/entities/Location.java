package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

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
    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "facility_id",
            foreignKey = @ForeignKey(name = "fk_location_facility"),
            nullable = false
    )
    private Facility facility;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "location_type_id",
            foreignKey = @ForeignKey(name = "fk_location_location_type"),
            nullable = false
    )
    private LocationType locationType;

    private Integer maxCapacity;

    private boolean isRestricted;

    private LocalTime openingTime;

    private LocalTime closingTime;

    @OneToMany
    @JoinColumn(name = "requester_id")
    private List<Requester> responsibles;

}
