package github.sagubr.repositories;

import github.sagubr.entities.Requester;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;

import java.util.List;
import java.util.Optional;

@Introspected
@Repository
public interface RequesterRepository extends GenericRepository<Requester, java.util.UUID> {

    @Query("SELECT r FROM Requester r WHERE r.isResponsible = true")
    List<Requester> findAllByResponsibleTrue();

}
