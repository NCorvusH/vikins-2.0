package org.example.saxon;

import org.example.soldier.Soldier;

public class Saxon extends Soldier {

    public Saxon(int health, int strength) {
        super(health, strength);
        this.msg = "";
    }

    private String msg;

    public String getMsg() {
        return msg;
    }

    @Override
    public void receiveDamage(int damage) {
        super.receiveDamage(damage);
        if (this.health > 0) {
            this.msg = "A Saxon has received " + damage + " points of damage";
        } else {
            this.msg = "A Saxon has died in combat";
    }

}

}