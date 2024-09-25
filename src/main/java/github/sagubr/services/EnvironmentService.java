package github.sagubr.services;

import github.sagubr.entities.Environment;
import github.sagubr.repositories.EnvironmentRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Inject))
@Singleton
public class EnvironmentService {

    private final EnvironmentRepository repository;

    @Transactional
    public List<Environment> findAll() {
        return repository.findAll();
    }
}
