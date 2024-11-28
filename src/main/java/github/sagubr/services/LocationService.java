package github.sagubr.services;

import github.sagubr.entities.Location;
import github.sagubr.repositories.LocationRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class LocationService extends GenericService<Location, UUID> {

    @Inject
    public LocationService(LocationRepository repository) {
        super(repository);
    }

}
