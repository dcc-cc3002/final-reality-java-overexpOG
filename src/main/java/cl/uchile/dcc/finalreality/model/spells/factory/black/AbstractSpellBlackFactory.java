package cl.uchile.dcc.finalreality.model.spells.factory.black;

import cl.uchile.dcc.finalreality.model.spells.factory.AbstractSpellFactory;

/**
 * A class that adds odds to spellblack factories.
 *
 * @author Ignacio Alveal
 */
public abstract class AbstractSpellBlackFactory extends AbstractSpellFactory
        implements SpellBlackFactory {
  protected int odds;

  @Override
  public void setOdds(int odds) {
    this.odds = odds;
  }
}
