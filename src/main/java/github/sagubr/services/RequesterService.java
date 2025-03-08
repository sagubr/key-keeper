package github.sagubr.services;

import github.sagubr.entities.Requester;
import github.sagubr.repositories.RequesterRepository;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.data.exceptions.EmptyResultException;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

@Singleton
@RequiredArgsConstructor
public class RequesterService {

    private final RequesterRepository repository;

    @ReadOnly
    @Transactional
    @Cacheable("requesters")
    public List<Requester> findAll() throws EmptyResultException {
        return repository.findAll();
    }

    @ReadOnly
    @Transactional
    @Cacheable(value = "requesters", parameters = "id")
    public Requester findById(UUID id) {
        return repository.findById(id).orElseThrow(EmptyResultException::new);
    }

    @Transactional
    @CacheInvalidate(value = "requesters", all = true)
    public Requester save(Requester entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while saving the entity.", e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "requesters", all = true)
    public Requester update(Requester entity) {
        return repository.findById(entity.getId())
                .map(existing -> {
                    existing.setName(entity.getName());
                    existing.setRegister(entity.getRegister());
                    existing.setJobTitle(entity.getJobTitle());
                    existing.setResponsible(entity.isResponsible());
                    existing.setBlocked(entity.isBlocked());

                    existing.getEmails().clear();
                    existing.getEmails().addAll(entity.getEmails());

                    return repository.update(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("Solicitante não encontrado na base de dados."));
    }

    @Transactional
    @CacheInvalidate(value = "requesters", all = true)
    public void deleteById(UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the record with ID: " + id, e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "requesters", all = true)
    public void delete(Requester entity) {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the entity.", e);
        }
    }

    @Transactional(readOnly = true)
    @Cacheable("requesters")
    public List<Requester> findAllByResponsibleTrue() {
        return repository.findResponsibleTrue();
    }

    @Transactional(readOnly = true)
    @Cacheable("requesters")
    public List<Requester> findByBlockedFalse() {
        return repository.findBlockedFalse();
    }

}
