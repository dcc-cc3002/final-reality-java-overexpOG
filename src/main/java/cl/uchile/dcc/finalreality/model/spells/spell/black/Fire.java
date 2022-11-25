package cl.uchile.dcc.finalreality.model.spells.spell.black;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;

public class Fire extends AbstractSpellBlack {
  public Fire(int mana, int odds) {
    super(mana, odds);
  }

  @Override
  public void magic(FinalReality game, Mage actualCharacter, NonPlayableCharacter enemyCharacter) {
    int mageMana = actualCharacter.getCurrentMp() - this.Mana;
    if (mageMana < 0) {
      System.out.println("you don't have enough mana, select an action again");
      actualCharacter.action(game);
    } else {
      actualCharacter.setCurrentMp(mageMana);
      int Hp = Math.max(enemyCharacter.getCurrentHp() - actualCharacter.getEquippedWeapon().getMagicDamage(), 0);
      enemyCharacter.setCurrentHp(Hp);
      int PBurnedEnemy = (int)(Math.random()*100);
      if (PBurnedEnemy < 20) {
        System.out.println("you have burned " + enemyCharacter);
        enemyCharacter.burned();
      }
    }
  }
}
