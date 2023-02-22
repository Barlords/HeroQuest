package esgi.cleancode.server.postgres.entity;

import lombok.*;
import lombok.EqualsAndHashCode.Include;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card")
public class CardEntity {
    @Id
    @Include
    private UUID id;
    private String name;
    private int life;
    private int experience;
    private int power;
    private int armor;
    private String speciality;
    private String rarity;
    private int level;

}
