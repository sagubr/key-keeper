package github.sagubr.repositories;

import github.sagubr.entities.Location;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

@Introspected
@Repository
public interface LocationRepository extends GenericRepository<Location, java.util.UUID> {
}
