package esgi.cleancode.domain.functional.model;

import io.vavr.collection.Seq;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Value;
import lombok.With;

import java.util.UUID;

import static io.vavr.API.Seq;

@Value
@Builder
public class Account {

    @Default
    UUID id = UUID.randomUUID();

    @With @Default
    Seq<Card> deck = Seq();

    @With @Default
    int nbToken = 4;

    String pseudo;

}
