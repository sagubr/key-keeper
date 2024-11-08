package github.sagubr.services;

import github.sagubr.repositories.GenericRepository;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.validation.constraints.NotBlank;

import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@SuperBuilder
public abstract class GenericService<T, UUID> {

    protected final GenericRepository<T, UUID> repository;

    @Transactional
    public List<T> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Optional<T> findById(@NotBlank @NonNull UUID id) {
        return repository.findById(id);
    }

    @Transactional
    public T save(@NonNull T entity) {
        return repository.save(entity);
    }

    @Transactional
    public void deleteById(@NotBlank @NonNull UUID id) {
        repository.deleteById(id);
    }

    @Transactional
    public void delete(@NonNull T entity) {
        repository.delete(entity);
    }

    @Transactional
    public T update(@NonNull T entity) {
        return repository.update(entity);
    }
}
