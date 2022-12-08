package cl.uchile.dcc.finalreality.model.spells.spell;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;

/**
 * This represents the spells of mages.
 *
 * @author Ignacio Alveal
 */
public interface Spell {

  /**
   * Makes the spell do magic.
   */
  void magic(FinalReality game, Mage actualCharacter);
}
