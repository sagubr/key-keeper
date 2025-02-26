package github.sagubr.repositories;

import github.sagubr.entities.LocationType;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;

import java.util.List;

@Introspected
@Repository
public interface LocationTypeRepository extends GenericRepository<LocationType, java.util.UUID> {

}
