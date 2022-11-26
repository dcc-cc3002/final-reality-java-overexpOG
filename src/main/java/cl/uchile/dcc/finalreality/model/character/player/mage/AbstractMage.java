/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player.mage;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.Require;
import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter;
import cl.uchile.dcc.finalreality.model.spells.spell.Spell;
import cl.uchile.dcc.finalreality.model.spells.factory.SpellFactory;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * An abstract class that contains the behavior of Mage.
 *
 * @author Ignacio Alveal
 */

public abstract class AbstractMage extends AbstractPlayerCharacter implements Mage {

  private SpellFactory spellFactory = null;
  protected int currentMp;
  protected final int maxMp;

  /**
   * Creates a new Mage.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   * @param maxMp
   *     the character's max mp
   */
  protected AbstractMage(final @NotNull String name, final int maxHp, final int defense,
                         final int maxMp, final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
    Require.statValueAtLeast(1, maxMp, "Max MP");
    this.maxMp = maxMp;
    this.currentMp = maxMp;
  }

  @Override
  public int getCurrentMp() {
    return currentMp;
  }

  @Override
  public void setCurrentMp(final int currentMp) throws InvalidStatValueException {
    Require.statValueAtLeast(0, currentMp, "Current MP");
    Require.statValueAtMost(maxMp, currentMp, "Current MP");
    this.currentMp = currentMp;
  }

  @Override
  public int getMaxMp() {
    return maxMp;
  }

  public Spell spelling() {
    return spellFactory.create();
  }

  public void setSpellFactory(SpellFactory aSpellfactory) {
    spellFactory = aSpellfactory;
  }

  @Override
  public void changeSpell2(FinalReality game, SpellFactory[] listmagic) {
    try {
      System.out.println("select the spell you want to use:");
      int number2 = listString(listmagic);
      if (number2 == 0) {
        this.action(game);
      } else if (number2 >= listmagic.length+1){
        System.out.println("out of range, select again");
        this.changeSpell2(game, listmagic);
      } else {
        this.setSpellFactory(listmagic[number2-1]);
      }
    } catch (NumberFormatException ex) {
      System.out.println("that is not a number, select again");
      this.changeSpell2(game, listmagic);
    }
  }

  @Override
  public void actionMagic(FinalReality game) {
    if (spellFactory == null) {
      this.changeSpell(game);
    }
    try {
      NonPlayableCharacter[] enemyTeam = game.getCharacterOfComputer();
      System.out.println("select the enemy you want to atack with the spell:");
      int number2 = listString(enemyTeam);
      if (number2 == 0) {
        this.action(game);
      } else if (number2 >= enemyTeam.length+1){
        System.out.println("out of range, select again");
        this.actionMagic(game);
      } else {
        game.magic(this.spelling(), this, enemyTeam[number2-1]);
      }
    } catch (NumberFormatException e) {
      System.out.println("that is not a number, select again");
      this.actionMagic(game);
    }
  }
}