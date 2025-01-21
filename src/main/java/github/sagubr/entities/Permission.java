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
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "permissions")
@Serdeable
public class Permission extends EntityPattern {

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "location_id",
            foreignKey = @ForeignKey(name = "fk_permission_location"),
            nullable = false
    )
    private Location location;

    @NotNull
    @ManyToOne
    @JoinColumn(
            name = "requester_id",
            foreignKey = @ForeignKey(name = "fk_permission_requester"),
            nullable = false
    )
    private Requester requester;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "fk_permission_user")
    )
    private User user;

    @Column
    private String description;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "UTC")
    @Column(nullable = false)
    private ZonedDateTime startDateTime;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX", timezone = "UTC")
    @Column(nullable = false)
    private ZonedDateTime endDateTime;
}
