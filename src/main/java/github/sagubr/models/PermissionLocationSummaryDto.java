package github.sagubr.models;

import github.sagubr.entities.Location;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;

import java.time.ZonedDateTime;
import java.util.UUID;

@Serdeable
public record PermissionLocationSummaryDto(UUID permissionId, @NotNull Location location, ZonedDateTime startDateTime,
                                           ZonedDateTime endDateTime) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PermissionLocationSummaryDto that = (PermissionLocationSummaryDto) o;
        return location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }

}
