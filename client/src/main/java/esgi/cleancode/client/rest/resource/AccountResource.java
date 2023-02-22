package esgi.cleancode.client.rest.resource;

import esgi.cleancode.client.rest.dto.AccountCreationRequest;
import esgi.cleancode.client.rest.dto.BoosterOpeningRequest;
import esgi.cleancode.client.rest.dto.HeroCreationRequest;
import esgi.cleancode.client.rest.mapper.AccountDtoMapper;
import esgi.cleancode.client.rest.mapper.HeroDtoMapper;
import esgi.cleancode.domain.functional.model.Booster;
import esgi.cleancode.domain.ports.client.AccountCreatorApi;
import esgi.cleancode.domain.ports.client.BoosterOpenerApi;
import esgi.cleancode.domain.ports.client.HeroCreatorApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static esgi.cleancode.client.rest.mapper.HeroDtoMapper.heroCreationToDomain;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/account")
public class AccountResource {

    private final AccountCreatorApi accountCreatorApi;

    private final BoosterOpenerApi boosterOpenerApi;

    @PostMapping(path = "/create")
    public ResponseEntity<Object> createAccount(@RequestBody AccountCreationRequest request) {
        return accountCreatorApi
                .create(request.pseudo())
                .map(AccountDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

    @PostMapping(path = "/open_booster")
    public ResponseEntity<Object> openBooster(@RequestBody BoosterOpeningRequest request) {
        return boosterOpenerApi
                .openBooster(request.account_id(), Booster.valueOf(request.booster()))
                .map(AccountDtoMapper::toDto)
                .fold(ResponseEntity.badRequest()::body, ResponseEntity::ok);
    }

}
