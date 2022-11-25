/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PlayerCharacter} that can equip {@code Staff}s and use <i>black magic</i>.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Ignacio Alveal
 */
public class BlackMage extends AbstractMage {

  /**
   * Creates a new Black Mage.
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
  public BlackMage(final @NotNull String name, final int maxHp, final int defense,
                      final int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, maxMp, turnsQueue);
  }

  @Override
  public String toString() {
    return "BlackMage{name='%s', maxHp=%d, currentHp=%d, defense=%d, maxMp=%d, currentMp=%d}"
            .formatted(name, maxHp, currentHp, defense, maxMp, currentMp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(BlackMage.class, name, maxHp, currentHp, defense, maxMp, currentMp);
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof final BlackMage that)) {
      return false;
    }
    return hashCode() == that.hashCode()
            && name.equals(that.name)
            && maxHp == that.maxHp
            && currentHp == that.currentHp
            && defense == that.defense
            && maxMp == that.maxMp
            && currentMp == that.currentMp;
  }

  @Override
  public boolean isEquippable(Weapon weapon) {
    return weapon.isEquippableBlackMage();
  }

  @Override
  public void changeSpell(FinalReality game) {
    game.changeSpellBlackMagic(this);
  }
}
