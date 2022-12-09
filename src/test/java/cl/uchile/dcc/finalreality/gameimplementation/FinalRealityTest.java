package cl.uchile.dcc.finalreality.gameimplementation;

import cl.uchile.dcc.finalreality.model.character.GameCharacter;
import cl.uchile.dcc.finalreality.model.character.nonplayable.Enemy;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import cl.uchile.dcc.finalreality.model.character.player.common.Thief;
import cl.uchile.dcc.finalreality.model.character.player.mage.BlackMage;
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage;
import cl.uchile.dcc.finalreality.model.spells.factory.black.FireFactory;
import cl.uchile.dcc.finalreality.model.spells.factory.black.SpellBlackFactory;
import cl.uchile.dcc.finalreality.model.spells.factory.black.ThunderFactory;
import cl.uchile.dcc.finalreality.model.spells.factory.white.CureFactory;
import cl.uchile.dcc.finalreality.model.spells.factory.white.PalsyFactory;
import cl.uchile.dcc.finalreality.model.spells.factory.white.PoisonFactory;
import cl.uchile.dcc.finalreality.model.spells.factory.white.SpellWhiteFactory;
import cl.uchile.dcc.finalreality.model.weapon.Knife;
import cl.uchile.dcc.finalreality.model.weapon.Staff;
import cl.uchile.dcc.finalreality.model.weapon.Sword;
import cl.uchile.dcc.finalreality.model.weapon.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class FinalRealityTest {

  private BlockingQueue<GameCharacter> queue;
  private PlayerCharacter character1;
  private PlayerCharacter character2;
  private PlayerCharacter character3;
  private NonPlayableCharacter character4;
  private NonPlayableCharacter character5;
  private NonPlayableCharacter character6;
  private PlayerCharacter character7;
  private Weapon dsword;
  private Weapon wsword;
  private Weapon knife;
  private Weapon dstaff;
  private Weapon wstaff;
  private Weapon healerStaff;
  private Weapon mstaff;
  private SpellBlackFactory firefactory;
  private SpellBlackFactory thunderfactory;
  private SpellWhiteFactory curefactory;
  private SpellWhiteFactory palsyfactory;
  private SpellWhiteFactory poisonfactory;
  private final ArrayList<PlayerCharacter> characterOfPlayer = new ArrayList<>();
  private final ArrayList<NonPlayableCharacter> characterOfComputer = new ArrayList<>();
  private final ArrayList<Weapon> weaponOfPlayer = new ArrayList<>();
  private final ArrayList<SpellBlackFactory> blackMagic = new ArrayList<>();
  private final ArrayList<SpellWhiteFactory> whiteMagic = new ArrayList<>();

  @BeforeEach
  void setUp() {
    queue = new LinkedBlockingQueue<>();
    character1 = new Thief("Haruhiro", 80, 12, queue);
    character2 = new BlackMage("Shihoru", 60, 40, 75, queue);
    character3 = new WhiteMage("Merry", 50, 40, 80, queue);
    character4 = new Enemy("Jumbo", 30, 50, 5, queue, 20);
    character5 = new Enemy("Arnold", 35, 50, 5, queue, 20);
    character6 = new Enemy("boss", 8, 1000, 40, queue, 200);
    character7 = new WhiteMage("one mana", 100, 20, 1, queue);
    dsword = new Sword("diamond sword", 100, 10);
    wsword = new Sword("wooden sword", 1, 16);
    knife = new Knife("wooden knife", 2, 1000);
    dstaff = new Staff("diamond staff", 1, 300, 100);
    wstaff = new Staff("wooden staff", 1, 20, 1);
    healerStaff = new Staff("healer staff", 1, 30, 1);
    mstaff = new Staff("metal staff", 100, 50, 1);
    firefactory = new FireFactory();
    firefactory.setMana(15);
    firefactory.setOdds(20);
    thunderfactory = new ThunderFactory();
    thunderfactory.setMana(15);
    thunderfactory.setOdds(30);
    curefactory = new CureFactory();
    curefactory.setMana(15);
    palsyfactory = new PalsyFactory();
    palsyfactory.setMana(25);
    poisonfactory = new PoisonFactory();
    poisonfactory.setMana(40);
  }

  public void checkGame(String moves) throws InterruptedException {
    FinalReality game = new FinalReality(characterOfPlayer, characterOfComputer, weaponOfPlayer, blackMagic, whiteMagic, queue, moves);
    GameDriver.playGame(game);
  }

  public void checkGame() throws InterruptedException {
    FinalReality game = new FinalReality(characterOfPlayer, characterOfComputer, weaponOfPlayer, blackMagic, whiteMagic, queue);
    GameDriver.playGame(game);
  }

  @Test
  void atack() throws InterruptedException {
    character1.equip(dsword);
    character2.equip(wstaff);
    character3.equip(healerStaff);
    characterOfPlayer.add(character1);
    characterOfPlayer.add(character2);
    characterOfPlayer.add(character3);
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    weaponOfPlayer.add(knife);
    weaponOfPlayer.add(wsword);
    weaponOfPlayer.add(dstaff);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    checkGame("1\n0\n1\n3\na\n1\n1\n1\n1\n2\n1\n2");
  }

  @Test
  void changeEquip() throws InterruptedException {
    character1.equip(dsword);
    character2.equip(wstaff);
    character3.equip(healerStaff);
    characterOfPlayer.add(character1);
    characterOfPlayer.add(character2);
    characterOfPlayer.add(character3);
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    weaponOfPlayer.add(knife);
    weaponOfPlayer.add(wsword);
    weaponOfPlayer.add(dstaff);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    checkGame("2\n4\na\n0\n2\n1\n2\n2\n2\n3\n2\n1\n1\n1\n2\n0\n2\n1\n2\n2\n2\n3\n1\n2\n2\n0\n2\n1\n2\n2\n2\n3\n1\n2\n1\n2");
  }

  @Test
  void changeSpell() throws InterruptedException {
    character1.equip(dsword);
    character2.equip(wstaff);
    character3.equip(healerStaff);
    characterOfPlayer.add(character1);
    characterOfPlayer.add(character2);
    characterOfPlayer.add(character3);
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    weaponOfPlayer.add(knife);
    weaponOfPlayer.add(wsword);
    weaponOfPlayer.add(dstaff);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    checkGame("4\n1\n1\n4\n0\n4\n1\n4\n2\n4\n3\na\n0\n1\n2\n4\n0\n4\n1\n4\n2\n4\n3\n4\n4\na\n0\n1\n2\n1\n2");
  }

  @Test
  void useMagicNotMage() throws InterruptedException {
    character1.equip(dsword);
    characterOfPlayer.add(character1);
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    checkGame("3\n1\n1\n1\n2");
  }

  @Test
  void useMagicNotEnoughMana() throws InterruptedException {
    character7.equip(mstaff);
    characterOfPlayer.add(character7);
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    checkGame("3\n1\n3\n1\n4\n2\n3\n1\n1\n1\n1\n2");
  }

  @Test
  void useMagicBlackMage() throws InterruptedException {
    character2.equip(mstaff);
    characterOfPlayer.add(character2);
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    firefactory.setOdds(100);
    thunderfactory.setOdds(100);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    checkGame("3\n1\n3\n0\n3\n3\na\n1\n4\n2\n3\n1\n1\n1\n1\n2");
  }

  @Test
  void useMagicWhiteMage() throws InterruptedException {
    character3.equip(mstaff);
    characterOfPlayer.add(character3);
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    checkGame("3\n1\n3\n0\n3\n3\na\n1\n4\n2\n3\n1\n4\n3\n3\n1\n1\n1\n1\n2");
  }

  @Test
  void computerWin() throws InterruptedException {
    character1.equip(wsword);
    character2.equip(wstaff);
    character3.equip(wstaff);
    character7.equip(wstaff);
    characterOfPlayer.add(character1);
    characterOfPlayer.add(character2);
    characterOfPlayer.add(character3);
    characterOfPlayer.add(character7);
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    characterOfComputer.add(character6);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    checkGame("1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1");
  }

  @Test
  void testConstructor() throws InterruptedException {
    character1.equip(wsword);
    characterOfPlayer.add(character1);
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    characterOfComputer.add(character6);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    checkGame();
  }

  @Test
  void invalidAction() throws InterruptedException {
    character1.equip(dsword);
    characterOfPlayer.add(character1);
    characterOfComputer.add(character4);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    checkGame("a\n5\n1\n1");
  }
}