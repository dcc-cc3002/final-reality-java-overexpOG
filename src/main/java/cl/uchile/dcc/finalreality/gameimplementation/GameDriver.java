package cl.uchile.dcc.finalreality.gameimplementation;

/**
 * Driver for finalreality.
 */
public class GameDriver {
  public static void playGame(FinalReality game){
    do {
      System.out.print(game);
      game.update();
    } while (game.notOver());
    if (game.isTie()) {
      System.out.println("tie");
    } else if (game.isPlayerWin()) {
      System.out.println("player win");
    } else if (game.isComputerWin()) {
      System.out.println("computer win");
    }
    System.out.println("game over");
  }
}
