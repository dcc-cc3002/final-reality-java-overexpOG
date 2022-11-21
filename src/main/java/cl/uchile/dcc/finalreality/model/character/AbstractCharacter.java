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
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cl.uchile.dcc.finalreality.model.state.Normal;
import cl.uchile.dcc.finalreality.model.state.State;
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

  /**
   * Set state with astate (and also set the asbtractcharacter of state).
   */
  public void setState(State aState) {
    this.state = aState;
    state.setAbstractCharacter(this);
  }

  /**
   * Change state to normal.
   */
  public void normal () {
    state.normal();
  }

  /**
   * Paralyzed effect is added to the state.
   */
  public void paralysis () {
    state.paralysis();
  }

  /**
   * Burned effect is added to the state.
   */
  public void burned () {
    state.burned();
  }

  /**
   * Poisoned effect is added to the state.
   */
  public void poisoned () {
    state.poisoned();
  }

  /**
   * Returns true if the state is normal, false otherwise.
   */
  public boolean isNormal () {
    return state.isNormal();
  }

  /**
   * Returns true if the state is paralysis, false otherwise.
   */
  public boolean isParalysis () {
    return state.isParalysis();
  }

  /**
   * Returns true if the state is burned, false otherwise.
   */
  public boolean isBurned () {
    return state.isBurned();
  }

  /**
   * Returns true if the state is poisoned, false otherwise.
   */
  public boolean isPoisoned () {
    return state.isPoisoned();
  }

  /**
   * Returns true if the state is paralysis and burned, false otherwise.
   */
  public boolean isParalysis_Burned () {
    return state.isParalysis_Burned();
  }

  /**
   * Returns true if the state is paralysis and poisoned, false otherwise.
   */
  public boolean isParalysis_Poisoned () {
    return state.isParalysis_Poisoned();
  }

  /**
   * Returns true if the state is burned and poisoned, false otherwise.
   */
  public boolean isBurned_Poisoned () {
    return state.isBurned_Poisoned();
  }

  /**
   * Returns true if the state is paralysis, burned and poisoned, false otherwise.
   */
  public boolean isParalysis_Burned_Poisoned () {
    return state.isParalysis_Burned_Poisoned();
  }
}
