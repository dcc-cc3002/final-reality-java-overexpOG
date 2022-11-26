package cl.uchile.dcc.finalreality.model.spells.factory;

import cl.uchile.dcc.finalreality.model.spells.spell.Spell;

/**
 * This represents the spell factories.
 *
 * @author Ignacio Alveal
 */
public interface SpellFactory {

  /**
   * Create the spell of the factory.
   */
  Spell create();

  /**
   * Set mana for SpellFactory´s.
   */
  void setMana(int mana);
}
