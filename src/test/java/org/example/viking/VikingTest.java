package org.example.viking;

import org.example.soldier.Soldier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VikingTest {
    String name = "Harald";
    int strength = 150;
    int health = 300;
    Viking viking = new Viking(name, health, strength);


    @Test
    public void should_inherit_from_Soldier() {
        assertNotNull(viking instanceof Soldier);
    }

   @Test
   public void should_receive_3_arguments() {
       assertNotNull(viking);
   }

   @Test
   public void should_receive_the_health_property_as_its_1st_argument() {
       assertEquals("Harald", viking.name);
   }

   @Test
   public void should_receive_the_health_property_as_its_2st_argument() {
       assertEquals(300, viking.health);
   }

   @Test
   public void should_receive_the_health_property_as_its_3st_argument() {
       assertEquals(150, viking.strength);
   }

   @Test
   public void attack_should_return_strength_property_of_the_Soldier() {
       int resultAttack = viking.attack();
       assertEquals(viking.strength, resultAttack);
   }

   @Test
   public void attack_should_receive_0_arguments() {
       int resultAttack = viking.attack();
       assertEquals(this.strength, resultAttack);
   }

   @Test
   public void damage_should_receive_1_arguments() {
       viking.receiveDamage(50);
       assertEquals(250, viking.health);
   }

   @Test
   public void should_remove_the_received_damage_from_the_health_property() {
       viking.receiveDamage(50);
       assertEquals(250, viking.health);
   }

   @Test
   public void should_return_NAME_has_received_DAMAGE_points_of_damage_if_the_Viking_is_still_alive() {
       viking.receiveDamage(50);
       assertEquals(viking.name + " has received " + 50 + " points of damage", viking.getMsg());
   }

   @Test
   public void should_return_NAME_has_died_in_act_of_combat_if_the_Viking_dies() {
       viking.receiveDamage(health);
       assertEquals(viking.name + " has died in act of combat", viking.getMsg());
   }

   @Test
   public void battleCry_should_receive_0_arguments() {
       String battleCry = viking.battleCry();
       assertEquals("Odin Owns You All!", battleCry);
   }

   @Test
   public void should_return_Odin_Owns_You_All_() {
       viking.battleCry();
       assertEquals("Odin Owns You All!", viking.battleCry());
   }
}