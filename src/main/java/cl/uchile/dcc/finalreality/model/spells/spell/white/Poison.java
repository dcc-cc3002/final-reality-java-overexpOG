package cl.uchile.dcc.finalreality.model.spells.spell.white;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;
import cl.uchile.dcc.finalreality.model.spells.spell.AbstractSpell;

/**
 * The spell poisons an enemy.
 *
 * @author Ignacio Alveal
 */
public class Poison extends AbstractSpell implements SpellWhite {
  public Poison(int mana) {
    super(mana);
  }

  @Override
  protected void magicPrima(FinalReality game, Mage actualCharacter, GameCharacter enemyCharacter) {
    System.out.println("you have poisoned " + enemyCharacter);
    enemyCharacter.poisoned(actualCharacter.getEquippedWeapon().getMagicDamage() / 3, 6);
  }
}
