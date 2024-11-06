package github.sagubr.repositories;

import io.micronaut.data.jpa.repository.JpaRepository;

public interface GenericRepository<T, UUID> extends JpaRepository<T, UUID> {

}
