package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;

@Getter
@Serdeable
public enum Screen {

    EMPRESTIMOS,
    HISTORICO,
    SOLICITANTES,
    PERMISSOES,
    SALAS,
    TIPO_AMBIENTE,
    INSTALACOES,
    CARGOS,
    CONFIGURACAO,
    USUARIOS,
    ATRIBUICOES;

}
