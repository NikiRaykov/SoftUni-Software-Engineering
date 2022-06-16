package bg.softuni.battleships.model.dto;

import bg.softuni.battleships.model.Ship;

public class AttackDTO {
    private Ship attacker;
    private Ship defender;

    public Ship getAttacker() {
        return attacker;
    }

    public void setAttacker(Ship attacker) {
        this.attacker = attacker;
    }

    public Ship getDefender() {
        return defender;
    }

    public void setDefender(Ship defender) {
        this.defender = defender;
    }
}
