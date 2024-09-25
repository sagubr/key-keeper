package github.sagubr.repositories;

import github.sagubr.entities.User;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Repository;

import java.util.Optional;

@Introspected
@Repository
public interface UserRepository extends PatternRepository<User> {

    Optional<User> findByUsername(String username);
}
