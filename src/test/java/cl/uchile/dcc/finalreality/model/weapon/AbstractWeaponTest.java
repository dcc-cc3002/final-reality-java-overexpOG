package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractWeaponTest {
  private Weapon knife;

  @BeforeEach
  void setUp() {
    knife = new Knife("wooden knife", 1, 1);
  }

  @Test
  void getName() {
    assertEquals("wooden knife", knife.getName());
  }

  @Test
  void getDamage() {
    assertEquals(1, knife.getDamage());
  }

  @Test
  void getWeight() {
    assertEquals(1, knife.getWeight());
  }
}