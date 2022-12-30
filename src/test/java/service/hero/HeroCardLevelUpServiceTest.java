package service.hero;

import esgi.cleancode.database.InMemoryDatabase;
import esgi.cleancode.service.hero.HeroCardLevelUpService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HeroCardLevelUpServiceTest {

    @InjectMocks
    private HeroCardLevelUpService service;

    @Mock
    private InMemoryDatabase database;

    @Test
    void should_level_up_and_save_in_database() {

    }

}
