package github.sagubr.repositories;

import github.sagubr.entities.JobTitle;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

@Introspected
@Repository
public interface JobTitleRepository extends GenericRepository<JobTitle, java.util.UUID> {
}
