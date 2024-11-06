package github.sagubr.mappers;

import github.sagubr.entities.User;
import github.sagubr.model.UserDto;
import jakarta.inject.Singleton;
import org.mapstruct.Mapper;

@Singleton
@Mapper(componentModel = "jsr330")
public abstract class UserMapper {

    public abstract User toEntity(UserDto userDto);

    public abstract UserDto toDto(User user);

}


