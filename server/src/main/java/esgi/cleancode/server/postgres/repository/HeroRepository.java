package esgi.cleancode.server.postgres.repository;

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
public interface HeroRepository extends JpaRepository<HeroEntity, UUID> {

    //@EntityGraph(attributePaths = "heros")
    List<HeroEntity> findAll();

    //@EntityGraph(attributePaths = "heros")
    Option<HeroEntity> findHeroEntityById(UUID id);

    //@EntityGraph(attributePaths = "heros")
    List<HeroEntity> findHeroEntitiesByRarityAndSpeciality(String rarity, String speciality);



}