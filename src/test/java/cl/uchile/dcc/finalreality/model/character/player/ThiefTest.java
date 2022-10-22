package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class ThiefTest {
  private PlayerCharacter character1;
  private PlayerCharacter character2;
  private PlayerCharacter character3;
  private PlayerCharacter character4;

  @BeforeEach
  void setUp() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    character1 = new Thief("Haruhiro", 10, 10, queue);
    character2 = new Thief("Haruhiro", 10, 10, queue);
    character3 = new Thief("Haruhiro", 8, 10, queue);
    character4 = new BlackMage("Shihoru", 10, 6, 10, queue);
  }

  @Test
  void testToString() {
    assertEquals("Thief{name='Haruhiro', maxHp=10, currentHp=10, defense=10}", character1.toString());
  }

  @Test
  void testEquals() {
    assert (character1.equals(character1));
    assert (character1.equals(character2));
    assertFalse (character1.equals(character3));
    assertFalse (character1.equals(character4));
  }
}