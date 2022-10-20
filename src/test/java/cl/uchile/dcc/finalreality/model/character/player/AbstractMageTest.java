package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractMageTest {
  private BlockingQueue<GameCharacter> queue;
  private Mage character1;

  @BeforeEach
  void setUp() {
    queue = new LinkedBlockingQueue<>();
    character1 = new WhiteMage("Merry", 15, 5, 10, queue);
  }

  @Test
  void getCurrentMp() {
    assertEquals(10, character1.getCurrentMp());
  }

  @Test
  void setCurrentMp() {
    character1.setCurrentMp(8);
    assertEquals(8, character1.getCurrentMp());
  }

  @Test
  void getMaxMp() {
    assertEquals(10, character1.getMaxMp());
  }
}