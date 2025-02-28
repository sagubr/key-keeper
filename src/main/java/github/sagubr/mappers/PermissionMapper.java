package github.sagubr.mappers;

import github.sagubr.entities.Location;
import github.sagubr.entities.Permission;
import github.sagubr.models.PermissionLocationSummaryDto;
import jakarta.inject.Singleton;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Singleton
@Mapper(componentModel = "jsr330")
public abstract class PermissionMapper {

    public List<PermissionLocationSummaryDto> mapDistinctLocationSummaries(Permission permission) {
        return permission.getLocations().stream()
                .map(location -> new PermissionLocationSummaryDto(
                        permission.getId(),
                        location,
                        permission.getStartDateTime(),
                        permission.getEndDateTime()
                ))
                .collect(Collectors.toList());
    }

}
