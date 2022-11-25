package cl.uchile.dcc.finalreality.model.spells.spell.black;

import cl.uchile.dcc.finalreality.model.spells.spell.AbstractSpell;

public abstract class AbstractSpellBlack extends AbstractSpell implements SpellBlack{
  private int Odds;

  protected AbstractSpellBlack(int mana, int odds) {
    super(mana);
    this.Odds = odds;
  }
}
