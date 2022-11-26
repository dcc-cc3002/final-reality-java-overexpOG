package cl.uchile.dcc.finalreality.model.spells.factory.white;

import cl.uchile.dcc.finalreality.model.spells.factory.AbstractSpellFactory;
import cl.uchile.dcc.finalreality.model.spells.spell.Spell;
import cl.uchile.dcc.finalreality.model.spells.spell.white.Palsy;

public class PalsyFactory extends AbstractSpellFactory implements SpellWhiteFactory{
  @Override
  public Spell create() {
    return new Palsy(Mana);
  }
}