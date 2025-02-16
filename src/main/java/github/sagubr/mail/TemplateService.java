package github.sagubr.mail;

import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import jakarta.inject.Singleton;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;

@Singleton
public class TemplateService {

    private final TemplateEngine engine;

    public TemplateService() {
        this.engine = new TemplateEngine();
    }

    /**
     * Renderiza um template com os parâmetros fornecidos.
     *
     * @param templateName Nome do template a ser carregado.
     * @param params       Parâmetros para substituir no template.
     * @return O conteúdo renderizado do template.
     */
    public String renderTemplate(String templateName, Map<String, Object> params) {
        String templateContent = loadTemplateFromClasspath(templateName);
        Context context = new Context();
        context.setVariables(params);
        return engine.process(templateContent, context);
    }

    /**
     * Carrega o conteúdo de um template do classpath.
     *
     * @param templateName Nome do template a ser carregado.
     * @return O conteúdo do template como uma String.
     */
    private String loadTemplateFromClasspath(String templateName) {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(templateName)) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Template não encontrado: " + templateName);
            }
            Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8);
            return scanner.useDelimiter("\\A").next();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar o template", e);
        }
    }
}

