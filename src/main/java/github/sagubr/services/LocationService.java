package github.sagubr.services;

import github.sagubr.entities.Location;
import github.sagubr.models.LocationDto;
import github.sagubr.repositories.LocationRepository;
import github.sagubr.repositories.LocationTypeRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Singleton
public class LocationService extends GenericService<Location, UUID> {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<LocationDto> findAllLocationSummaries() {
        List<LocationDto> locations = repository.findAllLocationSummaries();
        for (LocationDto location : locations) {
            List<String> responsible = repository.findResponsiblesByLocationIds(location.getId());
            location.setResponsibles(responsible);
        }
        return locations;
    }


}
