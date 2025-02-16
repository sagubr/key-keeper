package github.sagubr.services;

import github.sagubr.entities.LocationType;
import github.sagubr.repositories.LocationTypeRepository;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class LocationTypeService extends GenericService<LocationType, UUID> {

    public LocationTypeService(LocationTypeRepository repository) {
        super(repository);
    }

}
