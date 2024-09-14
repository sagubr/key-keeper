package github.sagubr.repositories;

import io.micronaut.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatternRepository<T> extends JpaRepository<T, UUID> {
}
