package esgi.cleancode.bootstrap.config.domain;

import esgi.cleancode.domain.functional.service.AccountCreatorService;
import esgi.cleancode.domain.functional.service.hero.HeroCreatorService;
import esgi.cleancode.domain.ports.client.AccountCreatorApi;
import esgi.cleancode.domain.ports.client.HeroCreatorApi;
import esgi.cleancode.domain.ports.server.AccountPersistenceSpi;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"esgi.cleancode.server.postgres.entity"})
@EnableJpaRepositories(basePackages = {"esgi.cleancode.server.postgres.repository"})
@ComponentScan(basePackages = {"esgi.cleancode.server.postgres.adapter"})
public class DomainConfiguration {

  @Bean
  public HeroCreatorApi heroCreatorApi(HeroPersistenceSpi spi) {
    return new HeroCreatorService(spi);
  }

  @Bean
  public AccountCreatorApi accountCreatorApi(AccountPersistenceSpi spi) {
    return new AccountCreatorService(spi);
  }
/*
  @Bean
  public CardAppenderApi cardAppenderApi(AccountPersistenceSpi spi) {
    return new CardAppenderService(spi);
  }

  @Bean
  public BoosterOpenerApi boosterOpenerApi(AccountPersistenceSpi spi) {
    return new BoosterOpenerService(spi);
  }
*/

}
