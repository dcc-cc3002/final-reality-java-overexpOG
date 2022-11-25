package cl.uchile.dcc.finalreality.model.spells.factory;

public abstract class AbstractSpellFactory implements SpellFactory{

  protected int Mana;

  @Override
  public void setMana(int mana) {
    this.Mana = mana;
  }
}
