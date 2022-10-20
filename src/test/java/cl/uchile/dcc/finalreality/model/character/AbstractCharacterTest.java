package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCharacterTest {
  private BlockingQueue<GameCharacter> queue;
  private GameCharacter character1;

  @BeforeEach
  void setUp() {
    queue = new LinkedBlockingQueue<>();
    character1 = new Thief("Haruhiro", 10, 10, queue);
  }

  @Test
  void getName() {
    assertEquals("Haruhiro", character1.getName());
  }

  @Test
  void getCurrentHp() {
    assertEquals(10, character1.getCurrentHp());
  }

  @Test
  void getMaxHp() {
    assertEquals(10, character1.getMaxHp());
  }

  @Test
  void getDefense() {
    assertEquals(10, character1.getDefense());
  }

  @Test
  void setCurrentHp() {
    character1.setCurrentHp(8);
    assertEquals(8, character1.getCurrentHp());
  }
}