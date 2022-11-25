/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.common;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Sword}s,{@code Knife}s and
 * {@code Axe}s.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Ignacio Alveal
 */
public class Knight extends AbstractPlayerCharacter implements Common {

  /**
   * Creates a new Knight.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's maximum health points
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  public Knight(final @NotNull String name, final int maxHp, final int defense,
                final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public String toString() {
    return "Knight{name='%s', maxHp=%d, currentHp=%d, defense=%d}"
            .formatted(name, maxHp, currentHp, defense);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Knight.class, name, maxHp, currentHp, defense);
  }

  @Override
  public boolean equals(final Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof final Knight that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && name.equals(that.name)
            && maxHp == that.maxHp
            && currentHp == that.currentHp
            && defense == that.defense;
  }

  @Override
  public boolean isEquippable(Weapon weapon) {
    return weapon.isEquippableKnight();
  }
}
