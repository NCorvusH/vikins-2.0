package org.example.soldier;

public class Soldier {
    public Integer health;
    public Integer strength;
    

    public Soldier(int health, int strength) {
        this.health = health;
        this.strength = strength;
    }
    public int getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(Integer strength) {
        this.strength = strength;
    }
    public int attack() {
        return strength;
    }

    public void receiveDamage(int damage) {
        this.health -= damage;
    }
    

}