package cl.uchile.dcc.finalreality.model.spells.spell;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;

import java.util.Scanner;

public abstract class AbstractSpell implements Spell {
  protected int Mana;

  protected AbstractSpell(int mana) {
    this.Mana = mana;
  }

  protected int listString(Object[] list) {
    System.out.println("0 to return.");
    for(int i=1; i<list.length+1; i++) {
      System.out.println(i + " to " + list[i]);
    }
    Scanner scanner2 = new Scanner(System.in);
    return scanner2.nextInt();
  }

  @Override
  public void magic(FinalReality game, Mage actualCharacter) {
    try {
      NonPlayableCharacter[] enemyTeam = game.getCharacterOfComputer();
      System.out.println("select the enemy you want to atack with the spell:");
      int number2 = listString(enemyTeam);
      if (number2 == 0) {
        actualCharacter.action(game);
      } else if (number2 >= enemyTeam.length+1){
        System.out.println("out of range, select again");
        this.magic(game, actualCharacter);
      } else {
        NonPlayableCharacter enemyCharacter = enemyTeam[number2-1];
        int mageMana = actualCharacter.getCurrentMp() - this.Mana;
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

  protected abstract void magicPrima(FinalReality game, Mage actualCharacter, GameCharacter objectiveCharacter);
}
