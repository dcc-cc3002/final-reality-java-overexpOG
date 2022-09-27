/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that contains the behavior of Mage.
 *
 * @author Ignacio Alveal
 */

public abstract class AbstractMage extends AbstractPlayerCharacter implements PlayerCharacter {

  private int currentMp;
  protected final int maxMp;

  /**
   * Creates a new Mage.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param maxMp
   *     the character's max mp
   */
  protected AbstractMage(final @NotNull String name, final int maxHp, final int defense,
                         final int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(0, maxMp, "Max MP");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  /**
   * Returns the character's current MP.
   */
  public int getCurrentMp() {
    return currentMp;
  }

  /**
   * Sets the character's current MP.
   */
  public void setCurrentMp(final int currentMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, currentMp, "Current MP");
    Require.statValueAtMost(maxMp, currentMp, "Current MP");
    this.currentMp = currentMp;
  }

  /**
   * Returns the character's max MP.
   */
  public int getMaxMp() {
    return maxMp;
  }
}
