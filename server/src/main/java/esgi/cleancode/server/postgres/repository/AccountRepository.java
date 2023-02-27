package esgi.cleancode.server.postgres.repository;

import esgi.cleancode.server.postgres.entity.AccountEntity;
import esgi.cleancode.server.postgres.entity.HeroEntity;
import io.vavr.control.Option;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.springframework.transaction.annotation.Propagation.MANDATORY;

@Repository
@Transactional(propagation = MANDATORY)
public interface AccountRepository extends JpaRepository<AccountEntity, UUID> {

    List<AccountEntity> findAll();

    Option<AccountEntity> findAccountEntityById(UUID id);

}