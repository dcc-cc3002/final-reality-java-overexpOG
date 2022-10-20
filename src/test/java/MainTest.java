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
        private Weapon knifeX;
        private Weapon knifeY;
        private Weapon bow;
        private Weapon bowX;
        private Weapon bowY;
        private Weapon sword;
        private Weapon swordX;
        private Weapon swordY;
        private Weapon axe;
        private Weapon axeX;
        private Weapon axeY;
        private Weapon wizardStaff;
        private Weapon wizardStaffX;
        private Weapon healerStaff;
        private PlayerCharacter character1;
        private PlayerCharacter character1X;
        private PlayerCharacter character1Y;
        private PlayerCharacter character2;
        private PlayerCharacter character2X;
        private PlayerCharacter character2Y;
        private Mage character3;
        private PlayerCharacter character3X;
        private PlayerCharacter character3Y;
        private PlayerCharacter character4;
        private PlayerCharacter character4X;
        private PlayerCharacter character4Y;
        private PlayerCharacter character5;
        private PlayerCharacter character5X;
        private PlayerCharacter character5Y;
        private NonPlayableCharacter character6;
        private NonPlayableCharacter character6X;
        private NonPlayableCharacter character6Y;

        @Before
        public void setuUp() throws InvalidStatValueException {
            knife = new Knife("wooden knife", 1, 1);
            knifeX = new Knife("wooden knife", 1, 1);
            knifeY = new Knife("metal knife", 4, 5);
            bow = new Bow("wooden bow", 2, 2);
            bowX = new Bow("wooden bow", 2, 2);
            bowY = new Bow("fire bow", 2, 2);
            sword = new Sword("wooden sword", 4, 4);
            swordX = new Sword("wooden sword", 4, 4);
            swordY = new Sword("stone sword", 4, 4);
            axe = new Axe("wooden axe", 5, 5);
            axeX = new Axe("wooden axe", 5, 5);
            axeY = new Axe("wooden axe", 6, 5);
            wizardStaff = new Staff("wizard staff", 6, 6);
            wizardStaffX = new Staff("wizard staff", 6, 6);
            healerStaff = new Staff("healer staff", 3, 3);
            queue = new LinkedBlockingQueue<>();
            character1 = new Thief("Haruhiro", 10, 10, queue);
            character1X = new Thief("Haruhiro", 10, 10, queue);
            character1Y = new Thief("Haruhiro", 8, 10, queue);
            character2 = new Engineer("Yume", 10, 8, queue);
            character2X = new Engineer("Yume", 10, 8, queue);
            character2Y = new Engineer("Kiichi", 10, 8, queue);
            character3 = new WhiteMage("Merry", 15, 5, 10, queue);
            character3X = new WhiteMage("Merry", 15, 5, 10, queue);
            character3Y = new WhiteMage("Merry", 15, 5, 8, queue);
            character4 = new Knight("Ranta", 10, 20, queue);
            character4X = new Knight("Ranta", 10, 20, queue);
            character4Y = new Knight("Ranta", 10, 15, queue);
            character5 = new BlackMage("Shihoru", 10, 6, 10, queue);
            character5X = new BlackMage("Shihoru", 10, 6, 10, queue);
            character5Y= new BlackMage("Shihoru", 10, 2, 10, queue);
            character6 = new Enemy("Jumbo", 7, 50, 20, queue);
            character6X = new Enemy("Jumbo", 7, 50, 20, queue);
            character6Y = new Enemy("Arnold", 8, 70, 10, queue);
        }
        @Test
        public void testAbstractWeaponMethod() {
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
            assertEquals("Weapon{name=wooden knife, damage=1, weight=1, type=KNIFE}", knife.toString());
            assertEquals("Weapon{name=wooden axe, damage=5, weight=5, type=AXE}", axe.toString());
            assertEquals("Weapon{name=wooden bow, damage=2, weight=2, type=BOW}", bow.toString());
            assertEquals("Weapon{name=wizard staff, damage=6, weight=6, type=STAFF}", wizardStaff.toString());
            assertEquals("Weapon{name=wooden sword, damage=4, weight=4, type=SWORD}", sword.toString());
        }
        @Test
        public void testEqualsOfWeapon() {
            assert(knife.equals(knifeX));
            assertFalse(knife.equals(knifeY));
            assert(bow.equals(bowX));
            assertFalse(bow.equals(bowY));
            assert(sword.equals(swordX));
            assertFalse(sword.equals(swordY));
            assert(axe.equals(axeX));
            assertFalse(axe.equals(axeY));
            assert(wizardStaff.equals(wizardStaffX));
            assertFalse(wizardStaff.equals(healerStaff));
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
        public void testAbstractPlayableCharacterMethod() {
            character1.equip(knife);
            assertEquals(knife, character1.getEquippedWeapon());
        }
        @Test
        public void testAbstractMageMethod() throws InvalidStatValueException {
            assertEquals(10, character3.getMaxMp());
            assertEquals(10, character3.getCurrentMp());
            character3.setCurrentMp(8);
            assertEquals(8, character3.getCurrentMp());
        }
        @Test
        public void testEqualsOfPlayerCharacter() {
            assert(character1.equals(character1X));
            assertFalse(character1.equals(character1Y));
            assert(character2.equals(character2X));
            assertFalse(character2.equals(character2Y));
            assert(character3.equals(character3X));
            assertFalse(character3.equals(character3Y));
            assert(character4.equals(character4X));
            assertFalse(character4.equals(character4Y));
            assert(character5.equals(character5X));
            assertFalse(character5.equals(character5Y));
        }
        @Test
        public void testToStringOfPlayerCharacter() {
            assertEquals("Thief{name=Haruhiro, maxHp=10, currentHp=10, defense=10}", character1.toString());
            assertEquals("Engineer{name=Yume, maxHp=10, currentHp=10, defense=8}", character2.toString());
            assertEquals("WhiteMage{name=Merry, maxHp=15, currentHp=15, defense=5, maxMp=10, currentMp=10}", character3.toString());
            assertEquals("Knight{name=Ranta, maxHp=10, currentHp=10, defense=20}", character4.toString());
            assertEquals("BlackMage{name=Shihoru, maxHp=10, currentHp=10, defense=6, maxMp=10, currentMp=10}", character5.toString());
        }
        @Test
        public void testEqualsOfNonPlayableCharacter() {
            assert(character6.equals(character6X));
            assertFalse(character6.equals(character6Y));
        }
        @Test
        public void testToStringOfNonPlayableCharacter() {
            assertEquals("Enemy{name=Jumbo, weight=7, maxHp=50, defense=20}", character6.toString());
        }
        @Test
        public void testActionTurn() {
            character6.waitTurn();
            character1.equip(knife);
            character1.waitTurn();
            assertEquals(character1, queue.poll());
            assertEquals(character6, queue.poll());
        }
    }