package esgi.cleancode.server.postgres.entity;

import lombok.*;
import lombok.EqualsAndHashCode.Include;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

import static javax.persistence.CascadeType.ALL;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account")
public class AccountEntity {

    @Id
    @Include
    private UUID id;

    @Column(unique = true)
    private String pseudo;

    private int nbToken;

    @OneToMany(cascade = ALL)
    private List<CardEntity> deck;

}
