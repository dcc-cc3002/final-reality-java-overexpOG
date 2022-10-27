package cl.uchile.dcc.finalreality.exceptions;

/**
 * This error is used to represent that the weapon cannot be equipped for this character.
 *
 * @author Ignacio Alveal
 */
public class InvalidWeaponForThisCharacter extends RuntimeException {
  /**
   * Creates a new {@code InvalidWeaponForThisCharacter} with a description of the
   * error, saying the type of the weapon and the name of the character.
   */
  public InvalidWeaponForThisCharacter(String weapon, String character) {
    super("the " + weapon + " is not equipable for " + character + ".");
  }
}
