package github.sagubr.mappers;

import github.sagubr.entities.User;
import github.sagubr.entities.dtos.UserDto;
import org.mapstruct.Mapper;
import jakarta.inject.Singleton;

@Singleton
@Mapper(componentModel = "jsr330")
public abstract class UserMapper {

    public abstract User toEntity(UserDto userDto);

    public abstract UserDto toDto(User user);

}


