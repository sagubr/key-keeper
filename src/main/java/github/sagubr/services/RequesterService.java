package github.sagubr.services;

import github.sagubr.entities.Requester;
import github.sagubr.repositories.RequesterRepository;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.data.exceptions.EmptyResultException;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Singleton
@RequiredArgsConstructor
public class RequesterService {

    private final RequesterRepository repository;

    @ReadOnly
    @Transactional
    @Cacheable("requester-cache")
    public List<Requester> findAll() throws EmptyResultException {
        List<Requester> result = repository.findAll();
        if (result.isEmpty()) {
            throw new EmptyResultException();
        }
        return result;
    }

    @ReadOnly
    @Transactional
    @Cacheable(value = "requester-cache", parameters = "id")
    public Requester findById(UUID id) {
        return repository.findById(id).orElseThrow(EmptyResultException::new);
    }

    @Transactional
    @CacheInvalidate(value = "requester-cache", all = true)
    public Requester save(Requester entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while saving the entity.", e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "requester-cache", all = true)
    public Requester update(Requester entity) {
        try {
            return repository.update(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while updating the entity.", e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "requester-cache", all = true)
    public void deleteById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the record with ID: " + id, e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "requester-cache", all = true)
    public void delete(Requester entity) {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the entity.", e);
        }
    }

    @ReadOnly
    @Transactional
    @Cacheable("requester-cache")
    public List<Requester> findAllByResponsibleTrue() {
        return repository.findAllByResponsibleTrue();
    }
}
