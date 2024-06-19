package org.example.war;

import org.example.saxon.Saxon;
import org.example.viking.Viking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class WarTest {

    private Viking viking;
    private Saxon saxon;
    private War war;

    @BeforeEach
    public void setUp() {
        viking = new Viking("Harald", health:300, strength:150);
        saxon = new Saxon(300, 150);
        war = new War();
    }

    @Test
    public void vikingAttack_should_make_Saxon_receiveDamage_equal_to_the_strength_of_a_Viking() {
        war.addSaxon(saxon);
        war.addViking(viking);

        int oldHealth = saxon.getHealth();
        int damageInflicted = war.vikingAttack();
        int expectedHealth = oldHealth - viking.getStrength();

        assertEquals(expectedHealth, saxon.getHealth());
        assertEquals(viking.getStrength(), damageInflicted);
    }

    @Test
    public void vikingAttack_should_remove_dead_saxons_from_the_army() {
        saxon.receiveDamage(300); // Ensure the Saxon dies
        war.addSaxon(saxon);
        war.addViking(viking);

        war.vikingAttack();

        assertTrue(war.getSaxonArmy().isEmpty());
    }

    @Test
    public void vikingAttack_should_return_result_of_calling_receiveDamage_of_a_Saxon_with_the_strength_of_a_Viking() {
        saxon.receiveDamage(300); // Ensure the Saxon dies
        war.addSaxon(saxon);
        war.addViking(viking);

        String response = war.vikingAttack();

        assertEquals(saxon.getDeathMsg(), response);
    }

    @Test
    public void saxonAttack_should_make_Viking_receiveDamage_equal_to_the_strength_of_a_Saxon() {
        war.addSaxon(saxon);
        war.addViking(viking);

        int oldHealth = viking.getHealth();
        String response = war.saxonAttack();
        int expectedHealth = oldHealth - saxon.getStrength();

        assertEquals(expectedHealth, viking.getHealth());
    }

    @Test
    public void saxonAttack_should_remove_dead_viking_from_the_army() {
        viking.receiveDamage(300); // Ensure the Viking dies
        war.addSaxon(saxon);
        war.addViking(viking);

        war.saxonAttack();

        assertTrue(war.getVikingArmy().isEmpty());
    }

    @Test
    public void saxonAttack_should_return_a_message_with_the_name_of_the_dead_viking() {
        viking.receiveDamage(300); // Ensure the Viking dies
        war.addSaxon(saxon);
        war.addViking(viking);

        String response = war.saxonAttack();

        assertEquals(viking.getDeathMsg(), response);
    }

    @Test
    public void saxonAttack_should_return_result_of_calling_receiveDamage_of_a_Viking_with_the_strength_of_a_Saxon() {
        war.addSaxon(saxon);
        war.addViking(viking);

        String response = war.saxonAttack();

        assertEquals(viking.getMsg(saxon.getStrength()), response);
    }

    @Test
    public void showStatus_should_return_Vikings_have_won_the_war_of_the_century_when_no_Saxons_left() {
        war.addViking(viking);

        assertEquals("Vikings have won the war of the century!", war.showStatus());
    }


    @Test
    public void showStatus_should_return_Saxons_have_fought_for_their_lives_when_no_Vikings_left() {
    war.addSaxon(saxon);

    assertEquals("Saxons have fought for their lives and survive another day...", war.showStatus());
    }

    @Test
    public void showStatus_should_return_Vikings_and_Saxons_are_still_in_the_thick_of_battle_when_both_exist() {
        war.addViking(viking);
        war.addSaxon(saxon);

        assertEquals("Vikings and Saxons are still in the thick of battle.", war.showStatus());
    }
}
