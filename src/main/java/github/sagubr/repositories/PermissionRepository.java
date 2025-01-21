package github.sagubr.repositories;

import github.sagubr.entities.Permission;
import github.sagubr.entities.Requester;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

import java.util.List;

@Introspected
@Repository
public interface PermissionRepository extends GenericRepository<Permission, java.util.UUID> {

    List<Permission> findByRequester(Requester requester);

}
