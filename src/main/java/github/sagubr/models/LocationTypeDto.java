package github.sagubr.models;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record LocationTypeDto(String name) {
}
