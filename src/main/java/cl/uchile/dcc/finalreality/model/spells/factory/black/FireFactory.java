package cl.uchile.dcc.finalreality.model.spells.factory.black;

import cl.uchile.dcc.finalreality.model.spells.spell.black.Fire;
import cl.uchile.dcc.finalreality.model.spells.spell.Spell;

public class FireFactory extends AbstractSpellBlackFactory {
  @Override
  public Spell create() {
    return new Fire(Mana, Odds);
  }
}
