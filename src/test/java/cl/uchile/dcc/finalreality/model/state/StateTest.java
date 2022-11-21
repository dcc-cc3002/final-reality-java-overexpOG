package cl.uchile.dcc.finalreality.model.state;

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.Knight;
import cl.uchile.dcc.finalreality.model.character.player.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class StateTest {

  private AbstractCharacter character1;
  private AbstractCharacter character2;
  private AbstractCharacter character3;
  private AbstractCharacter character4;

  @BeforeEach
  void setUp() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    character1 = new Thief("Haruhiro", 10, 10, queue);
    character2 = new Engineer("Yume", 10, 8, queue);
    character3 = new Knight("Ranta", 10, 20, queue);
    character4 = new BlackMage("Shihoru", 10, 6, 10, queue);
  }

  @Test
  void paralysis() {
    character1.paralysis();
    character1.paralysis();
    assert(character1.isParalysis());
    character2.burned();
    character2.paralysis();
    character2.burned();
    character2.paralysis();
    assert(character2.isParalysis_Burned());
    character3.poisoned();
    character3.paralysis();
    character3.poisoned();
    character3.paralysis();
    assert(character3.isParalysis_Poisoned());
    character4.burned();
    character4.poisoned();
    character4.paralysis();
    character4.burned();
    character4.poisoned();
    character4.paralysis();
    assert(character4.isParalysis_Burned_Poisoned());
  }

  @Test
  void burned() {
    character1.burned();
    character1.burned();
    assert(character1.isBurned());
    character2.paralysis();
    character2.burned();
    character2.paralysis();
    character2.burned();
    assert(character2.isParalysis_Burned());
    character3.poisoned();
    character3.burned();
    character3.poisoned();
    character3.burned();
    assert(character3.isBurned_Poisoned());
    character4.poisoned();
    character4.paralysis();
    character4.burned();
    character4.poisoned();
    character4.paralysis();
    character4.burned();
    assert(character4.isParalysis_Burned_Poisoned());
  }

  @Test
  void poisoned() {
    character1.poisoned();
    character1.poisoned();
    assert(character1.isPoisoned());
    character2.burned();
    character2.poisoned();
    character2.burned();
    character2.poisoned();
    assert(character2.isBurned_Poisoned());
    character3.paralysis();
    character3.poisoned();
    character3.paralysis();
    character3.poisoned();
    assert(character3.isParalysis_Poisoned());
    character4.burned();
    character4.paralysis();
    character4.poisoned();
    character4.burned();
    character4.paralysis();
    character4.poisoned();
    assert(character4.isParalysis_Burned_Poisoned());
  }

  @Test
  void normal() {
    character1.burned();
    assert(character1.isBurned());
    character1.normal();
    assert(character1.isNormal());
    character1.poisoned();
    assert(character1.isPoisoned());
    character1.normal();
    assert(character1.isNormal());
    character1.paralysis();
    assert(character1.isParalysis());
    character1.normal();
    assert(character1.isNormal());
    character1.burned();
    character1.poisoned();
    assert(character1.isBurned_Poisoned());
    character1.normal();
    assert(character1.isNormal());
    character1.paralysis();
    character1.burned();
    assert(character1.isParalysis_Burned());
    character1.normal();
    assert(character1.isNormal());
    character1.paralysis();
    character1.poisoned();
    assert(character1.isParalysis_Poisoned());
    character1.normal();
    assert(character1.isNormal());
    character1.paralysis();
    character1.burned();
    character1.poisoned();
    assert(character1.isParalysis_Burned_Poisoned());
    character1.normal();
    assert(character1.isNormal());
    character1.normal();
    assert(character1.isNormal());
  }

  @Test
  void isNot() {
    assert(!character1.isParalysis());
    character1.paralysis();
    assert(!character1.isNormal());
    assert(!character1.isBurned());
    assert(!character1.isPoisoned());
    assert(!character1.isParalysis_Burned());
    assert(!character1.isParalysis_Poisoned());
    assert(!character1.isParalysis_Burned_Poisoned());
    assert(!character1.isBurned_Poisoned());
  }
}