package github.sagubr.models;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Serdeable
public class LocationDto {

    private UUID id;
    private String name;
    private String description;
    private String facility;
    private String locationType;
    private Integer maxCapacity;
    private boolean isRestricted;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private List<String> responsibles;

    public LocationDto(UUID id, String name, String description, String facility, String locationType, Integer maxCapacity,
                       boolean isRestricted, LocalTime openingTime, LocalTime closingTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.facility = facility;
        this.locationType = locationType;
        this.maxCapacity = maxCapacity;
        this.isRestricted = isRestricted;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.responsibles = Collections.emptyList();
    }
}
