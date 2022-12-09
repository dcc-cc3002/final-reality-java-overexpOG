package cl.uchile.dcc.finalreality.model.spells.spell.black;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;

/**
 * The spell can paralyze the enemy.
 *
 * @author Ignacio Alveal
 */
public class Thunder extends AbstractSpellBlack {

  /**
   * Creates a new Thunder spell.
   *
   * @param mana
   *     the mana that the spell costs
   * @param odds
   *     the chances of paralyzing the enemy
   */
  public Thunder(int mana, int odds) {
    super(mana, odds);
  }

  @Override
  protected void magicPrimaPrima(FinalReality game, Mage actualCharacter,
                                 GameCharacter enemyCharacter) {
    System.out.println("you have paralyzed " + enemyCharacter);
    enemyCharacter.paralysis();
  }
}
