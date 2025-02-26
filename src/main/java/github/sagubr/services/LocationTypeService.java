package github.sagubr.services;

import github.sagubr.entities.LocationType;
import github.sagubr.repositories.LocationTypeRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;

@Singleton
public class LocationTypeService extends GenericService<LocationType, UUID> {

    private final LocationTypeRepository repository;

    public LocationTypeService(LocationTypeRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
