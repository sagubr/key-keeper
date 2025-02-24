package github.sagubr.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "configurations")
public class Configuration extends EntityPattern {

    @NotNull
    @Column(nullable = false, unique = true)
    private String key;

    @NotNull
    @Column(nullable = false)
    private Boolean autoEmail = false;

    @NotNull
    @Column(nullable = false)
    private Boolean blockPending = false;

    @NotNull
    @Column(nullable = false)
    private Integer tolerancePeriod = 0;

    @NotNull
    @Column(nullable = false)
    private Boolean enableLogs = false;

    @NotNull
    @Column(nullable = false)
    private Integer maxLoanPeriod = 7;

}
