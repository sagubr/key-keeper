package github.sagubr.controller;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record ApiError(String message, String details) {

}
