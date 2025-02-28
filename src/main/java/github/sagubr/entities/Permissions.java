package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;

@Getter
@Serdeable
public enum Permissions {

    MENU_EMPRESTIMOS,
    MENU_AUTORIZACOES,
    MENU_RECURSOS,
    MENU_PARAMETRIZACOES,
    MENU_GESTAO_ACESSOS,

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
