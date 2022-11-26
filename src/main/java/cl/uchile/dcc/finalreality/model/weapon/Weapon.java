/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.weapon;

/**
 * This represents a weapon from the game.
 * A weapon can be equiped by the characters.
 *
 * @author Ignacio Alveal
 */
public interface Weapon {

  /**
   * Returns the name of the weapon.
   */
  String getName();

  /**
   * Returns the damage caused for the weapon.
   */
  int getDamage();

  /**
   * Returns the weight of the weapon.
   */
  int getWeight();

  /**
   * Returns the magic damage caused for the weapon.
   */
  int getMagicDamage();

  /**
   * Returns the type of the weapon.
   */
  String getType();

  /**
   * Returns true if the weapon can be equipped by a knight and false if not.
   */
  boolean isEquippableKnight();

  /**
   * Returns true if the weapon can be equipped by an engineer and false if not.
   */
  boolean isEquippableEngineer();

  /**
   * Returns true if the weapon can be equipped by a thief and false if not.
   */
  boolean isEquippableThief();

  /**
   * Returns true if the weapon can be equipped by a black mage and false if not.
   */
  boolean isEquippableBlackMage();

  /**
   * Returns true if the weapon can be equipped by a white mage and false if not.
   */
  boolean isEquippableWhiteMage();
}
