package esgi.cleancode.domain.functional.model;

import lombok.Builder;
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
    List<HeroCard> deck = new ArrayList<>();

    @With
    @Builder.Default
    int nbToken = 4;
}
