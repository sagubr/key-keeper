package github.sagubr.repositories;

import github.sagubr.entities.Facility;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

@Introspected
@Repository
public interface FacilityRepository extends GenericRepository<Facility, java.util.UUID> {
}
