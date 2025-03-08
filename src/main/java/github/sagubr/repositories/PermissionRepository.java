package github.sagubr.repositories;

import github.sagubr.entities.Permission;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Introspected
@Repository
public interface PermissionRepository extends JpaRepository<Permission, UUID> {

    List<Permission> findByRequestersId(UUID id);

    List<Permission> findByActiveTrue();

    List<Permission> findByRequestersIdAndEndDateTimeAfterAndActiveTrue(UUID requestersId, ZonedDateTime now);

}
