package github.sagubr.services;

import github.sagubr.entities.Permission;
import github.sagubr.mappers.PermissionMapper;
import github.sagubr.models.PermissionLocationSummaryDto;
import github.sagubr.repositories.PermissionRepository;
import io.micronaut.cache.annotation.CacheInvalidate;
import io.micronaut.cache.annotation.Cacheable;
import io.micronaut.data.exceptions.EmptyResultException;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository repository;
    private final PermissionMapper mapper;

    @ReadOnly
    @Transactional
    @Cacheable("permission-cache")
    public List<Permission> findAll() {
        return repository.findByActiveTrue();
    }

    @ReadOnly
    @Transactional
    @Cacheable(value = "permission-cache", parameters = "id")
    public Permission findById(@NotBlank @NotNull UUID id) throws EmptyResultException {
        return repository.findById(id).orElseThrow(() -> new EmptyResultException());
    }

    @Transactional
    @CacheInvalidate(value = "permission-cache", all = true)
    public Permission save(@NotNull Permission entity) {
         return repository.save(entity);
    }

    @Transactional
    @CacheInvalidate(value = "permission-cache", all = true)
    public Permission deleteById(@NotBlank @NotNull UUID id) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setActive(false);
                    return repository.update(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("Permissão não encontrada na base de dados."));
    }

    @Transactional
    @CacheInvalidate(value = "permission-cache", all = true)
    public void delete(@NotNull Permission entity) {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while deleting the entity.", e);
        }
    }

    @Transactional
    @CacheInvalidate(value = "permission-cache", all = true)
    public Permission update(@NotNull Permission entity) {
        return repository.findById(entity.getId())
                .map(existing -> {
                    existing.setDescription(entity.getDescription());
                    existing.setStartDateTime(entity.getStartDateTime());
                    existing.setEndDateTime(entity.getEndDateTime());
                    existing.setRequesters(entity.getRequesters());
                    existing.setLocations(entity.getLocations());
                    return repository.update(existing);
                })
                .orElseThrow(() -> new EntityNotFoundException("Permissão não encontrada na base de dados."));
    }

    @Transactional
    @Cacheable(value = "permission-cache", parameters = "id")
    public List<PermissionLocationSummaryDto> findByRequestersIdAndEndDateTimeAfterAndActiveTrue(UUID id, ZonedDateTime now) {
        List<Permission> permissions = repository.findByRequestersIdAndEndDateTimeAfterAndActiveTrue(id, now);
        List<PermissionLocationSummaryDto> permissionLocationSummaryDtos =
                permissions.stream()
                        .flatMap(permission -> mapper.mapDistinctLocationSummaries(permission).stream())
                        .collect(Collectors.toList());
        return permissionLocationSummaryDtos.stream().distinct().collect(Collectors.toList());
    }

}
