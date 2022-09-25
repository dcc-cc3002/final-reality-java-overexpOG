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
     * Returns the type of the weapon.
     */
    String getType();

}
