package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EngineerTest {
  private BlockingQueue<GameCharacter> queue;
  private PlayerCharacter character1;
  private PlayerCharacter character2;
  private PlayerCharacter character3;
  private PlayerCharacter character4;

  @BeforeEach
  void setUp() {
    queue = new LinkedBlockingQueue<>();
    character1 = new Engineer("Yume", 10, 8, queue);
    character2 = new Engineer("Yume", 10, 8, queue);
    character3 = new Engineer("Kiichi", 10, 8, queue);
    character4 = new BlackMage("Shihoru", 10, 6, 10, queue);
  }

  @Test
  void testToString() {
    assertEquals("Engineer{name='Yume', maxHp=10, currentHp=10, defense=8}", character2.toString());
  }

  @Test
  void testEquals() {
    assert (character1.equals(character1));
    assert (character1.equals(character2));
    assertFalse (character1.equals(character3));
    assertFalse (character1.equals(character4));
  }
}