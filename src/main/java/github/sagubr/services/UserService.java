package github.sagubr.services;

import github.sagubr.entities.User;
import github.sagubr.entities.dtos.UserDto;
import github.sagubr.mappers.UserMapper;
import github.sagubr.repositories.UserRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Singleton
@AllArgsConstructor(onConstructor = @__(@Inject))
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final BCryptPasswordEncoderService passwordEncoder;

    @Transactional
    public List<User> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<UserDto> findUser(String username) {
        return Optional.of(repository.findByUsername(username)
                        .orElseThrow(() -> new NoSuchElementException("User with username " + username + " not found")))
                .map(mapper::toDto);
    }

    @Transactional
    public User save(UserDto user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(mapper.toEntity(user));
    }
}

