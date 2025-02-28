package github.sagubr.mappers;

import github.sagubr.entities.User;
import github.sagubr.models.UserAuthenticateDto;
import jakarta.inject.Singleton;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Singleton
@Mapper(componentModel = "jsr330")
public abstract class UserMapper {

    @Mapping(source = "assignment", target = "assignment")
    public abstract UserAuthenticateDto toDto(User user);

    @Mapping(source = "assignment", target = "assignment")
    public abstract User toEntity(UserAuthenticateDto userAuthenticateDto);
}
