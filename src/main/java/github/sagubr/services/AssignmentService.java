package github.sagubr.services;

import github.sagubr.entities.Assignment;
import github.sagubr.repositories.AssignmentRepository;
import github.sagubr.repositories.GenericRepository;
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
public class AssignmentService {

    protected final AssignmentRepository repository;

    @ReadOnly
    @Transactional
    public List<Assignment> findAll() throws EmptyResultException {
        List<Assignment> result = repository.findAll();
        if (result.isEmpty()) {
            throw new EmptyResultException();
        }
        return result;
    }

    @ReadOnly
    @Transactional
    public Assignment findById(@NotBlank @NotNull UUID id) throws EmptyResultException {
        return repository.findById(id).orElseThrow(() -> new EmptyResultException());
    }

    @Transactional
    public Assignment save(@NotNull Assignment entity) {
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
    public void delete(@NotNull Assignment entity) {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the entity.", e);
        }
    }

    @Transactional
    public Assignment update(@NotNull Assignment entity) {
        try {
            return repository.update(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while updating the entity.", e);
        }
    }

}
