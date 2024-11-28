package github.sagubr.services;

import github.sagubr.entities.Requester;
import github.sagubr.repositories.RequesterRepository;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public class RequesterService extends GenericService<Requester, UUID> {

    public RequesterService(RequesterRepository repository) {
        super(repository);
    }

}
