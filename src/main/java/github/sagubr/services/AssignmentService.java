package github.sagubr.services;

import github.sagubr.commands.AssignmentCommand;
import github.sagubr.entities.Assignment;
import github.sagubr.repositories.AssignmentRepository;
import io.micronaut.data.exceptions.EmptyResultException;
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

    @Transactional(readOnly = true)
    public List<Assignment> findAll() throws EmptyResultException {
        List<Assignment> result = repository.findAll();
        if (result.isEmpty()) {
            throw new EmptyResultException();
        }
        return result;
    }

    @Transactional(readOnly = true)
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
    public Assignment update(@NotNull AssignmentCommand command) {
        try {
            Assignment assignment = repository.findById(command.getAssignmentId()).orElseThrow(() -> new EmptyResultException());
            assignment.setName(command.getName());
            assignment.setPermissions(command.getPermissions());
            return repository.save(assignment);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while updating the entity.", e);
        }
    }

}
