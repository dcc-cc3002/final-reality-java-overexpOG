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
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class ThiefTest {
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
    character1 = new Thief("Haruhiro", 10, 10, queue);
    character2 = new Thief("Haruhiro", 10, 10, queue);
    character3 = new Thief("Haruhiro", 8, 10, queue);
    character4 = new BlackMage("Shihoru", 10, 6, 10, queue);
    sword = new Sword("wooden sword", 4, 4);
    axe = new Axe("wooden axe", 5, 5);
    knife = new Knife("wooden knife", 1, 1);
    staff = new Staff("wooden staff", 6, 6);
    bow = new Bow("wooden bow", 2, 2);
  }

  @Test
  void testToString() {
    assertEquals("Thief{name='Haruhiro', maxHp=10, currentHp=10, defense=10}", character1.toString());
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
    character1.equip(sword);

    boolean axeIsEquipableByAThief = true;
    try {
      character1.equip(axe);
    } catch (InvalidWeaponForThisCharacter e) {
      axeIsEquipableByAThief = false;
    }
    assertEquals(false, axeIsEquipableByAThief);

    character1.equip(knife);

    boolean staffIsEquipableByAThief = true;
    try {
      character1.equip(staff);
    } catch (InvalidWeaponForThisCharacter e) {
      staffIsEquipableByAThief = false;
    }
    assertEquals(false, staffIsEquipableByAThief);

    character1.equip(bow);
  }
}