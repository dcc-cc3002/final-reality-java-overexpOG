/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.nonplayable;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a Non-player character in the game.
 *
 * <p>All Non-player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and a {@code weight}.
 *
 * @author Ignacio Alveal
 */
public abstract class AbstractNonPlayableCharacter
        extends AbstractCharacter implements NonPlayableCharacter {
  protected final BlockingQueue<GameCharacter> turnsQueue;
  private ScheduledExecutorService scheduledExecutor;
  protected final int weight;

  /**
   * Creates a new enemy.
   *
   * @param name       the character's name
   * @param weight     the character's name
   * @param maxHp      the character's weight
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  protected AbstractNonPlayableCharacter(final @NotNull String name, final int weight,
                                         final int maxHp, final int defense,
                                         final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
    this.turnsQueue = turnsQueue;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    var npc = this;
    scheduledExecutor.schedule(
            /* command = */ this::addToQueue,
            /* delay = */ npc.getWeight() / 10,
            /* unit = */ TimeUnit.SECONDS);
  }
}
