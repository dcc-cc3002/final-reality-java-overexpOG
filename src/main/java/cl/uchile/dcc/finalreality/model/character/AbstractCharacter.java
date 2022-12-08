/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.model.state.Normal;
import cl.uchile.dcc.finalreality.model.state.State;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Ignacio Alveal
 */
public abstract class AbstractCharacter implements GameCharacter {

  protected int currentHp;
  protected final int maxHp;
  protected final int defense;
  protected final String name;
  private State state;
  private ScheduledExecutorService scheduledExecutor;
  protected final BlockingQueue<GameCharacter> turnsQueue;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   */
  protected AbstractCharacter(final @NotNull String name, final int maxHp, final int defense,
                              @NotNull final BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    Require.statValueAtLeast(1, maxHp, "Max HP");
    Require.statValueAtLeast(0, defense, "Defense");
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.defense = defense;
    this.name = name;
    this.turnsQueue = turnsQueue;
    this.setState(new Normal());
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public int getCurrentHp() {
    return currentHp;
  }

  @Override
  public int getMaxHp() {
    return maxHp;
  }

  @Override
  public int getDefense() {
    return defense;
  }

  @Override
  public void setCurrentHp(int hp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, hp, "Current HP");
    Require.statValueAtMost(maxHp, hp, "Current HP");
    currentHp = hp;
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

  /**
   * Adds this character to the turns queue.
   */
  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    scheduledExecutor.schedule(
            /* command = */ this::addToQueue,
            /* delay = */ this.waitTurn2(),
            /* unit = */ TimeUnit.SECONDS);
  }

  /**
   * Auxiliary method for waitTurn.
   */
  protected abstract int waitTurn2();

  @Override
  public void setState(State astate) {
    this.state = astate;
    state.setAbstractCharacter(this);
  }

  @Override
  public void normal() {
    state.normal();
  }

  @Override
  public void paralysis() {
    state.paralysis();
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    state.burned(burnedDamage, burnedTime);
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    state.poisoned(poisonedDamage, poisonedTime);
  }

  @Override
  public void unparalysis() {
    state.unparalysis();
  }

  @Override
  public void unburned() {
    state.unburned();
  }

  @Override
  public void unpoisoned() {
    state.unpoisoned();
  }

  @Override
  public boolean isNormal() {
    return state.isNormal();
  }

  @Override
  public boolean isParalysis() {
    return state.isParalysis();
  }

  @Override
  public boolean isBurned() {
    return state.isBurned();
  }

  @Override
  public boolean isPoisoned() {
    return state.isPoisoned();
  }

  @Override
  public int getBurnedDamage() {
    return state.getBurnedDamage();
  }

  @Override
  public int getPoisonedDamage() {
    return state.getPoisonedDamage();
  }

  @Override
  public int getBurnedTime() {
    return state.getBurnedTime();
  }

  @Override
  public int getPoisonedTime() {
    return state.getPoisonedTime();
  }
}
