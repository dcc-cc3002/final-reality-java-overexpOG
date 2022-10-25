/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import static org.junit.jupiter.api.Assertions.*;

class AbstractPlayerCharacterTest {
  private Weapon knife;
  private Weapon sword;
  private PlayerCharacter character1;

  @BeforeEach
  void setUp() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    knife = new Knife("wooden knife", 1, 1);
    sword = new Sword("wooden sword", 4, 4);
    character1 = new Thief("Haruhiro", 10, 10, queue);
  }

  @Test
  void equip() {
    character1.equip(knife);
    character1.equip(sword);
  }

  @Test
  void getEquippedWeapon() {
    assertEquals(null, character1.getEquippedWeapon());
    character1.equip(knife);
    assertEquals(knife, character1.getEquippedWeapon());
    character1.equip(sword);
    assertEquals(sword, character1.getEquippedWeapon());
  }

  @Test
  void waitTurn() {
    boolean waitTurnCharacterWithoutWeapon = true;
    try {
      character1.waitTurn();
    } catch (Exception e){
      waitTurnCharacterWithoutWeapon = false;
    }
    assertEquals(false, waitTurnCharacterWithoutWeapon);
    character1.equip(knife);
    character1.waitTurn();
  }
}