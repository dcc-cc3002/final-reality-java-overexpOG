package cl.uchile.dcc.finalreality.model.spells.factory.white;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.spells.spell.white.Palsy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class PalsyFactoryTest {

  private PalsyFactory factory;
  private Mage character1;

  @BeforeEach
  void setUp() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    character1 = new WhiteMage("Shihoru", 10, 6, 10, queue);
    factory = new PalsyFactory();
  }

  @Test
  void create() {
    factory.setMana(25);
    character1.setSpellFactory(factory);
    assertEquals(character1.spelling().getClass(), Palsy.class);
  }
}