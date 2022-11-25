package cl.uchile.dcc.finalreality.gameimplementation;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;
import cl.uchile.dcc.finalreality.model.spells.factory.black.SpellBlackFactory;
import cl.uchile.dcc.finalreality.model.spells.factory.white.SpellWhiteFactory;
import cl.uchile.dcc.finalreality.model.spells.spell.Spell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.jetbrains.annotations.NotNull;
import java.io.IOException;
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

  private SpellBlackFactory[] BlackMagic;
  private SpellWhiteFactory[] WhiteMagic;

  /**
   * The game state is represented by a queue containing both player and computer characters, arranged
   * in the order in which each character performs actions.
   */
  public FinalReality(PlayerCharacter[] characterofplayer, NonPlayableCharacter[] characterofcomputer,
                      @NotNull final BlockingQueue<GameCharacter> turnsQueue, Weapon[] weaponofplayer,
                      SpellBlackFactory[] blackmagic, SpellWhiteFactory[] whitemagic) {
    this.CharacterOfPlayer = characterofplayer;
    this.CharacterOfComputer = characterofcomputer;
    this.queue = turnsQueue;
    this.WeaponOfPlayer = weaponofplayer;
    this.BlackMagic = blackmagic;
    this.WhiteMagic = whitemagic;
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
   * Return true if the computer win.
   */
  public boolean isComputerWin() {
    return this.win == 1;
  }

  /**
   * Return true if the player win.
   */
  public boolean isPlayerWin() {
    return this.win == 2;
  }

  /**
   * Return true if the player and computer tie.
   */
  public boolean isTie() {
    return this.win == 3;
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
      if (computerOver) {
        this.win = 3;
      }
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
   * the actualCharacter make the action of atack the enemyTeam.
   */
  public void actionAtack(@NotNull GameCharacter actualCharacter, @NotNull GameCharacter[] enemyTeam) {
    actualCharacter.actionAtack(this, enemyTeam);
  }

  /**
   * the actualCharacter make the action of atacking the enemyCharacter.
   */
  public void atack(@NotNull GameCharacter actualCharacter, @NotNull GameCharacter enemyCharacter) {
    int Hp = Math.max(enemyCharacter.getCurrentHp() - actualCharacter.getDamage(), 0);
    enemyCharacter.setCurrentHp(Hp);
    this.checkWinner();
  }

  /**
   * the actualCharacter make the action to equip a weapon.
   */
  public void actionEquip(@NotNull PlayerCharacter actualCharacter) {
    actualCharacter.actionEquip(this, this.WeaponOfPlayer);
  }

  /**
   * the actualCharacter equip weaponToEquip (the int represents a weapon).
   */
  public void equip(@NotNull PlayerCharacter actualCharacter, int weaponToEquip){
    Weapon weaponPrima = actualCharacter.getEquippedWeapon();
    actualCharacter.equip(this.WeaponOfPlayer[weaponToEquip]);
    this.WeaponOfPlayer[weaponToEquip] = weaponPrima;
    actualCharacter.action(this);
  }

  public void actionMagic(@NotNull PlayerCharacter actualCharacter){
    actualCharacter.actionMagic(this);
  }

  public void magic(Spell spelling, Mage actualCharacter, NonPlayableCharacter enemyCharacter) {
    spelling.magic(this, actualCharacter, enemyCharacter);
  }

  public void changeSpellBlackMagic(@NotNull Mage actualCharacter) {
    actualCharacter.changeSpell2(this, BlackMagic);
  }

  public void changeSpellWhiteMagic(@NotNull Mage actualCharacter) {
    actualCharacter.changeSpell2(this, BlackMagic);
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
}
