package github.sagubr.services;

import github.sagubr.entities.Requester;
import github.sagubr.repositories.RequesterRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.UUID;

@Singleton
public class RequesterService extends GenericService<Requester, UUID> {

    private final RequesterRepository repository;

    @Inject
    public RequesterService(
            RequesterRepository repository
    ) {
        super(repository);
        this.repository = repository;
    }

    public List<Requester> findAllByResponsibleTrue() {
        return this.repository.findAllByResponsibleTrue();
    }

}
