package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * A sword-type {@link Weapon}.
 *
 * @author Ignacio Alveal
 */
public class SWORD extends AbstractWeapon{

    private final String type;

    /**
     * Create a new sword.
     * @param name
     *     the weapon's name
     * @param damage
     *     the weapon's damage
     * @param weight
     *     the weapon's weight
     */

    public SWORD(final String name, final int damage, final int weight) {
        super(name, damage, weight);
        type = "SWORD";
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
        if (!(o instanceof final SWORD sword)) {
            return false;
        }
        return hashCode() == sword.hashCode()
                && damage == sword.damage
                && weight == sword.weight
                && name.equals(sword.name)
                && type.equals(sword.type);
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