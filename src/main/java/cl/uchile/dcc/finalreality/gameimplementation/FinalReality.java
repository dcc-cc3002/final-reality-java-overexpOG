package cl.uchile.dcc.finalreality.gameimplementation;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;
import cl.uchile.dcc.finalreality.model.spells.factory.black.SpellBlackFactory;
import cl.uchile.dcc.finalreality.model.spells.factory.white.SpellWhiteFactory;
import cl.uchile.dcc.finalreality.model.spells.spell.Spell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * Class to enforce rules of finalreality.
 */
public class FinalReality {
  private int win = 0;
  private PlayerCharacter[] characterOfPlayer;
  private NonPlayableCharacter[] characterOfComputer;
  private final BlockingQueue<GameCharacter> queue;
  private Weapon[] weaponOfPlayer;

  private final SpellBlackFactory[] blackMagic;
  private final SpellWhiteFactory[] whiteMagic;

  /**
   * The game state is represented by a queue containing both player and computer characters,
   * arranged in the order in which each character performs actions.
   */
  public FinalReality(@NotNull PlayerCharacter[] characterofplayer,
                      @NotNull NonPlayableCharacter[] characterofcomputer,
                      @NotNull final BlockingQueue<GameCharacter> turnsQueue,
                      Weapon[] weaponofplayer,
                      SpellBlackFactory[] blackmagic, SpellWhiteFactory[] whitemagic) {
    this.characterOfPlayer = characterofplayer;
    this.characterOfComputer = characterofcomputer;
    this.queue = turnsQueue;
    this.weaponOfPlayer = weaponofplayer;
    this.blackMagic = blackmagic;
    this.whiteMagic = whitemagic;
    for (PlayerCharacter playerCharacter : characterOfPlayer) {
      playerCharacter.waitTurn();
    }
    for (NonPlayableCharacter nonPlayableCharacter : characterOfComputer) {
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
    for (PlayerCharacter playerCharacter : characterOfPlayer) {
      if (playerCharacter.getCurrentHp() != 0) {
        playerOver = false;
      }
    }
    for (NonPlayableCharacter nonPlayableCharacter : characterOfComputer) {
      if (nonPlayableCharacter.getCurrentHp() != 0) {
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
  public void update() {
    GameCharacter actionCharacter = queue.poll();
    assert actionCharacter != null;
    this.applystate(actionCharacter);
    if (actionCharacter.isParalysis()){
      actionCharacter.unparalysis();
    } else {
      actionCharacter.action(this);
    }
    actionCharacter.waitTurn();
  }

  /**
   * apply state for the actualCharacter.
   */
  public void applystate(GameCharacter actionCharacter) {
    if (actionCharacter.isBurned()) {
      actionCharacter.setCurrentHp(Math.max(actionCharacter.getCurrentHp() - actionCharacter.getBurnedDamage(), 0));
      if (actionCharacter.getBurnedTime() - 1 > 0) {
        actionCharacter.burned(actionCharacter.getBurnedDamage(), actionCharacter.getBurnedTime() - 1);
      }else {
        actionCharacter.unburned();
      }
    }
    if (actionCharacter.isPoisoned()) {
      actionCharacter.setCurrentHp(Math.max(actionCharacter.getCurrentHp() - actionCharacter.getPoisonedDamage(), 0));
      if (actionCharacter.getPoisonedTime() - 1 > 0) {
        actionCharacter.burned(actionCharacter.getPoisonedDamage(), actionCharacter.getPoisonedTime() - 1);
      }else {
        actionCharacter.unpoisoned();
      }
    }
  }

  /**
   * the actualCharacter make the action of atack the enemyTeam.
   */
  public void actionAtack(@NotNull GameCharacter actualCharacter,
                          @NotNull GameCharacter[] enemyTeam) {
    actualCharacter.actionAtack(this, enemyTeam);
  }

  /**
   * the actualCharacter make the action of atacking the enemyCharacter.
   */
  public void atack(@NotNull GameCharacter actualCharacter, @NotNull GameCharacter enemyCharacter) {
    int hp = Math.max(Math.min(enemyCharacter.getCurrentHp() - actualCharacter.getDamage()
            + enemyCharacter.getDefense(), enemyCharacter.getCurrentHp()), 0);
    enemyCharacter.setCurrentHp(hp);
    this.checkWinner();
  }

  /**
   * the actualCharacter make the action to equip a weapon.
   */
  public void actionEquip(@NotNull PlayerCharacter actualCharacter) {
    actualCharacter.actionEquip(this, this.weaponOfPlayer);
  }

  /**
   * the actualCharacter equip weaponToEquip (the int represents a weapon).
   */
  public void equip(@NotNull PlayerCharacter actualCharacter, int weaponToEquip) {
    Weapon weaponPrima = actualCharacter.getEquippedWeapon();
    actualCharacter.equip(this.weaponOfPlayer[weaponToEquip]);
    this.weaponOfPlayer[weaponToEquip] = weaponPrima;
    actualCharacter.action(this);
  }

  public void actionMagic(@NotNull PlayerCharacter actualCharacter) {
    actualCharacter.actionMagic(this);
    this.checkWinner();
  }

  public void magic(Spell spelling, Mage actualCharacter) {
    spelling.magic(this, actualCharacter);
  }

  public void changeSpellBlackMagic(@NotNull Mage actualCharacter) {
    actualCharacter.changeSpell2(this, blackMagic);
  }

  public void changeSpellWhiteMagic(@NotNull Mage actualCharacter) {
    actualCharacter.changeSpell2(this, whiteMagic);
  }

  /**
   * Returns the CharacterOfPlayer for this game.
   */
  public PlayerCharacter[] getCharacterOfPlayer() {
    return characterOfPlayer;
  }

  /**
   * Returns the CharacterOfComputer for this game.
   */
  public NonPlayableCharacter[] getCharacterOfComputer() {
    return characterOfComputer;
  }
}
