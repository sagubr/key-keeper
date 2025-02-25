package github.sagubr.repositories;

import github.sagubr.entities.User;
import github.sagubr.models.UserSummaryDto;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;

import java.util.List;
import java.util.Optional;

@Introspected
@Repository
public interface UserRepository extends GenericRepository<User, java.util.UUID> {

    Optional<User> findByUsername(String username);

    @Query("SELECT new github.sagubr.models.UserSummaryDto(u.name, u.username, u.email, a.name) FROM User u JOIN u.assignment a")
    List<UserSummaryDto> findAllUserSummaries();

}
