package github.sagubr.repositories;

import github.sagubr.entities.Environment;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

@Introspected
@Repository
public interface EnvironmentRepository  extends PatternRepository<Environment>{
}
