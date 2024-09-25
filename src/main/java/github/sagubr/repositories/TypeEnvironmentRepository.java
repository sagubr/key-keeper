package github.sagubr.repositories;

import github.sagubr.entities.TypeEnvironment;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

@Introspected
@Repository
public interface TypeEnvironmentRepository extends PatternRepository<TypeEnvironment> {
}
