package cl.uchile.dcc.finalreality.model.spells.factory.black;

import cl.uchile.dcc.finalreality.model.spells.spell.Spell;
import cl.uchile.dcc.finalreality.model.spells.spell.black.Thunder;

/**
 * A factory that generates thunder spells.
 *
 * @author Ignacio Alveal
 */
public class ThunderFactory extends AbstractSpellBlackFactory {

  @Override
  public Spell create() {
    return new Thunder(mana, odds);
  }
}
