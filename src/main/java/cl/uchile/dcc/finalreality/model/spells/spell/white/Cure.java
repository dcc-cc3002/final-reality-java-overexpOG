package cl.uchile.dcc.finalreality.model.spells.spell.white;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;
import cl.uchile.dcc.finalreality.model.spells.spell.AbstractSpell;

/**
 * The spell cure an ally.
 *
 * @author Ignacio Alveal
 */
public class Cure extends AbstractSpell implements SpellWhite {
  public Cure(int mana) {
    super(mana);
  }

  @Override
  public void magic(FinalReality game, Mage actualCharacter) {
    try {
      PlayerCharacter[] allyTeam = game.getCharacterOfPlayer();
      System.out.println("select the ally you want to heal with the spell:");
      int number2 = listString(allyTeam);
      if (number2 == 0) {
        actualCharacter.action(game);
      } else if (number2 >= allyTeam.length + 1) {
        System.out.println("out of range, select again");
        this.magic(game, actualCharacter);
      } else {
        PlayerCharacter allyCharacter = allyTeam[number2 - 1];
        int mageMana = actualCharacter.getCurrentMp() - this.mana;
        if (mageMana < 0) {
          System.out.println("you don't have enough mana, select an action again");
          actualCharacter.action(game);
        } else {
          actualCharacter.setCurrentMp(mageMana);
          magicPrima(game, actualCharacter, allyCharacter);
        }
      }
    } catch (NumberFormatException e) {
      System.out.println("that is not a number, select again");
      this.magic(game, actualCharacter);
    }
  }

  @Override
  protected void magicPrima(FinalReality game, Mage actualCharacter, GameCharacter allyCharacter) {
    System.out.println("you have healed " + allyCharacter);
    allyCharacter.setCurrentHp(Math.min(allyCharacter.getCurrentHp()
                    + (3 * allyCharacter.getMaxHp()) / 10,
            allyCharacter.getMaxHp()));
  }
}
