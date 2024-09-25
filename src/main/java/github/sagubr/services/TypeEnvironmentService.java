package github.sagubr.services;

import github.sagubr.entities.TypeEnvironment;
import github.sagubr.repositories.TypeEnvironmentRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Inject))
@Singleton
public class TypeEnvironmentService {

    private final TypeEnvironmentRepository repository;

    @Transactional
    public List<TypeEnvironment> findAll() {
        return repository.findAll();
    }
}
