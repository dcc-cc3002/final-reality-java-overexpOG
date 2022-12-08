/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.nonplayable;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;

/**
 * A {@link GameCharacter} non-playable with weight.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Ignacio Alveal
 */
public interface NonPlayableCharacter extends GameCharacter {

  /**
   * Returns the weight of this enemy.
   */
  int getWeight();

  /**
   * Returns this enemy's damage.
   */
  int getDamage();
}
