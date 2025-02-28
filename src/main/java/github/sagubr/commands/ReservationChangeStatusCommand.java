package github.sagubr.commands;

import github.sagubr.entities.Status;
import io.micronaut.serde.annotation.Serdeable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Serdeable
public class ReservationChangeStatusCommand {

    UUID reservationId;

    Status status;

}
