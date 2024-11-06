package github.sagubr.services;

import github.sagubr.entities.Facility;
import github.sagubr.entities.Location;
import github.sagubr.repositories.FacilityRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Singleton
@SuperBuilder
public class FacilityService extends GenericService<Facility, UUID> {

    private final FacilityRepository repository;

}
