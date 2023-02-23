package esgi.cleancode.client.rest.resource;

import esgi.cleancode.client.rest.dto.AccountCreationRequest;
import esgi.cleancode.client.rest.dto.BoosterOpeningRequest;
import esgi.cleancode.client.rest.mapper.AccountDtoMapper;
import esgi.cleancode.domain.functional.model.Booster;
import esgi.cleancode.domain.ports.client.AccountCreatorApi;
import esgi.cleancode.domain.ports.client.AccountFinderApi;
import esgi.cleancode.domain.ports.client.BoosterOpenerApi;
import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static esgi.cleancode.client.rest.mapper.AccountDtoMapper.accountCreationToDomain;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/account")
public class AccountResource {

    private final AccountCreatorApi accountCreatorApi;

    private final BoosterOpenerApi boosterOpenerApi;

    private final AccountFinderApi accountFinderApi;


    @PostMapping(path = "/create")
    public ResponseEntity<Object> createAccount(@RequestBody AccountCreationRequest request) {
        return accountCreatorApi
                .create(accountCreationToDomain(request))
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


    @GetMapping(path = "/find_all")
    public List<Object> findAllAccount() {
        return accountFinderApi
                .findAll()
                .map(AccountDtoMapper::toDto);
    }

}
