package github.sagubr.repositories;

import github.sagubr.entities.Key;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

@Introspected
@Repository
public interface KeyRepository extends PatternRepository<Key>{
}
