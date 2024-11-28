package github.sagubr.services;

import github.sagubr.entities.Permission;
import github.sagubr.repositories.PermissionRepository;
import jakarta.inject.Singleton;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Singleton
public class PermissionService extends GenericService<Permission, UUID> {

    public PermissionService(PermissionRepository repository) {
        super(repository);
    }

}
