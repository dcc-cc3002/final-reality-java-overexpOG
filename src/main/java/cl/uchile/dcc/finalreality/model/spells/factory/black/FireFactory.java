package cl.uchile.dcc.finalreality.model.spells.factory.black;

import cl.uchile.dcc.finalreality.model.spells.spell.Spell;
import cl.uchile.dcc.finalreality.model.spells.spell.black.Fire;

/**
 * A factory that generates fire spells.
 *
 * @author Ignacio Alveal
 */
public class FireFactory extends AbstractSpellBlackFactory {
  @Override
  public Spell create() {
    return new Fire(mana, odds);
  }
}
