package github.sagubr.services;

import github.sagubr.entities.User;
import github.sagubr.entities.dtos.UserDto;
import github.sagubr.mappers.UserMapper;
import github.sagubr.repositories.UserRepository;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;


import java.util.Optional;

@Singleton
public class UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private UserMapper userMapper;

    public Optional<UserDto> findUser(String username) {
        return userRepository.findByUsername(username).map(userMapper::toDto);
    }

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }
}

