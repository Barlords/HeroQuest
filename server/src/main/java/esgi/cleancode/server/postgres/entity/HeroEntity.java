package esgi.cleancode.server.postgres.entity;

import esgi.cleancode.domain.functional.model.Rarity;
import esgi.cleancode.domain.functional.model.Speciality;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "hero")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HeroEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, name = "name")
    private String name;

    @Column(name = "rarity")
    private Rarity rarity;

    @Column(name = "speciality")
    private Speciality speciality;

}