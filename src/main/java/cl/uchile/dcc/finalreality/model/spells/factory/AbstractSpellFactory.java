package cl.uchile.dcc.finalreality.model.spells.factory;

/**
 * A class that adds the cost in mana of the spell factories.
 *
 * @author Ignacio Alveal
 */
public abstract class AbstractSpellFactory implements SpellFactory {

  protected int mana;

  @Override
  public void setMana(int mana) {
    this.mana = mana;
  }
}
