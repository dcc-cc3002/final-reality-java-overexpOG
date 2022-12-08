package cl.uchile.dcc.finalreality.model.state;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.common.Engineer;
import cl.uchile.dcc.finalreality.model.character.player.common.Knight;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class StateTest {

  private GameCharacter character1;
  private GameCharacter character2;
  private GameCharacter character3;
  private GameCharacter character4;

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
    character2.burned(1, 1);
    character2.paralysis();
    character2.burned(2, 2);
    character2.paralysis();
    assert(character2.isParalysis() && character2.isBurned());
    character3.poisoned(1, 1);
    character3.paralysis();
    character3.poisoned(2, 2);
    character3.paralysis();
    assert(character3.isParalysis() && character3.isPoisoned());
    character4.burned(1, 1);
    character4.poisoned(1, 1);
    character4.paralysis();
    character4.burned(2, 2);
    character4.poisoned(2, 2);
    character4.paralysis();
    assert(character4.isParalysis() && character4.isBurned() && character4.isPoisoned());
  }

  @Test
  void unparalysis() {
    character1.paralysis();
    assert(character1.isParalysis());
    character1.unparalysis();
    assert(character1.isNormal());
    character1.unparalysis();
    assert(character1.isNormal());
    character2.burned(1, 1);
    character2.paralysis();
    assert(character2.isParalysis() && character2.isBurned());
    character2.unparalysis();
    assert(character2.isBurned());
    character2.unparalysis();
    assert(character2.isBurned());
    character3.poisoned(1, 1);
    character3.paralysis();
    assert(character3.isParalysis() && character3.isPoisoned());
    character3.unparalysis();
    assert(character3.isPoisoned());
    character3.unparalysis();
    assert(character3.isPoisoned());
    character4.burned(1, 1);
    character4.poisoned(1, 1);
    character4.paralysis();
    assert(character4.isParalysis() && character4.isBurned() && character4.isPoisoned());
    character4.unparalysis();
    assert(character4.isBurned() && character4.isPoisoned());
    character4.unparalysis();
    assert(character4.isBurned() && character4.isPoisoned());
  }

  @Test
  void burned() {
    character1.burned(1, 1);
    character1.burned(2, 2);
    assert(character1.isBurned());
    character2.paralysis();
    character2.burned(1, 1);
    character2.paralysis();
    character2.burned(2, 2);
    assert(character2.isParalysis() && character2.isBurned());
    character3.poisoned(1, 1);
    character3.burned(1, 1);
    character3.poisoned(2, 2);
    character3.burned(2, 2);
    assert(character3.isBurned() && character3.isPoisoned());
    character4.poisoned(1, 1);
    character4.paralysis();
    character4.burned(1, 1);
    character4.poisoned(2, 2);
    character4.paralysis();
    character4.burned(2, 2);
    assert(character4.isParalysis() && character4.isBurned() && character4.isPoisoned());
  }

  @Test
  void unburned() {
    character1.burned(1, 1);
    assert(character1.isBurned());
    character1.unburned();
    assert(character1.isNormal());
    character1.unburned();
    assert(character1.isNormal());
    character2.paralysis();
    character2.burned(1, 1);
    assert(character2.isParalysis() && character2.isBurned());
    character2.unburned();
    assert(character2.isParalysis());
    character2.unburned();
    assert(character2.isParalysis());
    character3.poisoned(1, 1);
    character3.burned(1, 1);
    assert(character3.isBurned() && character3.isPoisoned());
    character3.unburned();
    assert(character3.isPoisoned());
    character3.unburned();
    assert(character3.isPoisoned());
    character4.poisoned(1, 1);
    character4.paralysis();
    character4.burned(1, 1);
    assert(character4.isParalysis() && character4.isBurned() && character4.isPoisoned());
    character4.unburned();
    assert(character4.isParalysis() && character4.isPoisoned());
    character4.unburned();
    assert(character4.isParalysis() && character4.isPoisoned());
  }

  @Test
  void poisoned() {
    character1.poisoned(1, 1);
    character1.poisoned(2, 2);
    assert(character1.isPoisoned());
    character2.burned(1, 1);
    character2.poisoned(1, 1);
    character2.burned(2, 2);
    character2.poisoned(2, 2);
    assert(character2.isBurned() && character2.isPoisoned());
    character3.paralysis();
    character3.poisoned(1, 1);
    character3.paralysis();
    character3.poisoned(2, 2);
    assert(character3.isParalysis() && character3.isPoisoned());
    character4.burned(1, 1);
    character4.paralysis();
    character4.poisoned(1, 1);
    character4.burned(2, 2);
    character4.paralysis();
    character4.poisoned(2, 2);
    assert(character4.isParalysis() && character4.isBurned() && character4.isPoisoned());
  }

  @Test
  void unpoisoned() {
    character1.poisoned(1, 1);
    assert(character1.isPoisoned());
    character1.unpoisoned();
    assert(character1.isNormal());
    character1.unpoisoned();
    assert(character1.isNormal());
    character2.paralysis();
    character2.poisoned(1, 1);
    assert(character2.isParalysis() && character2.isPoisoned());
    character2.unpoisoned();
    assert(character2.isParalysis());
    character2.unpoisoned();
    assert(character2.isParalysis());
    character3.burned(1, 1);
    character3.poisoned(1, 1);
    assert(character3.isBurned() && character3.isPoisoned());
    character3.unpoisoned();
    assert(character3.isBurned());
    character3.unpoisoned();
    assert(character3.isBurned());
    character4.paralysis();
    character4.burned(1, 1);
    character4.poisoned(1, 1);
    assert(character4.isParalysis() && character4.isBurned() && character4.isPoisoned());
    character4.unpoisoned();
    assert(character4.isParalysis() && character4.isBurned());
    character4.unpoisoned();
    assert(character4.isParalysis() && character4.isBurned());
  }

  @Test
  void normal() {
    character1.burned(1, 1);
    assert(character1.isBurned());
    character1.normal();
    assert(character1.isNormal());
    character1.poisoned(1, 1);
    assert(character1.isPoisoned());
    character1.normal();
    assert(character1.isNormal());
    character1.paralysis();
    assert(character1.isParalysis());
    character1.normal();
    assert(character1.isNormal());
    character1.burned(1, 1);
    character1.poisoned(1, 1);
    assert(character1.isBurned() && character1.isPoisoned());
    character1.normal();
    assert(character1.isNormal());
    character1.paralysis();
    character1.burned(1, 1);
    assert(character1.isParalysis() && character1.isBurned());
    character1.normal();
    assert(character1.isNormal());
    character1.paralysis();
    character1.poisoned(1, 1);
    assert(character1.isParalysis() && character1.isPoisoned());
    character1.normal();
    assert(character1.isNormal());
    character1.paralysis();
    character1.burned(1, 1);
    character1.poisoned(1, 1);
    assert(character1.isParalysis() && character1.isBurned() && character1.isPoisoned());
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
    assert(!character1.isParalysis() || !character1.isBurned());
    assert(!character1.isParalysis() || !character1.isPoisoned());
    assert(!character1.isBurned() || !character1.isPoisoned());
    assert(character1.isParalysis() || character1.isBurned() || character1.isPoisoned());
  }

  @Test
  void getBurnedDamage() {
    assert(0 == character1.getBurnedDamage());
    character1.burned(10, 5);
    assert(10 == character1.getBurnedDamage());
    character1.poisoned(8, 4);
    assert(10 == character1.getBurnedDamage());
    character1.paralysis();
    assert(10 == character1.getBurnedDamage());
    character1.unpoisoned();
    assert(10 == character1.getBurnedDamage());
  }

  @Test
  void getBurnedTime() {
    assert(0 == character1.getBurnedTime());
    character1.burned(10, 5);
    assert(5 == character1.getBurnedTime());
    character1.poisoned(8, 4);
    assert(5 == character1.getBurnedTime());
    character1.paralysis();
    assert(5 == character1.getBurnedTime());
    character1.unpoisoned();
    assert(5 == character1.getBurnedTime());
  }

  @Test
  void getPoisonedDamage() {
    assert(0 == character1.getPoisonedDamage());
    character1.poisoned(10, 5);
    assert(10 == character1.getPoisonedDamage());
    character1.burned(8, 4);
    assert(10 == character1.getPoisonedDamage());
    character1.paralysis();
    assert(10 == character1.getPoisonedDamage());
    character1.unburned();
    assert(10 == character1.getPoisonedDamage());
  }

  @Test
  void getPoisonedTime() {
    assert(0 == character1.getPoisonedTime());
    character1.poisoned(10, 5);
    assert(5 == character1.getPoisonedTime());
    character1.burned(8, 4);
    assert(5 == character1.getPoisonedTime());
    character1.paralysis();
    assert(5 == character1.getPoisonedTime());
    character1.unburned();
    assert(5 == character1.getPoisonedTime());
  }
}