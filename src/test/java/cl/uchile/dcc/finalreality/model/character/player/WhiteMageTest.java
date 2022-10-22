package cl.uchile.dcc.finalreality.model.character.player;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class WhiteMageTest {
  private PlayerCharacter character1;
  private PlayerCharacter character2;
  private PlayerCharacter character3;
  private PlayerCharacter character4;

  @BeforeEach
  void setUp() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    character1 = new WhiteMage("Merry", 15, 5, 10, queue);
    character2 = new WhiteMage("Merry", 15, 5, 10, queue);
    character3 = new WhiteMage("Merry", 8, 5, 10, queue);
    character4 = new BlackMage("Shihoru", 10, 6, 10, queue);
  }

  @Test
  void testToString() {
    assertEquals("WhiteMage{name='Merry', maxHp=15, currentHp=15, defense=5, maxMp=10, currentMp=10}", character1.toString());
  }

  @Test
  void testEquals() {
    assert (character1.equals(character1));
    assert (character1.equals(character2));
    assertFalse (character1.equals(character3));
    assertFalse (character1.equals(character4));
  }
}