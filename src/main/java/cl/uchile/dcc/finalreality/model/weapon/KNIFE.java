package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * A knife-type {@link Weapon}.
 *
 * @author Ignacio Alveal
 */
public class KNIFE extends AbstractWeapon{

    private final String type;

    /**
     * Create a new knife.
     * @param name
     *     the weapon's name
     * @param damage
     *     the weapon's damage
     * @param weight
     *     the weapon's weight
     */

    public KNIFE(final String name, final int damage, final int weight) {
        super(name, damage, weight);
        type = "KNIFE";
    }

    @Override
    public String getType(){
        return type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof final KNIFE knife)) {
            return false;
        }
        return hashCode() == knife.hashCode()
                && damage == knife.damage
                && weight == knife.weight
                && name.equals(knife.name)
                && type.equals(knife.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(KNIFE.class, name, damage, weight, type);
    }

    @Override
    public String toString() {
        return "Weapon{name='%s', damage=%d, weight=%d, type=%s}"
                .formatted(name, damage, weight, type);
    }
}