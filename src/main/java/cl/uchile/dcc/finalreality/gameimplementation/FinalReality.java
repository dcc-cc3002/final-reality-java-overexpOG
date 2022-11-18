package cl.uchile.dcc.finalreality.gameimplementation;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.nonplayable.Enemy;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

/**
 * Class to enforce rules of finalreality.
 */
public class FinalReality {
  private int win = 0;
  private PlayerCharacter[] CharacterOfPlayer;
  private NonPlayableCharacter[] CharacterOfComputer;
  private BlockingQueue<GameCharacter> queue;
  private Weapon[] WeaponOfPlayer;

  /**
   * The game state is represented by a queue containing both player and computer characters, arranged
   * in the order in which each character performs actions.
   */
  public FinalReality(PlayerCharacter[] characterofplayer, NonPlayableCharacter[] characterofcomputer,
                      @NotNull final BlockingQueue<GameCharacter> turnsQueue, Weapon[] weaponofplayer) {
    this.CharacterOfPlayer = characterofplayer;
    this.CharacterOfComputer = characterofcomputer;
    this.queue = turnsQueue;
    this.WeaponOfPlayer = weaponofplayer;
    for (PlayerCharacter playerCharacter : CharacterOfPlayer) {
      playerCharacter.waitTurn();
    }
    for (NonPlayableCharacter nonPlayableCharacter : CharacterOfComputer) {
      nonPlayableCharacter.waitTurn();
    }
  }

  /**
   * The game is not over until there is a winner.
   */
  public boolean notOver() {
    return this.win != 1 && this.win != 2;
  }

  /**
   * if a team has all its characters at 0 health, the opposing team wins.
   */
  private void checkWinner() {
    boolean playerOver = true;
    boolean computerOver = true;
    for (PlayerCharacter playerCharacter : CharacterOfPlayer) {
      if (playerCharacter.getCurrentHp()!=0) {
        playerOver = false;
      }
    }
    for (NonPlayableCharacter nonPlayableCharacter : CharacterOfComputer) {
      if (nonPlayableCharacter.getCurrentHp()!=0) {
        computerOver = false;
      }
    }
    if (playerOver) {
      this.win = 1;
    } else if (computerOver) {
      this.win = 2;
    }
  }

  /**
   * Ask the current character to make an action.
   */
  public void update() throws IOException {
    GameCharacter ActionCharacter = queue.poll();
    ActionCharacter.action(this);
    ActionCharacter.waitTurn();
  }

  /**
   * the actualCharactermake the action of atacking the enemyCharacter.
   */
  public void atack(@NotNull GameCharacter actualCharacter, @NotNull GameCharacter[] enemyCharacters) {
    GameCharacter atackedEnemy = new Enemy("", 1, 1, 1, queue, 1);
    for (GameCharacter enemyCharacter : enemyCharacters) {
      if (enemyCharacter.getCurrentHp() != 0) {
        atackedEnemy = enemyCharacter;
        break;
      }
    }
    int Hp = Math.max(atackedEnemy.getCurrentHp() - actualCharacter.getDamage(), 0);
    atackedEnemy.setCurrentHp(Hp);
    this.checkWinner();
  }

  /**
   * the actualCharacter make the action to equip a weapon.
   */
  public void actionEquip(@NotNull PlayerCharacter actualCharacter) {
    Weapon[] weapons = this.getWeaponOfPlayer();
    actualCharacter.actionEquip(this, weapons);
  }

  /**
   * the actualCharacter equip weaponToEquip (the int represents a weapon).
   */
  public void equip(@NotNull PlayerCharacter actualCharacter, int weaponToEquip) throws IOException {
    Weapon weaponPrima = actualCharacter.getEquippedWeapon();
    actualCharacter.equip(this.WeaponOfPlayer[weaponToEquip]);
    this.WeaponOfPlayer[weaponToEquip] = weaponPrima;
    actualCharacter.action(this);
  }

  public void actionMagic(@NotNull PlayerCharacter actualCharacter) {
    actualCharacter.actionMagic(this);
  }

  /**
   * Returns the CharacterOfPlayer for this game.
   */
  public PlayerCharacter[] getCharacterOfPlayer() {
    return CharacterOfPlayer;
  }

  /**
   * Returns the CharacterOfComputer for this game.
   */
  public NonPlayableCharacter[] getCharacterOfComputer() {
    return CharacterOfComputer;
  }

  /**
     * Returns the WeaponOfPlayer for this game.
   */
  private Weapon[] getWeaponOfPlayer() {
    return WeaponOfPlayer;
  }
}
