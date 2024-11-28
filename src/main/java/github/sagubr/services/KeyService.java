package github.sagubr.services;

import github.sagubr.entities.Key;
import github.sagubr.entities.Location;
import github.sagubr.entities.User;
import github.sagubr.repositories.GenericRepository;
import github.sagubr.repositories.KeyRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Singleton
public class KeyService extends GenericService<Key, UUID> {

    KeyRepository repository;

    @Inject
    public KeyService(KeyRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Key> findByLocation(Location location) {
        return repository.findByLocation(location);
    }

}
