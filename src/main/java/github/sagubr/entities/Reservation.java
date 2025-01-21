package github.sagubr.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservations")
@Serdeable
public class Reservation extends EntityPattern {

    @ManyToOne
    @JoinColumn(
            name = "permission_id",
            foreignKey = @ForeignKey(name = "fk_reservation_permission"),
            nullable = false
    )
    private Permission permission;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "fk_reservation_user"),
            nullable = false)
    private User user;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "UTC")
    @Column(nullable = false)
    private ZonedDateTime startDateTime;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "UTC")
    @Column(nullable = false)
    private ZonedDateTime endDateTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}
