package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "requesters", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email", name = "unique_email"),
        @UniqueConstraint(columnNames = "register", name = "unique_register")
})
@Serdeable
public class Requester extends EntityPattern {

    @NotNull
    private String name;

    @NotNull
    @OneToMany(mappedBy = "requester")
    private Set<RequesterEmail> emails = new HashSet<>();

    @Column(nullable = false, unique = true)
    private String register;

    @ManyToOne
    @JoinColumn(
            name = "job_title_id",
            foreignKey = @ForeignKey(name = "fk_requester_job_title"),
            nullable = false
    )
    private JobTitle jobTitle;

    @NotNull
    @Column(nullable = false)
    private boolean isResponsible = false;

}
