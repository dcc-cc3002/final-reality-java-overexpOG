/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractWeaponTest {
  private Weapon knife;

  @BeforeEach
  void setUp() {
    knife = new Knife("wooden knife", 1, 1);
  }

  @Test
  void getName() {
    assertEquals("wooden knife", knife.getName());
  }

  @Test
  void getDamage() {
    assertEquals(1, knife.getDamage());
  }

  @Test
  void getWeight() {
    assertEquals(1, knife.getWeight());
  }

  @Test
  void constructor() {
    boolean WeightNegativoOCero = true;
    try {
      new Knife("air knife", 10, 0);
    } catch (InvalidStatValueException e) {
      WeightNegativoOCero = false;
    }
    assertEquals(false, WeightNegativoOCero);


    boolean DamageNegative = true;
    try {
      new Knife("healing knife", -2, 3);
    } catch (InvalidStatValueException e) {
      DamageNegative = false;
    }
    assertEquals(false, DamageNegative);
  }
}