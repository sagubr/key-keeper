package github.sagubr.repositories;

import github.sagubr.entities.Location;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;

import java.util.List;
import java.util.UUID;

@Introspected
@Repository
public interface LocationRepository extends GenericRepository<Location, UUID> {

    @Query("""
                SELECT r.name
                FROM Location l
                LEFT JOIN l.responsibles r
                WHERE l.id = :locationId
            """)
    List<String> findIsResponsiblesByLocationIds(UUID locationId);

    List<Location> findByRestrictedFalseAndPublicAccessFalse();

    List<Location> findByRestrictedFalseAndPublicAccessTrue();

    List<Location> findByResponsiblesId(UUID requesterId);

}

