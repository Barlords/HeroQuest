package esgi.cleancode.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;
import lombok.With;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Value
@Builder
public class PlayerAccount {

    UUID id;

    String pseudo;

    @Builder.Default
    @With
    @Getter
    List<HeroCard> deck = new ArrayList<>();
}
