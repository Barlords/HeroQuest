package esgi.cleancode.client.rest.resource;

import esgi.cleancode.client.rest.dto.HeroCreationRequest;
import esgi.cleancode.client.rest.mapper.HeroDtoMapper;
import esgi.cleancode.domain.ports.client.HeroCreatorApi;
import esgi.cleancode.domain.ports.client.HeroFinderApi;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static esgi.cleancode.client.rest.mapper.HeroDtoMapper.heroCreationToDomain;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/hero")
public class HeroResource {

    private final HeroCreatorApi heroCreatorApi;

    private final HeroFinderApi heroFinderApi;

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createHero(@RequestBody HeroCreationRequest request) {
        return heroCreatorApi
                .create(heroCreationToDomain(request))
                .map(HeroDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @GetMapping(path = "/find_all")
    public List<Object> findAllHero() {
        return heroFinderApi
                .findAll()
                .map(HeroDtoMapper::toDto);
    }


}
