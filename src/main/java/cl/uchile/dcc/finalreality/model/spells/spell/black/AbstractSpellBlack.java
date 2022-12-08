package cl.uchile.dcc.finalreality.model.spells.spell.black;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;
import cl.uchile.dcc.finalreality.model.spells.spell.AbstractSpell;

/**
 * A class that adds odds to spell black.
 *
 * @author Ignacio Alveal
 */
public abstract class AbstractSpellBlack extends AbstractSpell implements SpellBlack {
  protected int odds;

  protected AbstractSpellBlack(int mana, int odds) {
    super(mana);
    this.odds = odds;
  }

  @Override
  protected void magicPrima(FinalReality game, Mage actualCharacter, GameCharacter enemyCharacter) {
    int hp = Math.max(enemyCharacter.getCurrentHp()
            - actualCharacter.getEquippedWeapon().getMagicDamage(), 0);
    enemyCharacter.setCurrentHp(hp);
    int padverseeffec = (int) (Math.random() * 100);
    if (padverseeffec < this.odds) {
      magicPrimaPrima(game, actualCharacter, enemyCharacter);
    }
  }

  /**
   * Causes each black mage spell to have a different effect.
   */
  protected abstract void magicPrimaPrima(FinalReality game, Mage actualCharacter,
                                          GameCharacter objectiveCharacter);
}
