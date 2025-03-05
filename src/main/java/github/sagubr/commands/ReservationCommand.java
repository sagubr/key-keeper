package github.sagubr.commands;

import github.sagubr.entities.Key;
import github.sagubr.entities.Requester;
import github.sagubr.entities.Status;
import github.sagubr.models.PermissionLocationSummaryDto;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@Serdeable
public class ReservationCommand {

    @NotNull
    private Requester requester;

    @NotNull
    private Status status;

    @NotNull
    private PermissionLocationSummaryDto permission;

    @NotNull
    private Key key;

    @NotNull
    private ZonedDateTime startDateTime;

    @NotNull
    private ZonedDateTime endDateTime;

}
