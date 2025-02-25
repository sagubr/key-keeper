package github.sagubr.repositories;

import github.sagubr.entities.Location;
import github.sagubr.models.LocationDto;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Introspected
@Repository
public interface LocationRepository extends GenericRepository<Location, UUID> {

    @Query("""
                SELECT new github.sagubr.models.LocationDto(
                    l.id,
                    l.name,
                    l.description,
                    f.name,
                    lt.name,
                    l.maxCapacity,
                    l.isRestricted,
                    l.openingTime,
                    l.closingTime
                ) 
                FROM Location l
                LEFT JOIN l.responsibles r
                LEFT JOIN l.facility f
                LEFT JOIN l.locationType lt
                GROUP BY l.id, f.name, lt.name
            """)
    List<LocationDto> findAllLocationSummaries();

    @Query("""
                SELECT r.name
                FROM Location l
                LEFT JOIN l.responsibles r
                WHERE l.id = :locationId
            """)
    List<String> findResponsiblesByLocationIds(UUID locationId);


}

