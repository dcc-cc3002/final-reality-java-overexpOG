package cl.uchile.dcc.finalreality.model.spells.factory.black;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;
import cl.uchile.dcc.finalreality.model.spells.spell.black.Fire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.jupiter.api.Assertions.*;

class FireFactoryTest {

  private FireFactory factory;
  private Mage character1;

  @BeforeEach
  void setUp() {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    character1 = new BlackMage("Shihoru", 10, 6, 10, queue);
    factory = new FireFactory();
  }

  @Test
  void create() {
    factory.setMana(25);
    factory.setOdds(20);
    character1.setSpellFactory(factory);
    assertEquals(character1.spelling().getClass(), Fire.class);
  }
}