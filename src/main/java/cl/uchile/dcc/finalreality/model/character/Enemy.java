/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Ignacio Alveal
 */
public class Enemy extends AbstractNonPlayableCharacter {

  /**
   * Creates a new enemy.
   *
   * @param name       the character's name
   * @param weight     the character's name
   * @param maxHp      the character's weight
   * @param defense    the character's defense
   * @param turnsQueue the queue with the characters waiting for their turn
   */
  public Enemy(final @NotNull String name, final int weight, final int maxHp, final int defense,
               final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, weight, maxHp, defense, turnsQueue);
  }

  @Override
  public String toString() {
    return "Enemy{name='%s', maxHp=%d, defense=%d, weight=%d}"
            .formatted(name, maxHp, defense, weight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Enemy.class, name, maxHp, defense, weight);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final Enemy enemy)) {
      return false;
    }
    return hashCode() == enemy.hashCode()
            && name.equals(enemy.name)
            && maxHp == enemy.maxHp
            && defense == enemy.defense
            && weight == enemy.weight;
  }
}
