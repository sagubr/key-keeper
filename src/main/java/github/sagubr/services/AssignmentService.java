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
    public List<Assignment> findByActiveTrue() throws EmptyResultException {
        List<Assignment> result = repository.findByActiveTrue();
        if (result.isEmpty()) throw new EmptyResultException();
        return result;
    }

    @Transactional(readOnly = true)
    public Assignment findById(@NotBlank @NotNull UUID id) throws EmptyResultException {
        return repository.findById(id).orElseThrow(() -> new EmptyResultException());
    }

    @Transactional
    public Assignment save(@NotNull Assignment entity) {
        return repository.save(entity);
    }

    @Transactional
    public Assignment update(@NotNull AssignmentCommand command) {
        Assignment assignment = repository.findById(command.getAssignmentId()).orElseThrow();
        assignment.setName(command.getName());
        assignment.setPermissions(command.getPermissions());
        return repository.save(assignment);
    }

}
