/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMageTest {
  private Mage character1;
  private BlockingQueue<GameCharacter> queue;

  @BeforeEach
  void setUp() {
    queue = new LinkedBlockingQueue<>();
    character1 = new WhiteMage("Merry", 15, 5, 10, queue);
  }

  @Test
  void getCurrentMp() {
    assertEquals(10, character1.getCurrentMp());
  }

  @Test
  void setCurrentMp() {
    character1.setCurrentMp(8);
    assertEquals(8, character1.getCurrentMp());
    boolean currentMpNegativo = true;
    try {
      character1.setCurrentMp(-2);
    } catch (InvalidStatValueException e){
      currentMpNegativo = false;
    }
    assertEquals (false, currentMpNegativo);
    boolean currentMpMayorAMaxMp = true;
    try {
      character1.setCurrentMp(11);
    } catch (InvalidStatValueException e){
      currentMpMayorAMaxMp = false;
    }
    assertEquals (false, currentMpMayorAMaxMp);
  }

  @Test
  void getMaxMp() {
    assertEquals(10, character1.getMaxMp());
  }

  @Test
  void Constructor() {
    boolean MaxMpNegativoOCero = true;
    try {
      new BlackMage("Shihoru", 10, 6, 0, queue);
    } catch (InvalidStatValueException e){
      MaxMpNegativoOCero = false;
    }
    assertEquals (false, MaxMpNegativoOCero);
  }
}