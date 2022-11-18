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
import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.concurrent.BlockingQueue;

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a Non-player character in the game.
 *
 * <p>All Non-player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of actions that are
 * waiting for their turn ({@code turnsQueue}), and a {@code weight}.
 *
 * @author Ignacio Alveal
 */
public abstract class AbstractNonPlayableCharacter
        extends AbstractCharacter implements NonPlayableCharacter {

  protected final int weight;
  protected final int damage;

  /**
   * Creates a new enemy.
   *
   * @param name       the character's name
   * @param weight     the character's weight
   * @param damage     the character's damage
   * @param maxHp      the character's maxHp
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  protected AbstractNonPlayableCharacter(final @NotNull String name, final int weight,
                                         final int maxHp, final int defense,
                                         final @NotNull BlockingQueue<GameCharacter> turnsQueue,
                                         final int damage)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, weight, "Weight");
    this.weight = weight;
    Require.statValueAtLeast(1, damage, "Damage");
    this.damage = damage;
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public int getDamage() {
    return damage;
  }

  @Override
  protected int waitTurn2() {
    return this.getWeight() / 10;
  }

  @Override
  public void action(FinalReality game){
    PlayerCharacter[] enemyTeam = game.getCharacterOfPlayer();
    try{
      game.atack(this, enemyTeam);
    } catch (AssertionError err) {
      System.err.println("Invalid atack! (" + this.damage + ", " + enemyTeam.toString() + ")");
    }
  }
}
