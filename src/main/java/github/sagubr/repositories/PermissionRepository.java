package github.sagubr.repositories;

import github.sagubr.entities.Permission;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

@Introspected
@Repository
public interface PermissionRepository extends PatternRepository<Permission>{
}
