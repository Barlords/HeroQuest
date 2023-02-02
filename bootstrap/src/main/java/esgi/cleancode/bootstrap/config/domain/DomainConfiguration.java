package esgi.cleancode.bootstrap.config.domain;

import esgi.cleancode.domain.functional.service.hero.HeroCreatorService;
import esgi.cleancode.domain.ports.client.HeroCreatorApi;
import esgi.cleancode.domain.ports.server.HeroPersistenceSpi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfiguration {

  @Bean
  public HeroCreatorApi drivingLicenceCreatorService(HeroPersistenceSpi spi) {
    return new HeroCreatorService(spi);
  }

}
