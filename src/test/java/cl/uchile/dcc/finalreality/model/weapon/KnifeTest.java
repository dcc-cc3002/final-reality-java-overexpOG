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

class KnifeTest {
  private Weapon knife;
  private Weapon knifeX;
  private Weapon knifeY;
  private Weapon bow;

  @BeforeEach
  void setUp() {
    knife = new Knife("wooden knife", 1, 1);
    knifeX = new Knife("wooden knife", 1, 1);
    knifeY = new Knife("metal knife", 4, 5);
    bow = new Bow("wooden bow", 2, 2);
  }

  @Test
  void getType() {
    assertEquals("KNIFE",knife.getType());
  }

  @Test
  void testEquals() {
    assert(knife.equals(knifeX));
    assert(knife.equals(knife));
    assertFalse(knife.equals(knifeY));
    assertFalse(knife.equals(bow));
  }

  @Test
  void testToString() {
    assertEquals("Weapon{name='wooden knife', damage=1, weight=1, type=KNIFE}", knife.toString());
  }
}