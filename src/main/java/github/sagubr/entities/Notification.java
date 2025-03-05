package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "notifications",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "reservation", name = "unique_reservation")
        }
)
@Serdeable
public class Notification extends EntityPattern {

    //TODO: Problema com essa classe. Ela deveria ser agnóstica e está acoplada com Reservation. Reservation deveria ir em metadata. Preciso inverter pra reservation conter notification

    //TODO: Converter para Enum
    @NotNull
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(
            name = "reservation_id",
            unique = true,
            foreignKey = @ForeignKey(name = "fk_notification_reservation")
    )
    private Reservation reservation;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, String> metadata;

    private boolean read = false;

    private boolean send = false;

}
