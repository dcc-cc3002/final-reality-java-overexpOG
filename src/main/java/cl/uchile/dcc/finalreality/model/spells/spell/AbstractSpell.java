package cl.uchile.dcc.finalreality.model.spells.spell;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A class that adds the cost in mana of the spell.
 *
 * @author Ignacio Alveal
 */
public abstract class AbstractSpell implements Spell {
  protected int mana;

  protected AbstractSpell(int mana) {
    this.mana = mana;
  }

  @Override
  public void magic(FinalReality game, Mage actualCharacter) {
    try {
      ArrayList<NonPlayableCharacter> enemyTeam = game.getCharacterOfComputer();
      System.out.println("select the enemy you want to atack with the spell:");
      System.out.println("0 to return.");
      for (int i = 1; i < enemyTeam.size() + 1; i++) {
        System.out.println(i + " to " + enemyTeam.get(i));
      }
      Scanner scanner2 = new Scanner(System.in);
      int number2 = scanner2.nextInt();
      if (number2 == 0) {
        actualCharacter.action(game);
      } else if (number2 >= enemyTeam.size() + 1) {
        System.out.println("out of range, select again");
        this.magic(game, actualCharacter);
      } else {
        NonPlayableCharacter enemyCharacter = enemyTeam.get(number2 - 1);
        int mageMana = actualCharacter.getCurrentMp() - this.mana;
        if (mageMana < 0) {
          System.out.println("you don't have enough mana, select an action again");
          actualCharacter.action(game);
        } else {
          actualCharacter.setCurrentMp(mageMana);
          magicPrima(game, actualCharacter, enemyCharacter);
        }
      }
    } catch (NumberFormatException e) {
      System.out.println("that is not a number, select again");
      this.magic(game, actualCharacter);
    }
  }

  /**
   * Causes each mage spell to have a different effect.
   */
  protected abstract void magicPrima(FinalReality game, Mage actualCharacter,
                                     GameCharacter objectiveCharacter);
}
