package cl.uchile.dcc.finalreality.gameimplementation;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;
import cl.uchile.dcc.finalreality.model.spells.factory.black.SpellBlackFactory;
import cl.uchile.dcc.finalreality.model.spells.factory.white.SpellWhiteFactory;
import cl.uchile.dcc.finalreality.model.spells.spell.Spell;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import org.jetbrains.annotations.NotNull;

/**
 * Class to enforce rules of finalreality.
 */
public class FinalReality {
  private int win = 0;
  private final BlockingQueue<GameCharacter> queue;
  private final ArrayList<PlayerCharacter> characterOfPlayer;
  private final ArrayList<NonPlayableCharacter> characterOfComputer;
  private final ArrayList<Weapon> weaponOfPlayer;
  private final ArrayList<SpellBlackFactory> blackMagic;
  private final ArrayList<SpellWhiteFactory> whiteMagic;

  public final BufferedReader in;

  /**
   * The game state is represented by a queue containing both player and computer characters,
   * arranged in the order in which each character performs actions (original).
   */
  public FinalReality(@NotNull ArrayList<PlayerCharacter> characterofplayer,
                      @NotNull ArrayList<NonPlayableCharacter> characterofcomputer,
                      ArrayList<Weapon> weaponofplayer,
                      ArrayList<SpellBlackFactory> blackmagic,
                      ArrayList<SpellWhiteFactory> whitemagic, BlockingQueue<GameCharacter> queue,
                      BufferedReader initIn) throws InterruptedException {
    this.queue = queue;
    this.characterOfPlayer = characterofplayer;
    this.characterOfComputer = characterofcomputer;
    this.weaponOfPlayer = weaponofplayer;
    this.blackMagic = blackmagic;
    this.whiteMagic = whitemagic;
    this.in = initIn;
    for (PlayerCharacter playerCharacter : characterOfPlayer) {
      playerCharacter.waitTurn();
    }
    for (NonPlayableCharacter nonPlayableCharacter : characterOfComputer) {
      nonPlayableCharacter.waitTurn();
    }
    Thread.sleep(6000);
  }

  /**
   * The game state is represented by a queue containing both player and computer characters,
   * arranged in the order in which each character performs actions (normal constructor).
   */
  public FinalReality(@NotNull ArrayList<PlayerCharacter> characterofplayer,
                      @NotNull ArrayList<NonPlayableCharacter> characterofcomputer,
                      ArrayList<Weapon> weaponofplayer,
                      ArrayList<SpellBlackFactory> blackmagic,
                      ArrayList<SpellWhiteFactory> whitemagic, BlockingQueue<GameCharacter> queue)
          throws InterruptedException {
    this(characterofplayer, characterofcomputer, weaponofplayer, blackmagic, whitemagic, queue,
            new BufferedReader(new InputStreamReader(System.in)));
  }

  /**
   * The game state is represented by a queue containing both player and computer characters,
   * arranged in the order in which each character performs actions (constructor for testing).
   */
  public FinalReality(@NotNull ArrayList<PlayerCharacter> characterofplayer,
                      @NotNull ArrayList<NonPlayableCharacter> characterofcomputer,
                      ArrayList<Weapon> weaponofplayer,
                      ArrayList<SpellBlackFactory> blackmagic,
                      ArrayList<SpellWhiteFactory> whitemagic, BlockingQueue<GameCharacter> queue,
                      String moves) throws InterruptedException {
    this(characterofplayer, characterofcomputer, weaponofplayer, blackmagic, whitemagic, queue,
            new BufferedReader(new StringReader(moves)));
  }

  /**
   * The game is not over until there is a winner.
   */
  public boolean notOver() {
    return this.win == 0;
  }

  /**
   * Return the value of win.
   */
  public int getWin() {
    return this.win;
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
    } else if (computerOver) {
      this.win = 2;
    }
  }

  /**
   * Ask the current character to make an action.
   */
  public void update() throws InterruptedException {
    GameCharacter actionCharacter = queue.poll();
    assert actionCharacter != null;
    if (actionCharacter.getCurrentHp() > 0) {
      if (this.applystate(actionCharacter)) {
        System.out.println(this);
        System.out.println("personaje actual: " + actionCharacter);
        actionCharacter.action(this);
      }
    }
    actionCharacter.waitTurn();
    Thread.sleep(2000);
  }

  /**
   * apply state for the actualCharacter, return true if the character is not paralyzed.
   */
  private boolean applystate(@NotNull GameCharacter actionCharacter) {
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
    if (actionCharacter.isParalysis()){
      actionCharacter.unparalysis();
      return false;
    } else {
      return true;
    }
  }

  /**
   * the actualCharacter make the action of atack the enemyTeam.
   */
  public void actionAtack(@NotNull GameCharacter actualCharacter,
                          @NotNull ArrayList<? extends GameCharacter> enemyTeam) {
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
    if (actualCharacter.isEquippable(this.weaponOfPlayer.get(weaponToEquip))) {
      Weapon weaponPrima = actualCharacter.getEquippedWeapon();
      actualCharacter.equip(this.weaponOfPlayer.get(weaponToEquip));
      this.weaponOfPlayer.add(weaponToEquip, weaponPrima);
      this.weaponOfPlayer.remove(weaponToEquip + 1);
      System.out.println("actual weapon: " + actualCharacter.getEquippedWeapon());
    } else {
      System.out.println("this weapon is not equipable by " + actualCharacter);
    }
    actualCharacter.action(this);
  }

  public void actionMagic(@NotNull PlayerCharacter actualCharacter) {
    actualCharacter.actionMagic(this);
    this.checkWinner();
  }

  public void magic(@NotNull Spell spelling, Mage actualCharacter) {
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
  public ArrayList<PlayerCharacter> getCharacterOfPlayer() {
    return characterOfPlayer;
  }

  /**
   * Returns the CharacterOfComputer for this game.
   */
  public ArrayList<NonPlayableCharacter> getCharacterOfComputer() {
    return characterOfComputer;
  }

  @Override
  public String toString() {
    System.out.println("allied characters:");
    for (PlayerCharacter playerCharacter : this.characterOfPlayer) {
      System.out.println(playerCharacter);
    }
    System.out.println("enemy characters:");
    for (NonPlayableCharacter nonPlayableCharacter : this.characterOfComputer) {
      System.out.println(nonPlayableCharacter);
    }
    return "";
  }
}
