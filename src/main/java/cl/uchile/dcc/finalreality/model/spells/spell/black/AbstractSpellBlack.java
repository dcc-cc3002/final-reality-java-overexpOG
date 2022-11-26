package cl.uchile.dcc.finalreality.model.spells.spell.black;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;
import cl.uchile.dcc.finalreality.model.spells.spell.AbstractSpell;

public abstract class AbstractSpellBlack extends AbstractSpell implements SpellBlack{
  protected int Odds;

  protected AbstractSpellBlack(int mana, int odds) {
    super(mana);
    this.Odds = odds;
  }

  @Override
  protected void magicPrima(FinalReality game, Mage actualCharacter, GameCharacter enemyCharacter) {
    int Hp = Math.max(enemyCharacter.getCurrentHp() - actualCharacter.getEquippedWeapon().getMagicDamage(), 0);
    enemyCharacter.setCurrentHp(Hp);
    int PAdverseEffec = (int)(Math.random()*100);
    if (PAdverseEffec < this.Odds) {
      magicPrimaPrima(game, actualCharacter, enemyCharacter);
    }
  }

  protected abstract void magicPrimaPrima(FinalReality game, Mage actualCharacter, GameCharacter objectiveCharacter);
}
