package cl.uchile.dcc.finalreality.model.spells.factory.black;

import cl.uchile.dcc.finalreality.model.spells.factory.AbstractSpellFactory;

public abstract class AbstractSpellBlackFactory extends AbstractSpellFactory implements SpellBlackFactory {
  protected int Odds;

  @Override
  public void setOdds(int odds) {
    this.Odds = odds;
  }
}
