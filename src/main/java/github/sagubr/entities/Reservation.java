package github.sagubr.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reservations", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name", name = "unique_name"),
})
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
            name = "environment_id",
            foreignKey = @ForeignKey(name = "fk_reservation_environment"),
            nullable = false
    )
    private Environment environment;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "fk_reservation_user"),
            nullable = false)
    private User user;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDateTime;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDateTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;
}
