package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class AbstractCharacterTest {
  private GameCharacter character1;
  private BlockingQueue<GameCharacter> queue;

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
    boolean currentHpNegativo = true;
    try {
      character1.setCurrentHp(-2);
    } catch (InvalidStatValueException e){
      currentHpNegativo = false;
    }
    assertEquals (false, currentHpNegativo);
    boolean currentHpMayorAMaxHp = true;
    try {
      character1.setCurrentHp(11);
    } catch (InvalidStatValueException e){
      currentHpMayorAMaxHp = false;
    }
    assertEquals (false, currentHpMayorAMaxHp);
  }
  @Test
  void Constructor() {
    boolean MaxHpNegativoOCero = true;
    try {
      new Knight("Ranta", 0, 20, queue);
    } catch (InvalidStatValueException e){
      MaxHpNegativoOCero = false;
    }
    assertEquals (false, MaxHpNegativoOCero);
    boolean defenseNegativo = true;
    try {
      new Knight("Ranta", 10, -2, queue);
    } catch (InvalidStatValueException e){
      defenseNegativo = false;
    }
    assertEquals (false, defenseNegativo);
  }
}