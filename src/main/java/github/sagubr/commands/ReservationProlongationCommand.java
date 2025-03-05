package github.sagubr.commands;


import io.micronaut.serde.annotation.Serdeable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.UUID;


@Getter
@AllArgsConstructor
@Serdeable
public class ReservationProlongationCommand {

    @NotNull
    private UUID reservationId;

    @NotNull
    private ZonedDateTime startDateTime;

    private ZonedDateTime endDateTime;

}