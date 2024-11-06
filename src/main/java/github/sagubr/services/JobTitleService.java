package github.sagubr.services;

import github.sagubr.entities.JobTitle;
import github.sagubr.entities.User;
import github.sagubr.repositories.JobTitleRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;
import java.util.UUID;

@Singleton
@SuperBuilder
public class JobTitleService extends GenericService<JobTitle, UUID> {

    private final JobTitleRepository repository;

}
