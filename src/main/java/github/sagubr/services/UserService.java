package github.sagubr.services;

import github.sagubr.entities.User;
import github.sagubr.model.UserDto;
import github.sagubr.mappers.UserMapper;
import github.sagubr.repositories.UserRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.validation.constraints.NotNull;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Singleton
public class UserService extends GenericService<User, UUID> {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoderService passwordEncoder;

    @Inject
    public UserService(
            UserRepository repository,
            UserMapper mapper,
            BCryptPasswordEncoderService passwordEncoder
    ) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional(readOnly = true)
    public Optional<UserDto> findUser(String username) {
        return Optional.of(repository.findByUsername(username)
                        .orElseThrow(() -> new NoSuchElementException("User with username " + username + " not found")))
                .map(mapper::toDto);
    }

    @Transactional
    public User save(@NotNull UserDto user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(mapper.toEntity(user));
    }
}

