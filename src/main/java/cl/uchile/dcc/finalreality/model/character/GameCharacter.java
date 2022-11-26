/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.ActionTurn;
import cl.uchile.dcc.finalreality.model.state.State;

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Ignacio Alveal
 */
public interface GameCharacter extends ActionTurn {

  /**
   * Returns this character's name.
   */
  String getName();

  /**
   * Returns this character's current HP.
   */
  int getCurrentHp();

  /**
   * Returns this character's max HP.
   */
  int getMaxHp();

  /**
   * Returns this character's defense.
   */
  int getDefense();

  /**
   * Sets this character's current HP to {@code newHp}.
   */
  void setCurrentHp(int hp) throws InvalidStatValueException;

  /**
   * the character make an action.
   */
  void action(FinalReality game);

  /**
   * Returns this character's damage.
   */
  int getDamage();

  void actionAtack(FinalReality game, GameCharacter[] enemyTeam);

  /**
   * Set state with astate (and also set the asbtractcharacter of state).
   */
  void setState(State astate);

  /**
   * Change state to normal.
   */
  void normal();

  /**
   * Paralyzed effect is added to the state.
   */
  void paralysis();

  /**
   * Burned effect is added to the state.
   */
  void burned(int burnedDamage, int burnedTime);

  /**
   * Poisoned effect is added to the state.
   */
  void poisoned(int poisonedDamage, int poisonedTime);

  /**
   * Paralyzed effect is removed to the state.
   */
  void unparalysis();

  /**
   * Burned effect is removed to the state.
   */
  void unburned();

  /**
   * Poisoned effect is removed to the state.
   */
  void unpoisoned();

  /**
   * Returns true if the state is normal, false otherwise.
   */
  boolean isNormal();

  /**
   * Returns true if the state is paralysis, false otherwise.
   */
  boolean isParalysis();

  /**
   * Returns true if the state is burned, false otherwise.
   */
  boolean isBurned();

  /**
   * Returns true if the state is poisoned, false otherwise.
   */
  boolean isPoisoned();

  /**
   * Returns the damage for burned of the state.
   */
  int getBurnedDamage();

  /**
   * Returns the damage for poisoned of the state.
   */
  int getPoisonedDamage();

  /**
   * Returns the burned duration of the state.
   */
  int getBurnedTime();

  /**
   * Returns the poisoned duration of the state.
   */
  int getPoisonedTime();
}
