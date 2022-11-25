package cl.uchile.dcc.finalreality.model.spells.spell;

public abstract class AbstractSpell implements Spell {
  protected int Mana;

  protected AbstractSpell(int mana) {
    this.Mana = mana;
  }
}
