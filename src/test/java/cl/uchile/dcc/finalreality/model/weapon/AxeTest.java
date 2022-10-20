package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AxeTest {
  private Weapon axe;
  private Weapon axeX;
  private Weapon axeY;
  private Weapon knife;

  @BeforeEach
  void setUp() {
    axe = new Axe("wooden axe", 5, 5);
    axeX = new Axe("wooden axe", 5, 5);
    axeY = new Axe("wooden axe", 6, 5);
    knife = new Knife("wooden knife", 1, 1);
  }

  @Test
  void getType() {
    assertEquals("AXE",axe.getType());
  }

  @Test
  void testEquals() {
    assert(axe.equals(axeX));
    assert(axe.equals(axe));
    assertFalse(axe.equals(axeY));
    assertFalse(axe.equals(knife));
  }

  @Test
  void testToString() {
    assertEquals("Weapon{name='wooden axe', damage=5, weight=5, type=AXE}", axe.toString());
  }
}