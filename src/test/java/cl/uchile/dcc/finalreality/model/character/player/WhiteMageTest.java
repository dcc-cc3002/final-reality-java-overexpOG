/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponForThisCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest {
  private PlayerCharacter character1;
  private PlayerCharacter character2;
  private PlayerCharacter character3;
  private PlayerCharacter character4;
  private Weapon sword;
  private Weapon axe;
  private Weapon knife;
  private Weapon staff;
  private Weapon bow;

  @BeforeEach
  void setUp() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    character1 = new WhiteMage("Merry", 15, 5, 10, queue);
    character2 = new WhiteMage("Merry", 15, 5, 10, queue);
    character3 = new WhiteMage("Merry", 8, 5, 10, queue);
    character4 = new BlackMage("Shihoru", 10, 6, 10, queue);
    sword = new Sword("wooden sword", 4, 4);
    axe = new Axe("wooden axe", 5, 5);
    knife = new Knife("wooden knife", 1, 1);
    staff = new Staff("wooden staff", 6, 6);
    bow = new Bow("wooden bow", 2, 2);
  }

  @Test
  void testToString() {
    assertEquals("WhiteMage{name='Merry', maxHp=15, currentHp=15, defense=5, maxMp=10, currentMp=10}", character1.toString());
  }

  @Test
  void testEquals() {
    assert (character1.equals(character1));
    assert (character1.equals(character2));
    assertFalse (character1.equals(character3));
    assertFalse (character1.equals(character4));
  }

  @Test
  void equip() {
    boolean swordIsEquipableForBlackMage = true;
    try {
      character1.equip(sword);
    } catch (InvalidWeaponForThisCharacter e) {
      swordIsEquipableForBlackMage = false;
    }
    assertEquals(false, swordIsEquipableForBlackMage);

    boolean axeIsEquipableForBlackMage = true;
    try {
      character1.equip(axe);
    } catch (InvalidWeaponForThisCharacter e) {
      axeIsEquipableForBlackMage = false;
    }
    assertEquals(false, axeIsEquipableForBlackMage);

    boolean knifeIsEquipableForBlackMage = true;
    try {
      character1.equip(knife);
    } catch (InvalidWeaponForThisCharacter e) {
      knifeIsEquipableForBlackMage = false;
    }
    assertEquals(false, knifeIsEquipableForBlackMage);

    character1.equip(staff);

    boolean bowIsEquipableForBlackMage = true;
    try {
      character1.equip(bow);
    } catch (InvalidWeaponForThisCharacter e) {
      bowIsEquipableForBlackMage = false;
    }
    assertEquals(false, bowIsEquipableForBlackMage);
  }
}