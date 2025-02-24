package github.sagubr.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Roles {

    EMPRESTIMOS("Empréstimos - CRUD da entidade Empréstimos"),
    HISTORICO("Empŕestimos - CRUD da entidade Historico"),
    SOLICITANTES("Solicitantes - CRUD da entidade Solicitante"),
    PERMISSOES("Permissoes - CRUD da entidade Permissoes"),
    SALAS("Salas - CRUD da entidade Salas"),
    TIPO_AMBIENTE("Tipo de Ambiente - CRUD da entidade Tipo de Ambiente"),
    INSTALACOES("Instalacoes - CRUD da entidade Instalacoes"),
    CARGOS("Cargos - CRUD da entidade Cargos"),
    CONFIGURACAO("Configuracao - CRUD da entidade Configuracao"),
    USUARIOS("Usuarios - CRUD da entidade Usuarios"),
    ATRIBUICOES("Atribuições - CRUD da entidade Atribuições");

    private final String description;

}
