package github.sagubr.services;

import github.sagubr.entities.Key;
import github.sagubr.repositories.KeyRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Inject))
@Singleton
public class KeyService {

    private final KeyRepository repository;

    @Transactional
    public List<Key> findAll() {
        return repository.findAll();
    }
}
