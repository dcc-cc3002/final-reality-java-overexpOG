package cl.uchile.dcc.finalreality.model.character.nonplayable;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractNonPlayableCharacterTest {
  private NonPlayableCharacter character1;

  @BeforeEach
  void setUp() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    character1 = new Enemy("Jumbo", 7, 50, 20, queue);
  }

  @Test
  void getWeight() {
    assertEquals (7, character1.getWeight());
  }

  @Test
  void waitTurn() {
    character1.waitTurn();
  }
}