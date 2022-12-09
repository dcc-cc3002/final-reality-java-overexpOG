package cl.uchile.dcc.finalreality.model.spells.factory.white;

import cl.uchile.dcc.finalreality.model.spells.factory.AbstractSpellFactory;
import cl.uchile.dcc.finalreality.model.spells.spell.Spell;
import cl.uchile.dcc.finalreality.model.spells.spell.white.Poison;

/**
 * A factory that generates poison spells.
 *
 * @author Ignacio Alveal
 */
public class PoisonFactory extends AbstractSpellFactory implements SpellWhiteFactory {
  @Override
  public Spell create() {
    return new Poison(mana);
  }

  @Override
  public String toString() {
    return "PoisonSpell{mana='%d'}"
            .formatted(mana);
  }
}
