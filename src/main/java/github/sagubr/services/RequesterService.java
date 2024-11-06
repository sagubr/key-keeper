package github.sagubr.services;

import github.sagubr.entities.Requester;
import github.sagubr.repositories.RequesterRepository;
import jakarta.inject.Singleton;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Singleton
@SuperBuilder
public class RequesterService extends GenericService<Requester, UUID> {

    private final RequesterRepository repository;

}
