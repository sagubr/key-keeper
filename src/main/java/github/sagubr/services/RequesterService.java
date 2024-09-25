package github.sagubr.services;

import github.sagubr.entities.Requester;
import github.sagubr.repositories.RequesterRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Inject))
@Singleton
public class RequesterService {

    private final RequesterRepository repository;

    @Transactional
    public List<Requester> findAll() {
        return repository.findAll();
    }
}
