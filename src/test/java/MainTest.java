import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.nonplayable.*;
import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.player.*;
import cl.uchile.dcc.finalreality.model.weapon.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

    /**
     * this is the Test.
     *
     * @author Ignacio Alveal
     */
    public class MainTest {
        private BlockingQueue<GameCharacter> queue;
        private Weapon knife;
        private Weapon bow;
        private Weapon healerStaff;
        private Weapon sword;
        private Weapon axe;
        private Weapon wizardStaff;
        private GameCharacter character1;
        private GameCharacter character2;
        private Mage character3;
        private GameCharacter character4;
        private GameCharacter character5;
        private GameCharacter character6;
        private GameCharacter character7;

        @Before
        public void setuUp() throws InvalidStatValueException {
            queue = new LinkedBlockingQueue<>();
            knife = new Knife("wooden knife", 1, 1);
            character1 = new Thief("Haruhiro", 10, 10, queue);
            bow = new Bow("wooden bow", 2, 2);
            character2 = new Engineer("Yume", 10, 8, queue);
            healerStaff = new Staff("healer staff", 3, 3);
            character3 = new WhiteMage("Merry", 15, 5, 10, queue);
            sword = new Sword("wooden sword", 4, 4);
            character4 = new Knight("Ranta", 10, 20, queue);
            axe = new Axe("wooden axe", 5, 5);
            character5 = new Engineer("Kiichi", 5, 5, queue);
            wizardStaff = new Staff("wizard staff", 6, 6)   ;
            character6 = new BlackMage("Shihoru", 10, 6, 10, queue);
            character7 = new Enemy("enemy", 7, 10, 10, queue);
        }

        @Test
        public void testAbstractCharacterMethod() throws InvalidStatValueException {
            assertEquals("Haruhiro", character1.getName());
            assertEquals(10, character1.getMaxHp());
            character1.setCurrentHp(8);
            assertEquals(8, character1.getMaxHp());
            assertEquals(10, character1.getDefense());
        }
        @Test
        public void testAbstractMageMethod() throws InvalidStatValueException {
            assertEquals(10, character3.getMaxMp());
            assertEquals(10, character3.getCurrentMp());
            character3.setCurrentMp(8);
            assertEquals(8, character3.getCurrentMp());
        }
        @Test
        public void testAbstractWeaponMerhod() {
            assertEquals("wooden knife", knife.getName());
            assertEquals(1, knife.getDamage());
            assertEquals(1, knife.getWeight());
        }
        @Test
        public void testTypeOfWeapon() {
            assertEquals("KNIFE", knife.getType());
            assertEquals("AXE", axe.getType());
            assertEquals("BOW", bow.getType());
            assertEquals("STAFF", wizardStaff.getType());
            assertEquals("SWORD", sword.getType());
        }
        @Test
        public void testToStringOfWeapon() {
            assertEquals("Weapon(name=wooden knife, damage=1, weight=1, type=KNIFE)", knife.getType());
            assertEquals("Weapon(name=wooden axe, damage=5, weight=5, type=AXE)", axe.getType());
            assertEquals("Weapon(name=wooden bow, damage=2, weight=2, type=BOW)", bow.getType());
            assertEquals("Weapon(name=wizard staff, damage=6, weight=6, type=STAFF)", wizardStaff.getType());
            assertEquals("Weapon(name=wooden sword, damage=4, weight=4, type=SWORD)", sword.getType());
        }
        @Test
        public void testEqualsOfWeapon() {

        }
    }