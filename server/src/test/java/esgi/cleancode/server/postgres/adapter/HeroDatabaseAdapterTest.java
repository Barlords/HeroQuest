package esgi.cleancode.server.postgres.adapter;

import esgi.cleancode.domain.ApplicationError;
import esgi.cleancode.domain.functional.model.Hero;
import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import esgi.cleancode.server.postgres.entity.HeroEntity;
import esgi.cleancode.server.postgres.mapper.HeroEntityMapper;
import esgi.cleancode.server.postgres.repository.HeroRepository;
import lombok.val;
import org.assertj.vavr.api.VavrAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static io.vavr.API.None;
import static io.vavr.API.Some;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
public class HeroDatabaseAdapterTest  {

    @InjectMocks
    private HeroDatabaseAdapter adapter;

    @Mock
    private HeroRepository repository;

    @Nested
    class Save {

        @Captor
        private ArgumentCaptor<HeroEntity> entityCaptor;

        @Test
        void should_save() {
            val hero = Hero.builder()
                    .name("Kratos")
                    .speciality(Speciality.TANK)
                    .rarity(Rarity.COMMON)
                    .build();

            val entity = HeroEntityMapper.fromDomain(hero);

            when(repository.save(any(HeroEntity.class))).thenReturn(entity);

            val actual = adapter.save(hero);

            verify(repository).save(entityCaptor.capture());
            verifyNoMoreInteractions(repository);

            VavrAssertions.assertThat(actual).isRight().containsRightInstanceOf(Hero.class);
            assertThat(actual.get()).usingRecursiveComparison().isEqualTo(hero);
            assertThat(entityCaptor.getValue()).usingRecursiveComparison().isEqualTo(entity);
        }

        @Test
        void should_not_save_if_repository_throw_exception() {
            val hero = Hero.builder()
                    .name("Kratos")
                    .speciality(Speciality.TANK)
                    .rarity(Rarity.COMMON)
                    .build();
            val entity = HeroEntityMapper.fromDomain(hero);
            val throwable = new IllegalArgumentException();

            doThrow(throwable).when(repository).save(any(HeroEntity.class));

            val actual = adapter.save(hero);

            verify(repository).save(entityCaptor.capture());
            verifyNoMoreInteractions(repository);

            VavrAssertions.assertThat(actual).isLeft().containsLeftInstanceOf(ApplicationError.class);
            assertThat(actual.getLeft())
                    .usingRecursiveComparison()
                    .isEqualTo(new ApplicationError("Unable to save hero", null, hero, throwable));
            assertThat(entityCaptor.getValue()).usingRecursiveComparison().isEqualTo(entity);
        }
    }

    @Nested
    class FindById {
        @Test
        void should_find() {
            val id = UUID.randomUUID();
            val entity = HeroEntity.builder()
                    .name("Kratos")
                    .speciality("TANK")
                    .rarity("COMMON")
                    .build();
            val domain = HeroEntityMapper.toDomain(entity);

            when(repository.findHeroEntityById(id)).thenReturn(Some(entity));

            val actual = adapter.findById(id);

            VavrAssertions.assertThat(actual).isDefined();
            assertThat(actual.get()).usingRecursiveComparison().isEqualTo(domain);

            verifyNoMoreInteractions(repository);
        }

        @Test
        void should_not_find() {
            val id = UUID.randomUUID();

            when(repository.findHeroEntityById(id)).thenReturn(None());

            val actual = adapter.findById(id);

            VavrAssertions.assertThat(actual).isEmpty();

            verifyNoMoreInteractions(repository);
        }
    }

    @Nested
    class FindAll {
        @Test
        void should_find() {
            val entity = HeroEntity.builder()
                    .name("Kratos")
                    .speciality("TANK")
                    .rarity("COMMON")
                    .build();
            val domain = HeroEntityMapper.toDomain(entity);

            when(repository.findAll()).thenReturn(List.of(entity));

            val actual = adapter.findAll();

            VavrAssertions.assertThat(actual).isNotEmpty();
            assertThat(actual.asJava()).usingRecursiveComparison().isEqualTo(List.of(domain));

            verifyNoMoreInteractions(repository);
        }

        @Test
        void should_not_find() {
            when(repository.findAll()).thenReturn(List.of());

            val actual = adapter.findAll();

            VavrAssertions.assertThat(actual).isEmpty();

            verifyNoMoreInteractions(repository);
        }
    }

}