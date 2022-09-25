package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.Enemy;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Main
 * @author Ignacio Alveal
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, InvalidStatValueException {
        //create the queue
        BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
        //create the characters and weapons to see that the constructors work (also equip and waitTurn)
        var knife = new KNIFE("wooden knife", 1, 1);
        var character1 = new Thief("Haruhiro", 10, 10, queue);
        character1.equip(knife);
        character1.waitTurn();
        var bow = new BOW("wooden bow", 2, 2);
        var character2 = new Engineer("Yume", 10, 8, queue);
        var character2_x = new Engineer("Yume", 10, 8, queue);
        character2.equip(bow);
        character2.waitTurn();
        var healer_staff = new STAFF("healer staff", 3, 3);
        var character3 = new WhiteMage("Merry", 15, 5, 10, queue);
        character3.equip(healer_staff);
        character3.waitTurn();
        var sword = new SWORD("wooden sword", 4, 4);
        var character4 = new Knight("Ranta", 10, 20, queue);
        character4.equip(sword);
        character4.waitTurn();
        var axe = new AXE("wooden axe", 5, 5);
        var character5 = new Engineer("Kiichi", 5, 5, queue);
        character5.equip(axe);
        character5.waitTurn();
        var wizard_staff = new STAFF("wizard staff", 6,6);
        var wizard_staff_x = new STAFF("wizard staff", 6,6);
        var character6 = new BlackMage("Shihoru", 10, 6, 10, queue);
        character6.equip(wizard_staff);
        character6.waitTurn();
        var character7 = new Enemy("enemy", 7, 10, 10, queue);
        character7.waitTurn();
        //testing AbstractCharacter methods
        System.out.println("testing AbstractCharacter methods:");
        System.out.println(character1.getName());
        System.out.println(character1.getMaxHp());
        character1.setCurrentHp(8);
        System.out.println(character1.getCurrentHp());
        System.out.println(character1.getDefense());
        //testing AbstractMage methods
        System.out.println("testing AbstractMage methods:");
        System.out.println(character3.getMaxMp());
        character3.setCurrentMp(8);
        System.out.println(character3.getCurrentMp());
        //testing AbstractWeapon methods
        System.out.println("testing AbstractWeapon methods:");
        System.out.println(wizard_staff.getName());
        System.out.println(wizard_staff.getWeight());
        System.out.println(wizard_staff.getDamage());
        //testing getType methods of all weapons
        System.out.println("testing getType methods of all weapons:");
        System.out.println(knife.getType());
        System.out.println(bow.getType());
        System.out.println(healer_staff.getType());
        System.out.println(sword.getType());
        System.out.println(axe.getType());
        //testins AbstractPlaterCharacter methods
        System.out.println("testins AbstractPlaterCharacter methods:");
        System.out.println(character6.getEquippedWeapon().getName());
        //testing toString and equals of weapons (only one is done because the rest are equivalent)
        System.out.println("testing toString and equals of weapons (only one is done because the rest are equivalent):");
        System.out.println(wizard_staff);
        System.out.println(wizard_staff_x);
        System.out.println(healer_staff);
        System.out.println("wizard_staff.equals(healer_staff) = " + (wizard_staff.equals(healer_staff)));
        System.out.println("wizard_staff.equals(wizard_staff_x) = " + (wizard_staff.equals(wizard_staff_x)));
        //testing equals of characters (only one is done because the rest are equivalent)
        System.out.println("testing equals of characters (only one is done because the rest are equivalent):");
        System.out.println(character2);
        System.out.println(character2_x);
        System.out.println(character5);
        System.out.println("character2.equals(character5) = " + (character2.equals(character5)));
        System.out.println("character2.equals(character2_x) = " + (character2.equals(character2_x)));
        // Waits for 10 seconds to ensure that all characters have finished waiting
        System.out.println("testing toString of characters and queue:");
        Thread.sleep(10000);
        while (!queue.isEmpty()) {
            // Pops and prints the names of the characters of the queue to illustrate the turns
            // order (to see that the toString work)
            System.out.println(queue.poll().toString());
        }
    }
}