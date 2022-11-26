package cl.uchile.dcc.finalreality.model.spells.factory.black;

import cl.uchile.dcc.finalreality.model.spells.factory.SpellFactory;

/**
 * This represents the spell factories that black mage can use.
 *
 * @author Ignacio Alveal
 */
public interface SpellBlackFactory extends SpellFactory {

  /**
   * Set odds for SpellBlackFactory´s.
   */
  void setOdds(int odds);
}
