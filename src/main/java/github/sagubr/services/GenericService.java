package github.sagubr.services;

import github.sagubr.repositories.GenericRepository;
import io.micronaut.data.exceptions.EmptyResultException;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@RequiredArgsConstructor
@SuperBuilder
public abstract class GenericService<T, UUID> {

    protected final GenericRepository<T, UUID> repository;

    @ReadOnly
    @Transactional
    public List<T> findAll() throws EmptyResultException {
        List<T> result = repository.findAll();
        if (result.isEmpty()) {
            throw new EmptyResultException();
        }
        return result;
    }

    @ReadOnly
    @Transactional
    public T findById(@NotBlank @NotNull UUID id) throws EmptyResultException {
        return repository.findById(id).orElseThrow(() -> new EmptyResultException());
    }

    @Transactional
    public T save(@NotNull T entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while saving the entity.", e);
        }
    }

    @Transactional
    public void deleteById(@NotBlank @NotNull UUID id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the record with ID: " + id, e);
        }
    }

    @Transactional
    public void delete(@NotNull T entity) {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the entity.", e);
        }
    }

    @Transactional
    public T update(@NotNull T entity) {
        try {
            return repository.update(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while updating the entity.", e);
        }
    }
}
