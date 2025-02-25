package github.sagubr.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Tag(name = "Configuration", description = "Classe referência para Configuration")
@RequiredArgsConstructor
@Controller("/api/configuration")
public class ConfigurationController {


}
