package github.sagubr.services;

import github.sagubr.entities.Position;
import github.sagubr.repositories.PositionRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Inject))
@Singleton
public class PositionService {

    private final PositionRepository repository;

    @Transactional
    public List<Position> findAll() {
        return repository.findAll();
    }
}
