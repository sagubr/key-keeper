package github.sagubr.repositories;

import github.sagubr.entities.Key;
import github.sagubr.entities.Location;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

import java.util.List;

@Repository
public interface KeyRepository extends GenericRepository<Key, java.util.UUID> {

    List<Key> findByLocation(Location location);

}
