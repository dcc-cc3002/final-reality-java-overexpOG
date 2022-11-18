/*
 * "Final Reality" (c) by R8V and Ignacio Alveal
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */

package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponForThisCharacter;
import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * <p>All player characters have a {@code name}, a maximum amount of <i>hit points</i>
 * ({@code maxHp}), a {@code defense} value, a queue of {@link GameCharacter}s that are
 * waiting for their turn ({@code turnsQueue}), and can equip a {@link Weapon}.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Ignacio Alveal
 */
public abstract class AbstractPlayerCharacter extends AbstractCharacter implements
        PlayerCharacter {

  private Weapon equippedWeapon = null;

  /**
   * Creates a new character.
   * This constructor is <b>protected</b>, because it'll only be used by subclasses.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractPlayerCharacter(@NotNull final String name, final int maxHp, final int defense,
                                    @NotNull final BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense, turnsQueue);
  }

  @Override
  public void equip(Weapon weapon) {
    if (this.isEquippable(weapon)) {
      this.equippedWeapon = weapon;
    } else {
      throw new InvalidWeaponForThisCharacter(weapon.getType(), this.getName());
    }
  }

  @Override
  public Weapon getEquippedWeapon() {
    return equippedWeapon;
  }

  @Override
  public int getDamage() {
    return this.equippedWeapon.getDamage();
  }

  @Override
  protected int waitTurn2() {
    return this.getEquippedWeapon().getWeight() / 10;
  }

  @Override
  public void action(FinalReality game){
    Scanner scanner = new Scanner(System.in);
    System.out.println("select 1 to attack, 2 to change weapon, 3 to cast a spell");
    String s = scanner.nextLine();
    try {
      int number = Integer.parseInt(s);
      if (number == 1) {
        NonPlayableCharacter[] enemyTeam = game.getCharacterOfComputer();
        try{
          game.atack(this, enemyTeam);
        } catch (AssertionError err) {
          System.err.println("Invalid atack! (" + this.getEquippedWeapon().getDamage() + ", " + Arrays.toString(enemyTeam) + ")");
        }
      } else if (number == 2) {
        game.actionEquip(this);
      } else if (number == 3) {
        game.actionMagic(this);
      } else {
        System.out.println("out of range, select again");
        this.action(game);
      }
    } catch (NumberFormatException ex) {
      System.out.println("that is not a number, select again");
      this.action(game);
    }
  }

  @Override
  public void actionEquip(FinalReality game, Weapon[] weapons) {
    System.out.println("select the weapon you want to equip:");
    System.out.println("0 to (actual weapon) " + this.getEquippedWeapon());
    for(int i=1; i<weapons.length+1; i++){
      System.out.println(i + " to " + weapons[i]);
    }
    Scanner scanner2 = new Scanner(System.in);
    String s2 = scanner2.nextLine();
    try {
      int number2 = Integer.parseInt(s2);
      if (number2 >= weapons.length+1){
        System.out.println("out of range, select again");
        this.action(game);
      } else {
        game.equip(this, number2-1);
      }
    } catch (NumberFormatException ex){
      System.out.println("that is not a number, select again");
      this.action(game);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void actionMagic(FinalReality game) {
    System.out.println("this character is not a Mage, select again");
    this.action(game);
  }
}
