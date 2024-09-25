package github.sagubr.repositories;

import github.sagubr.entities.Requester;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

@Introspected
@Repository
public interface RequesterRepository extends PatternRepository<Requester>{
}
