package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "requesters", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "unique_email")
})
@Serdeable
public class RequesterEmail extends EntityPattern {

    @NotNull
    @Column(name = "email")
    private String emails;

    @ManyToOne
    @JoinColumn(name = "requester_id")
    private Requester requester;

}
