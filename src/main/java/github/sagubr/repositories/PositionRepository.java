package github.sagubr.repositories;

import github.sagubr.entities.Position;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

@Introspected
@Repository
public interface PositionRepository extends PatternRepository<Position>{
}
