package org.example.soldier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoldierTest {
    int strength = 150;
    int health = 300;

    @Test
    public void should_receive_2_arguments() {
        Soldier soldier = new Soldier(health, strength);
        assertNotNull(soldier);
    }

    @Test
    public void should_receive_the_health_property_as_its_1st_argument() {
        Soldier soldier = new Soldier(health, strength);
        assertEquals(300, soldier.health);
    }

    @Test
    public void should_receive_the_health_property_as_its_2st_argument() {
        Soldier soldier = new Soldier(health, strength);
        assertEquals(150, soldier.strength);
    }

    @Test
    public void attack_should_receive_0_arguments() {
        Soldier soldier = new Soldier(health, strength);
        int resultAttack = soldier.attack();
        assertEquals(this.strength, resultAttack);
    }

    @Test
    public void attack_should_return_a_integer() {
        Soldier soldier = new Soldier(health, strength);
        int resultAttack = soldier.attack();
        assertEquals("Integer", ((Object) resultAttack).getClass().getSimpleName());
    }

  @Test
  public void attack_should_return_the_strength_property_of_the_Soldier() {
      Soldier soldier = new Soldier(health, strength);
      var resultAttack = soldier.attack();
      assertEquals(150, resultAttack);
  }
   @Test
   public void damage_should_receive_1_arguments() {
       Soldier soldier = new Soldier(health, strength);
       soldier.receiveDamage(20);
       assertEquals(280, soldier.health);
   }
    @Test
    public void should_remove_the_received_damage_from_the_health_property() {
        var soldier = new Soldier(health, strength);
        soldier.receiveDamage(30);
        assertEquals(270, soldier.health);
    }
}