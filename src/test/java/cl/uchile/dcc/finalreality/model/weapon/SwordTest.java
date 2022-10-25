/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwordTest {
  private Weapon sword;
  private Weapon swordX;
  private Weapon swordY;
  private Weapon knife;

  @BeforeEach
  void setUp() {
    sword = new Sword("wooden sword", 4, 4);
    swordX = new Sword("wooden sword", 4, 4);
    swordY = new Sword("stone sword", 4, 4);
    knife = new Knife("wooden knife", 1, 1);
  }

  @Test
  void getType() {
    assertEquals("SWORD", sword.getType());
  }

  @Test
  void testEquals() {
    assert(sword.equals(swordX));
    assert(sword.equals(sword));
    assertFalse(sword.equals(swordY));
    assertFalse(sword.equals(knife));
  }

  @Test
  void testToString() {
    assertEquals("Weapon{name='wooden sword', damage=4, weight=4, type=SWORD}", sword.toString());
  }
}