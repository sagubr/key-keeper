package github.sagubr.services;

import github.sagubr.entities.Location;
import github.sagubr.repositories.LocationRepository;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.data.exceptions.EmptyResultException;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Singleton
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository repository;

    @ReadOnly
    @Transactional
    @Cacheable("location-cache")
    public List<Location> findAll() throws EmptyResultException {
        List<Location> result = repository.findAll();
        if (result.isEmpty()) {
            throw new EmptyResultException();
        }
        return result;
    }

    @ReadOnly
    @Transactional
    @Cacheable(value = "location-cache", parameters = "id")
    public Location findById(@NotBlank @NotNull UUID id) throws EmptyResultException {
        return repository.findById(id).orElseThrow(() -> new EmptyResultException());
    }

    @Transactional
    @CacheInvalidate(value = "location-cache", all = true)
    public Location save(@NotNull Location entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while saving the entity.", e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "location-cache", all = true)
    public void deleteById(@NotBlank @NotNull UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the record with ID: " + id, e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "location-cache", all = true)
    public Location update(@NotNull Location entity) {
        try {
            return repository.update(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while updating the entity.", e);
        }
    }

    public List<Location> findByRestrictedFalseAndPublicFalse() {
        return repository.findByRestrictedFalseAndPublicAccessFalse();
    }

    public List<Location> findByRestrictedFalseAndPublicTrue() {
        return repository.findByRestrictedFalseAndPublicAccessTrue();
    }

    public List<Location> findByResponsiblesId(UUID requesterId) {
        return repository.findByResponsiblesId(requesterId);
    }

}
