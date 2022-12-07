package cl.uchile.dcc.finalreality.gameimplementation;

/**
 * Driver for finalreality.
 */
public class GameDriver {

  /**
   * Method to start the game.
   */
  public static void playGame(FinalReality game) throws InterruptedException {
    do {
      game.update();
    } while (game.notOver());
    int win = game.getWin();
    if (win == 3) {
      System.out.println("tie");
    } else if (win == 2) {
      System.out.println("player win");
    } else if (win == 1) {
      System.out.println("computer win");
    }
    System.out.println("game over");
  }
}
