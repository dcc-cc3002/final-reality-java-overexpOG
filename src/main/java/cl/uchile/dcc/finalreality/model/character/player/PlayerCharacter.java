/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.ArrayList;

/**
 * A {@link GameCharacter} that can equip a weapon.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Ignacio Alveal
 */
public interface PlayerCharacter extends GameCharacter {
  /**
   * Equip a weapon to the character if possible.
   */
  void equip(Weapon weapon);

  /**
   * Return this character's equipped weapon.
   */
  Weapon getEquippedWeapon();

  /**
   * Returns true if the weapon can be equipped and false if not.
   */
  boolean isEquippable(Weapon weapon);


  void actionEquip(FinalReality game, ArrayList<Weapon> weapons);

  void actionMagic(FinalReality game);

  void changeSpell(FinalReality game);
}
