package cl.uchile.dcc.finalreality.model.weapon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {
  private Weapon wizardStaff;
  private Weapon wizardStaffX;
  private Weapon healerStaff;
  private Weapon knife;

  @BeforeEach
  void setUp() {
    wizardStaff = new Staff("wizard staff", 6, 6);
    wizardStaffX = new Staff("wizard staff", 6, 6);
    healerStaff = new Staff("healer staff", 3, 3);
    knife = new Knife("wooden knife", 1, 1);
  }

  @Test
  void getType() {
    assertEquals("STAFF", wizardStaff.getType());
  }

  @Test
  void testEquals() {
    assert(wizardStaff.equals(wizardStaffX));
    assert(wizardStaff.equals(wizardStaff));
    assertFalse(wizardStaff.equals(healerStaff));
    assertFalse(wizardStaff.equals(knife));
  }

  @Test
  void testToString() {
    assertEquals("Weapon{name='wizard staff', damage=6, weight=6, type=STAFF}", wizardStaff.toString());
  }
}