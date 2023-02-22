package esgi.cleancode.bootstrap.config.domain;

import esgi.cleancode.domain.functional.service.account.AccountCreatorService;
import esgi.cleancode.domain.functional.service.BoosterOpenerService;
import esgi.cleancode.domain.functional.service.account.AccountFinderService;
import esgi.cleancode.domain.functional.service.hero.HeroCreatorService;
import esgi.cleancode.domain.functional.service.hero.HeroFinderService;
import esgi.cleancode.domain.ports.client.*;
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
  public HeroFinderApi heroFinderApi(HeroPersistenceSpi spi) { return new HeroFinderService(spi); }

  @Bean
  public HeroCreatorApi heroCreatorApi(HeroPersistenceSpi spi) {
    return new HeroCreatorService(spi);
  }

  @Bean
  public AccountFinderApi accountFinderApi(AccountPersistenceSpi spi) { return new AccountFinderService(spi); }

  @Bean
  public AccountCreatorApi accountCreatorApi(AccountPersistenceSpi spi) {
    return new AccountCreatorService(spi);
  }

  @Bean
  public BoosterOpenerApi boosterOpenerApi(AccountPersistenceSpi accountPersistenceSpi, HeroPersistenceSpi heroPersistenceSpi) {
    return new BoosterOpenerService(accountPersistenceSpi, heroPersistenceSpi);
  }


  /*

  @Bean
  public CardAppenderApi cardAppenderApi(AccountPersistenceSpi spi) {
    return new CardAppenderService(spi);
  }

*/

}
