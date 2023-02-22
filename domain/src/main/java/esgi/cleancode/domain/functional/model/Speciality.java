package esgi.cleancode.domain.functional.model;

import lombok.Getter;

public enum Speciality {

    TANK(1, 1000, 100, 20, 3, 20),
    ASSASSIN(2, 800, 200, 5, 1, 30),
    MAGE(3, 700, 150, 10, 2, 25);

    @Getter
    final int id;
    @Getter
    final int life;
    @Getter
    final int power;
    @Getter
    final int armor;
    @Getter
    final int idAdvantage;
    @Getter
    final int powerUpAdvantage;

    Speciality(int id, int life, int power, int armor, int idAdvantage, int powerUpAdvantage) {
        this.id = id;
        this.life = life;
        this.power = power;
        this.armor = armor;
        this.idAdvantage = idAdvantage;
        this.powerUpAdvantage = powerUpAdvantage;
    }
}
