package github.sagubr.services;

import github.sagubr.entities.Assignment;
import github.sagubr.repositories.AssignmentRepository;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class AssignmentService extends GenericService<Assignment, UUID> {

    public AssignmentService(AssignmentRepository repository) {
        super(repository);
    }

}
