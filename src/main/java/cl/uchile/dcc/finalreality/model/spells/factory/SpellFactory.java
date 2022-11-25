package cl.uchile.dcc.finalreality.model.spells.factory;

import cl.uchile.dcc.finalreality.model.spells.spell.Spell;

public interface SpellFactory {
  Spell create();
  void setMana(int mana);
}
