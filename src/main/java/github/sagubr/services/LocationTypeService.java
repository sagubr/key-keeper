package github.sagubr.services;

import github.sagubr.entities.LocationType;
import github.sagubr.repositories.LocationTypeRepository;
import jakarta.inject.Singleton;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Singleton
@SuperBuilder
public class LocationTypeService extends GenericService<LocationType, UUID> {

    private final LocationTypeRepository repository;

}
