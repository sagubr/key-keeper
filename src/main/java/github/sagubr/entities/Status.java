package github.sagubr.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {
    LOAN("EMPRÉSTIMO"),
    SCHEDULED("AGENDADO"),
    COMPLETED("CONCLUÍDO");

    private final String description;

    @Override
    public String toString() {
        return description;
    }
}
