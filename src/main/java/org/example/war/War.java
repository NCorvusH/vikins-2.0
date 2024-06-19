package org.example.war;

import org.example.saxon.Saxon;
import org.example.viking.Viking;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class War {
    private List<Viking> vikingArmy;
    private List<Saxon> saxonArmy;

    public War() {
        this.vikingArmy = new ArrayList<>();
        this.saxonArmy = new ArrayList<>();
    }

    public void addViking(Viking viking) {
        vikingArmy.add(viking);
    }

    public void addSaxon(Saxon saxon) {
        saxonArmy.add(saxon);
    }

    public int vikingAttack() {
        if (saxonArmy.isEmpty()) {
            return 0; // No Saxons to attack
        }
    
        Random random = new Random();
        int randomSaxonIndex = random.nextInt(saxonArmy.size());
        Saxon randomSaxon = saxonArmy.get(randomSaxonIndex);
    
        int randomVikingIndex = random.nextInt(vikingArmy.size());
        Viking randomViking = vikingArmy.get(randomVikingIndex);
    
        int damage = randomViking.getStrength();
        randomSaxon.receiveDamage(damage); // Adjusted line
    
        int resultDamage = damage; // Now directly assign damage
    
        if (randomSaxon.getHealth() <= 0) {
            saxonArmy.remove(randomSaxon);
        }
    
        return resultDamage;
    }

    public String saxonAttack() {
        if (vikingArmy.isEmpty()) {
            return "Vikings have fought for their lives and survive another day...";
        }

        Random random = new Random();
        int randomVikingIndex = random.nextInt(vikingArmy.size());
        Viking randomViking = vikingArmy.get(randomVikingIndex);

        int randomSaxonIndex = random.nextInt(saxonArmy.size());
        Saxon randomSaxon = saxonArmy.get(randomSaxonIndex);

        int damage = randomSaxon.getStrength();
        randomViking.receiveDamage(damage);

        if (randomViking.getHealth() <= 0) {
            vikingArmy.remove(randomViking);
            return randomViking.getName() + " has died in act of combat";
        }

        return randomViking.getName() + " has received " + damage + " points of damage";
    }

    public String showStatus() {
        if (saxonArmy.isEmpty()) {
            return "Vikings have won the war of the century!";
        } else if (vikingArmy.isEmpty()) {
            return "Saxons have fought for their lives and survive another day...";
        } else {
            return "Vikings and Saxons are still in the thick of battle.";
        }
    }

    // Getters for testing purposes
    public List<Viking> getVikingArmy() {
        return vikingArmy;
    }

    public List<Saxon> getSaxonArmy() {
        return saxonArmy;
    }
}