package cl.uchile.dcc.finalreality.model.weapon;

import java.util.Objects;

/**
 * A staff-type {@link Weapon}.
 *
 * @author Ignacio Alveal
 */
public class STAFF extends AbstractWeapon{

    private final String type;

    /**
     * Create a new staff.
     * @param name
     *     the weapon's name
     * @param damage
     *     the weapon's damage
     * @param weight
     *     the weapon's weight
     */

    public STAFF(final String name, final int damage, final int weight) {
        super(name, damage, weight);
        type = "STAFF";
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
        if (!(o instanceof final STAFF staff)) {
            return false;
        }
        return hashCode() == staff.hashCode()
                && damage == staff.damage
                && weight == staff.weight
                && name.equals(staff.name)
                && type.equals(staff.type);
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