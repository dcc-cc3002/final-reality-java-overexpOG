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
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class BlackMageTest {
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
    character1 = new BlackMage("Shihoru", 10, 6, 10, queue);
    character2 = new BlackMage("Shihoru", 10, 6, 10, queue);
    character3 = new BlackMage("Shihoru", 10, 3, 10, queue);
    character4 = new WhiteMage("Merry", 15, 5, 10, queue);
    sword = new Sword("wooden sword", 4, 4);
    axe = new Axe("wooden axe", 5, 5);
    knife = new Knife("wooden knife", 1, 1);
    staff = new Staff("wooden staff", 6, 6, 6);
    bow = new Bow("wooden bow", 2, 2);
  }

  @Test
  void testToString() {
    assertEquals("BlackMage{name='Shihoru', maxHp=10, currentHp=10, defense=6, maxMp=10, currentMp=10}", character1.toString());
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
    boolean swordIsEquipableByABlackMage = true;
    try {
      character1.equip(sword);
    } catch (InvalidWeaponForThisCharacter e) {
      swordIsEquipableByABlackMage = false;
    }
    assertEquals(false, swordIsEquipableByABlackMage);

    boolean axeIsEquipableByABlackMage = true;
    try {
      character1.equip(axe);
    } catch (InvalidWeaponForThisCharacter e) {
      axeIsEquipableByABlackMage = false;
    }
    assertEquals(false, axeIsEquipableByABlackMage);

    character1.equip(knife);

    character1.equip(staff);

    boolean bowIsEquipableByABlackMage = true;
    try {
      character1.equip(bow);
    } catch (InvalidWeaponForThisCharacter e) {
      bowIsEquipableByABlackMage = false;
    }
    assertEquals(false, bowIsEquipableByABlackMage);
  }
}