package service;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.service.PlayerAccountFightService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlayerAccountFighterServiceTest
{

    @InjectMocks
    PlayerAccountFightService service;

    @Mock
    InMemoryDatabase database;

    @Test
    void should()
    {

    }

}
