package github.sagubr.repositories;

import github.sagubr.entities.Assignment;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

import java.util.UUID;

@Introspected
@Repository
public interface AssignmentRepository extends GenericRepository<Assignment, UUID> {
}
