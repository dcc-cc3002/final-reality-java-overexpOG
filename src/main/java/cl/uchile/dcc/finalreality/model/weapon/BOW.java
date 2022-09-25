/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.weapon;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;

import java.util.Objects;

/**
 * A bow-type {@link Weapon}.
 *
 * @author Ignacio Alveal
 */
public class BOW extends AbstractWeapon{

    private final String type;

    /**
     * Create a new bow.
     * @param name
     *     the weapon's name
     * @param damage
     *     the weapon's damage
     * @param weight
     *     the weapon's weight
     */

    public BOW(final String name, final int damage, final int weight) throws InvalidStatValueException {
        super(name, damage, weight);
        type = "BOW";
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
        if (!(o instanceof final BOW bow)) {
            return false;
        }
        return hashCode() == bow.hashCode()
                && damage == bow.damage
                && weight == bow.weight
                && name.equals(bow.name)
                && type.equals(bow.type);
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