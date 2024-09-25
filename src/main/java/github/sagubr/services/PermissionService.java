package github.sagubr.services;

import github.sagubr.entities.Permission;
import github.sagubr.repositories.PermissionRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Inject))
@Singleton
public class PermissionService {

    private final PermissionRepository repository;

    @Transactional
    public List<Permission> findAll() {
        return repository.findAll();
    }
}
