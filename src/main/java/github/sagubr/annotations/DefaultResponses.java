package github.sagubr.annotations;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
        @ApiResponse(responseCode = "401", description = "Falha de autenticação"),
        @ApiResponse(responseCode = "403", description = "Acesso não autorizado"),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
        @ApiResponse(responseCode = "422", description = "Erro de validação",
                content = {
                        @Content(mediaType = "application/json", schema = @Schema())
                }
        ),
        @ApiResponse(responseCode = "500", description = "Erro",
                content = {
                        @Content(mediaType = "application/json", schema = @Schema())
                }
        ),
})
public @interface DefaultResponses {

}

