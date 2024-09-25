package github.sagubr.services;

import github.sagubr.entities.Place;
import github.sagubr.repositories.PlaceRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Inject))
@Singleton
public class PlaceService {

    private final PlaceRepository repository;

    @Transactional
    public List<Place> findAll() {
        return repository.findAll();
    }
}
