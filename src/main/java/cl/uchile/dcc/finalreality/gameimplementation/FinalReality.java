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
   * The game not over as long as both teams have character who do not have 0 life.
   */
  public boolean notOver() {
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
      return false;
    } else if (computerOver) {
      this.win = 2;
      return false;
    } else {
      return true;
    }
  }

  /**
   * Ask the current character to make an action.
   */
  public void update() throws IOException {
    GameCharacter ActionCharacter = queue.poll();
    ActionCharacter.action();
    ActionCharacter.waitTurn();
  }
}
