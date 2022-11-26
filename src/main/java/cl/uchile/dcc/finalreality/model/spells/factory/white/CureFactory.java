package cl.uchile.dcc.finalreality.model.spells.factory.white;

import cl.uchile.dcc.finalreality.model.spells.factory.AbstractSpellFactory;
import cl.uchile.dcc.finalreality.model.spells.spell.Spell;
import cl.uchile.dcc.finalreality.model.spells.spell.white.Cure;

public class CureFactory extends AbstractSpellFactory implements SpellWhiteFactory{
  @Override
  public Spell create() {
    return new Cure(Mana);
  }
}