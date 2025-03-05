package github.sagubr.repositories;

import github.sagubr.entities.Requester;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;
import org.hibernate.boot.model.convert.spi.JpaAttributeConverterCreationContext;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Introspected
@Repository
public interface RequesterRepository extends JpaRepository<Requester, UUID> {


    @Query("SELECT r FROM Requester r WHERE r.responsible = true")
    List<Requester> findResponsibleTrue();

    @Query("SELECT r FROM Requester r WHERE r.blocked = false")
    List<Requester> findBlockedFalse();

}
