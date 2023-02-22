package esgi.cleancode.server.postgres.entity;

import lombok.*;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hero")
public class HeroEntity {

    @Id
    @Include
    private UUID id;

    @Column(unique = true)
    private String name;
    private String rarity;
    private String speciality;

}
