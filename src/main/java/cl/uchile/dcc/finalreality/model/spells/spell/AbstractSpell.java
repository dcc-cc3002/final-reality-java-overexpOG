package cl.uchile.dcc.finalreality.model.spells.spell;

public abstract class AbstractSpell implements Spell {
  private int Mana;

  protected AbstractSpell(int mana) {
    this.Mana = mana;
  }
}
