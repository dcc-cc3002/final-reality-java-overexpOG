package cl.uchile.dcc.finalreality.gameimplementation;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
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

  /**
   * The game state is represented by a queue containing both player and computer characters, arranged
   * in the order in which each character performs actions.
   */
  public FinalReality(PlayerCharacter[] characterofplayer, NonPlayableCharacter[] characterofcomputer,
                      @NotNull final BlockingQueue<GameCharacter> turnsQueue){
    this.CharacterOfPlayer = characterofplayer;
    this.CharacterOfComputer = characterofcomputer;
    this.queue = turnsQueue;
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
    if (this.win == 1 || this.win == 2){
      return false;
    } else {
      return true;
    }
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
    return;
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
   * Causes the playercharacter to take damage from damageReceived.
   */
  public void atack(int damageReceived, PlayerCharacter playerCharacter) {
    int Hp = playerCharacter.getCurrentHp();
    if (Hp - damageReceived < 0) {
      Hp = 0;
    } else {
      Hp = Hp - damageReceived;
    }
    playerCharacter.setCurrentHp(Hp);
    this.checkWinner();
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
