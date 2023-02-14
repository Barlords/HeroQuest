package esgi.cleancode.server.postgres.repository;

import esgi.cleancode.server.postgres.entity.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<HeroEntity, Long> {

}