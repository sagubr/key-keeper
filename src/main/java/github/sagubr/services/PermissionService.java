package github.sagubr.services;

import github.sagubr.entities.Permission;
import github.sagubr.entities.Requester;
import github.sagubr.repositories.PermissionRepository;
import github.sagubr.repositories.ReservationRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Singleton
public class PermissionService extends GenericService<Permission, UUID> {

    private final PermissionRepository repository;

    @Inject
    public PermissionService(
            PermissionRepository repository
    ) {
        super(repository);
        this.repository = repository;
    }

    public List<Permission> findByRequester(Requester requester) {
        return this.repository.findByRequester(requester);
    }

}
