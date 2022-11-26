package cl.uchile.dcc.finalreality.model.spells.spell.white;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;
import cl.uchile.dcc.finalreality.model.spells.spell.AbstractSpell;

public class Palsy extends AbstractSpell implements SpellWhite {
  public Palsy(int mana) {
    super(mana);
  }

  @Override
  protected void magicPrima(FinalReality game, Mage actualCharacter, GameCharacter enemyCharacter) {
    System.out.println("you have paralyzed " + enemyCharacter);
    enemyCharacter.paralysis();
  }
}
