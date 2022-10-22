package cl.uchile.dcc.finalreality.exceptions;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class RequireTest {
  private PlayerCharacter character1;

  @BeforeEach
  void setUp() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    character1 = new Thief("Haruhiro", 10, 10, queue);
  }

  @Test
  void statValueAtLeast() {
    int AtLeast = 0;
    try {
      character1.setCurrentHp(-2);
    } catch (InvalidStatValueException e){
      AtLeast = 1;
    }
    assertEquals (1, AtLeast);
  }

  @Test
  void statValueAtMost() {
    int AtMost = 0;
    try {
      character1.setCurrentHp(11);
    } catch (InvalidStatValueException e){
      AtMost = 1;
    }
    assertEquals (1, AtMost);
  }
}