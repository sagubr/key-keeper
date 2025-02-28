package github.sagubr.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reservations")
@Serdeable
public class Reservation extends EntityPattern {

    @ManyToOne
    @JoinColumn(
            name = "permission_id",
            foreignKey = @ForeignKey(name = "fk_reservation_permission")
    )
    private Permission permission;

    @ManyToOne
    @JoinColumn(
            name = "requester_id",
            foreignKey = @ForeignKey(name = "fk_reservation_requester"),
            nullable = false
    )
    private Requester requester;

    @ManyToOne
    @JoinColumn(
            name = "location_id",
            foreignKey = @ForeignKey(name = "fk_reservation_location"),
            nullable = false
    )
    private Location location;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "fk_reservation_user")
    )
    private User user;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    @Column(nullable = false)
    private ZonedDateTime startDateTime;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    @Column(nullable = false)
    private ZonedDateTime endDateTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(name = "notification_sent", nullable = false)
    private boolean notificationSent = false;

    public boolean isOverdue() {
        return ZonedDateTime.now().isAfter(this.endDateTime);
    }

    public String getStartDateTimeFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return startDateTime != null ? startDateTime.format(formatter) : null;
    }

    public String getEndDateTimeFormatted() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return endDateTime != null ? endDateTime.format(formatter) : null;
    }

}
