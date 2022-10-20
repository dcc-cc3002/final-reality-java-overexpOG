package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BowTest {
  private Weapon bow;
  private Weapon bowX;
  private Weapon bowY;
  private Weapon knife;
  @BeforeEach
  void setUp() {
    bow = new Bow("wooden bow", 2, 2);
    bowX = new Bow("wooden bow", 2, 2);
    bowY = new Bow("fire bow", 2, 2);
    knife = new Knife("wooden knife", 1, 1);
  }

  @Test
  void getType() {
    assertEquals("BOW",bow.getType());
  }

  @Test
  void testEquals() {
    assert(bow.equals(bowX));
    assert(bow.equals(bow));
    assertFalse(bow.equals(bowY));
    assertFalse(bow.equals(knife));
  }

  @Test
  void testToString() {
    assertEquals("Weapon{name='wooden bow', damage=2, weight=2, type=BOW}", bow.toString());
  }
}