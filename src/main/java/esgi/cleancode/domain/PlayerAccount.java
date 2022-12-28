package esgi.cleancode.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PlayerAccount {
    @Getter
    UUID id;
    String pseudo;
}
