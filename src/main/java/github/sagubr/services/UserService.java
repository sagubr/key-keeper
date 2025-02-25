package github.sagubr.services;

import github.sagubr.entities.User;
import github.sagubr.mail.EmailTemplate;
import github.sagubr.mail.SendGridEmailService;
import github.sagubr.models.UserDto;
import github.sagubr.mappers.UserMapper;
import github.sagubr.models.UserSummaryDto;
import github.sagubr.repositories.UserRepository;
import github.sagubr.security.PasswordEncoder;
import github.sagubr.security.PasswordGenerator;
import io.micronaut.transaction.annotation.Transactional;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotNull;

import java.security.Principal;
import java.util.*;

@Singleton
public class UserService extends GenericService<User, UUID> {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;
    private final SendGridEmailService sendGridEmailService;

    @Inject
    public UserService(
            UserRepository repository,
            UserMapper mapper,
            PasswordEncoder passwordEncoder,
            SendGridEmailService sendGridEmailService
    ) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
        this.sendGridEmailService = sendGridEmailService;
    }

    @Transactional
    public List<UserSummaryDto> findAllUserSummaries() {
        return repository.findAllUserSummaries();
    }

    @Transactional(readOnly = true)
    public Optional<UserDto> findByUsername(String username) {
        return Optional.of(repository.findByUsername(username)
                        .orElseThrow(() -> new NoSuchElementException("User with username " + username + " not found")))
                .map(mapper::toDto);
    }

    @Transactional(readOnly = true)
    public Optional<User> findByUsername(Principal principal) {
        String username = principal.getName();
        return Optional.of(repository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("User with username " + username + " not found")));
    }

    @Transactional
    public User save(@NotNull User user) {
        String temporaryPassword = PasswordGenerator.generate(8);
        user.setPassword(passwordEncoder.encode(temporaryPassword));
        User saved = repository.save(user);
        if (saved.isFirstAccess()) {
            this.sendGridEmailService.send(saved.getEmail(), EmailTemplate.WELCOME.content(), Map.of("name", saved.getName(), "password", temporaryPassword)).subscribe();
        }
        return saved;
    }
}

