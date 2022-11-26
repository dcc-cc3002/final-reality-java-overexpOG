/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.nonplayable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractNonPlayableCharacterTest {
  private NonPlayableCharacter character1;
  private BlockingQueue<GameCharacter> queue;

  @BeforeEach
  void setUp() {
    queue = new LinkedBlockingQueue<>();
    character1 = new Enemy("Jumbo", 7, 50, 20, queue, 5);
  }

  @Test
  void getWeight() {
    assertEquals (7, character1.getWeight());
  }

  @Test
  void getDamage() {
    assertEquals (5, character1.getDamage());
  }

  @Test
  void waitTurn() {
    character1.waitTurn();
  }

  @Test
  void Constructor() {
    boolean WeightNegativoOCero = true;
    try {
      new Enemy("Jumbo", 0, 50, 20, queue, 5);
    } catch (InvalidStatValueException e) {
      WeightNegativoOCero = false;
    }
    assertEquals(false, WeightNegativoOCero);

    boolean DamageNegativoOCero = true;
    try {
      new Enemy("Jumbo", 7, 50, 20, queue, 0);
    } catch (InvalidStatValueException e) {
      DamageNegativoOCero = false;
    }
    assertEquals(false, DamageNegativoOCero);
  }
}