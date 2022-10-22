package cl.uchile.dcc.finalreality.model.character.nonplayable;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class EnemyTest {
  private NonPlayableCharacter character1;
  private NonPlayableCharacter character2;
  private NonPlayableCharacter character3;
  private GameCharacter character4;

  @BeforeEach
  void setUp() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    character1 = new Enemy("Jumbo", 7, 50, 20, queue);
    character2 = new Enemy("Jumbo", 7, 50, 20, queue);
    character3 = new Enemy("Arnold", 8, 70, 10, queue);
    character4 = new BlackMage("Shihoru", 10, 6, 10, queue);
  }

  @Test
  void testToString() {
    assertEquals("Enemy{name='Jumbo', weight=7, maxHp=50, defense=20}", character1.toString());
  }

  @Test
  void testEquals() {
    assert (character1.equals(character1));
    assert (character1.equals(character2));
    assertFalse (character1.equals(character3));
    assertFalse (character1.equals(character4));
  }
}