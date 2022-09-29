package cl.uchile.dcc;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.nonplayable.Enemy;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.Axe;
import cl.uchile.dcc.finalreality.model.weapon.Bow;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * this is the Main.
 *
 * @author Ignacio Alveal
 */

public class Main {
  /**
   * function that does something when the file is opened.
   */
  public static void main(String[] args) throws InterruptedException, InvalidStatValueException {
    //create the queue.
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    //create the characters and weapons to see that the constructors work (also equip and waitTurn).
    var knife = new Knife("wooden knife", 1, 1);
    var character1 = new Thief("Haruhiro", 10, 10, queue);
    character1.equip(knife);
    character1.waitTurn();
    var bow = new Bow("wooden bow", 2, 2);
    var character2 = new Engineer("Yume", 10, 8, queue);
    character2.equip(bow);
    character2.waitTurn();
    var healerStaff = new Staff("healer staff", 3, 3);
    var character3 = new WhiteMage("Merry", 15, 5, 10, queue);
    character3.equip(healerStaff);
    character3.waitTurn();
    var sword = new Sword("wooden sword", 4, 4);
    var character4 = new Knight("Ranta", 10, 20, queue);
    character4.equip(sword);
    character4.waitTurn();
    var axe = new Axe("wooden axe", 5, 5);
    var character5 = new Engineer("Kiichi", 5, 5, queue);
    character5.equip(axe);
    character5.waitTurn();
    var wizardStaff = new Staff("wizard staff", 6, 6);
    var character6 = new BlackMage("Shihoru", 10, 6, 10, queue);
    character6.equip(wizardStaff);
    character6.waitTurn();
    var character7 = new Enemy("Jumbo", 7, 50, 20, queue);
    character7.waitTurn();
    var character8 = new Enemy("Arnold", 8, 70, 10, queue);
    character8.waitTurn();
    //testing AbstractCharacter methods.
    System.out.println("testing AbstractCharacter methods:");
    System.out.println(character1);
    System.out.println("name = " + character1.getName());
    System.out.println("maxHp = " + character1.getMaxHp());
    System.out.println("currentHp = " + character1.getCurrentHp());
    System.out.println("defense = " + character1.getDefense());
    character1.setCurrentHp(8);
    System.out.println("change the currentHp from 10 to 8");
    System.out.println(character1);
    //testing AbstractMage methods.
    System.out.println("testing AbstractMage methods:");
    System.out.println(character3);
    System.out.println("maxMp = " + character3.getMaxMp());
    System.out.println("currentMp = " + character3.getCurrentMp());
    character3.setCurrentMp(8);
    System.out.println("change the currentMp from 10 to 8");
    System.out.println(character3);
    //testing AbstractWeapon methods.
    System.out.println("testing AbstractWeapon methods:");
    //this method is not from Abstract, but it allows an easier visualization.
    System.out.println(wizardStaff);
    System.out.println("name = " + wizardStaff.getName());
    System.out.println("weight = " + wizardStaff.getWeight());
    System.out.println("damage = " + wizardStaff.getDamage());
    //testing methods of all weapons.
    System.out.println("testing getType methods of all weapons:");
    System.out.println(knife);
    System.out.println("knife.getType() = " + knife.getType());
    System.out.println(bow);
    System.out.println("bow.getType() = " + bow.getType());
    System.out.println(healerStaff);
    System.out.println("healerStaff.getType() = " + healerStaff.getType());
    System.out.println(sword);
    System.out.println("sword.getType() = " + sword.getType());
    System.out.println(axe);
    System.out.println("axe.getType() = " + axe.getType());
    //testins AbstractPlayerCharacter methods (equip is already tested before and
    // waitTurn will be tested after).
    System.out.println("testins AbstractPlayerCharacter methods:");
    System.out.println(character6.getEquippedWeapon());
    //testing toString and equals of weapons (only one is done because the rest are equivalent).
    System.out.println("testing toString and equals of weapons "
            + "(only one is done because the rest are equivalent):");
    var wizardStaffX = new Staff("wizard staff", 6, 6);
    System.out.println(wizardStaff);
    System.out.println(wizardStaffX);
    System.out.println(healerStaff);
    System.out.println("wizard_staff.equals(healer_staff) = "
            + (wizardStaff.equals(healerStaff)));
    System.out.println("wizard_staff.equals(wizard_staffX) = "
            + (wizardStaff.equals(wizardStaffX)));
    //testing equals of characters (only one is done because the rest are equivalent).
    System.out.println("testing equals of characters "
            + "(only one is done because the rest are equivalent):");
    var character2X = new Engineer("Yume", 10, 8, queue);
    System.out.println(character2);
    System.out.println(character2X);
    System.out.println(character5);
    System.out.println("character2.equals(character5) = " + (character2.equals(character5)));
    System.out.println("character2.equals(character2X) = " + (character2.equals(character2X)));
    //testing equals of enemy.
    System.out.println("testing equals of enemy:");
    var character7X = new Enemy("Jumbo", 7, 50, 20, queue);
    System.out.println(character7);
    System.out.println(character7X);
    System.out.println(character8);
    System.out.println("character7.equals(character8) = " + (character7.equals(character8)));
    System.out.println("character7.equals(character7X) = " + (character7.equals(character7X)));
    // Waits for 6 seconds to ensure that all characters have finished waiting.
    System.out.println("testing toString of characters and waitTurn of "
            + "AbstractPlayerCharacter and AbstractNonPlayableCharacter:");
    Thread.sleep(6000);
    while (!queue.isEmpty()) {
      // Pops and prints the names of the characters of the queue to illustrate the turns
      // order (to see that the toString work).
      System.out.println(queue.poll().toString());
    }
  }
}