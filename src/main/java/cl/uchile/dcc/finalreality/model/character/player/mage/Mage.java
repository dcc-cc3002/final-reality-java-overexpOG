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
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.spells.factory.SpellFactory;
import cl.uchile.dcc.finalreality.model.spells.spell.Spell;
import java.util.ArrayList;

/**
 * A {@link PlayerCharacter} with mana and who can use magic.
 *
 * @author Ignacio Alveal
 */
public interface Mage extends PlayerCharacter {

  /**
   * Returns the character's current MP.
   */
  int getCurrentMp();

  /**
   * Sets the character's current MP.
   */
  void setCurrentMp(final int currentMp)throws InvalidStatValueException;

  /**
   * Returns the character's max MP.
   */
  int getMaxMp();

  Spell spelling();

  void setSpellFactory(SpellFactory aspellfactory);

  void changeSpell2(FinalReality game, ArrayList<? extends SpellFactory> listmagic);
}
