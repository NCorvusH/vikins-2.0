package org.example.viking;

import org.example.soldier.Soldier;

public class Viking extends Soldier {
    
    public Viking(String name, int health, int strength) {
        super(health, strength);
              this.name = name;
              this.msg = "";
    }

    public String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String msg;
    public String getMsg() {
        return msg;
    }

    public String battleCry(){
        return "Odin Owns You All!";
    }

    @Override
    public void receiveDamage(int damage) {
        super.receiveDamage(damage);
        if (this.health > 0) {
            this.msg = this.name + " has received " + damage + " points of damage";
        } else {
            this.msg = this.name + " has died in act of combat";
        }
    }

}