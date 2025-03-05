package github.sagubr.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {

    EMPRESTIMO,
    AGENDADO,
    ATRASADO,
    CANCELADO,
    CONCLUIDO;

}
