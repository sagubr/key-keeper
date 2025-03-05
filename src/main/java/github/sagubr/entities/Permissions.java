package github.sagubr.entities;

import io.micronaut.serde.annotation.Serdeable;
import lombok.Getter;

@Getter
@Serdeable
public enum Permissions {

    VER_EMPRESTIMOS,
    EDITAR_EMPRESTIMOS,

    VER_HISTORICOS,
    EDITAR_HISTORICOS,

    VER_SOLICITANTES,
    EDITAR_SOLICITANTES,

    VER_PERMISSOES,
    EDITAR_PERMISSOES,

    VER_SALAS,
    EDITAR_SALAS,

    VER_TIPO_AMBIENTE,
    EDITAR_TIPO_AMBIENTE,

    VER_INSTALACOES,
    EDITAR_INSTALACOES,

    VER_CARGOS,
    EDITAR_CARGOS,

    VER_CONFIGURACAO,
    EDITAR_CONFIGURACAO,

    VER_USUARIOS,
    EDITAR_USUARIOS
}
