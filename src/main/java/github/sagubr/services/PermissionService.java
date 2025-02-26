package github.sagubr.services;

import github.sagubr.entities.Permission;
import github.sagubr.repositories.PermissionRepository;
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
public class PermissionService {

    private final PermissionRepository repository;

    @ReadOnly
    @Transactional
    @Cacheable("permission-cache")
    public List<Permission> findAll() throws EmptyResultException {
        List<Permission> result = repository.findAll();
        if (result.isEmpty()) {
            throw new EmptyResultException();
        }
        return result;
    }

    @ReadOnly
    @Transactional
    @Cacheable(value = "permission-cache", parameters = "id")
    public Permission findById(@NotBlank @NotNull UUID id) throws EmptyResultException {
        return repository.findById(id).orElseThrow(() -> new EmptyResultException());
    }

    @Transactional
    @CacheInvalidate(value = "permission-cache", all = true)
    public Permission save(@NotNull Permission entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while saving the entity.", e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "permission-cache", all = true)
    public void deleteById(@NotBlank @NotNull UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the record with ID: " + id, e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "permission-cache", all = true)
    public void delete(@NotNull Permission entity) {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the entity.", e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "permission-cache", all = true)
    public Permission update(@NotNull Permission entity) {
        try {
            return repository.update(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while updating the entity.", e);
        }
    }

    @Transactional
    @Cacheable(value = "permission-cache", parameters = "id")
    public List<Permission> findByRequesterId(UUID id) {
        return this.repository.findByRequestersId(id);
    }

}
