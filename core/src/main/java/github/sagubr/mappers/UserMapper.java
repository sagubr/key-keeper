package github.sagubr.mappers;

import github.sagubr.entities.User;
import github.sagubr.entities.dtos.UserDto;
import jakarta.inject.Singleton;

@Singleton
public class UserMapper {

    public User toEntity(UserDto userDto) {
        return new User(userDto.getUsername(),userDto.getPassword(),userDto.getRole());
    }

    public UserDto toDto(User user) {
        return new UserDto(user.getUsername(), user.getPassword(), user.getRoles());
    }
}
