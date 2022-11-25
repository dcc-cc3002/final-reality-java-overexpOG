package cl.uchile.dcc.finalreality.model.spells.factory.black;

import cl.uchile.dcc.finalreality.model.spells.spell.black.Thunder;
import cl.uchile.dcc.finalreality.model.spells.spell.Spell;

public class ThunderFactory extends AbstractSpellBlackFactory {

  @Override
  public Spell create() {
    return new Thunder(Mana, Odds);
  }
}
