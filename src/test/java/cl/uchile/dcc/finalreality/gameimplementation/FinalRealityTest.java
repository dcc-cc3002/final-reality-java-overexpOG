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
  private Weapon dsword;
  private Weapon wsword;
  private Weapon knife;
  private Weapon dstaff;
  private Weapon wstaff;
  private Weapon healerStaff;
  private SpellBlackFactory firefactory;
  private SpellBlackFactory thunderfactory;
  private SpellWhiteFactory curefactory;
  private SpellWhiteFactory palsyfactory;
  private SpellWhiteFactory poisonfactory;
  private ArrayList<PlayerCharacter> characterOfPlayer = new ArrayList<>();
  private ArrayList<NonPlayableCharacter> characterOfComputer = new ArrayList<>();
  private ArrayList<Weapon> weaponOfPlayer = new ArrayList<>();
  private ArrayList<SpellBlackFactory> blackMagic = new ArrayList<>();
  private ArrayList<SpellWhiteFactory> whiteMagic = new ArrayList<>();

  @BeforeEach
  void setUp() {
    queue = new LinkedBlockingQueue<>();
    character1 = new Thief("Haruhiro", 80, 12, queue);
    character2 = new BlackMage("Shihoru", 60, 12, 50, queue);
    character3 = new WhiteMage("Merry", 50, 12, 50, queue);
    character4 = new Enemy("Jumbo", 9, 50, 5, queue, 20);
    character5 = new Enemy("Arnold", 11, 50, 5, queue, 20);
    dsword = new Sword("diamond sword", 100, 1);
    wsword = new Sword("wooden sword", 1, 3);
    knife = new Knife("wooden knife", 2, 2);
    dstaff = new Staff("diamond staff", 1, 1, 100);
    wstaff = new Staff("wooden staff", 1, 5, 1);
    healerStaff = new Staff("healer staff", 1, 7, 100);
    character1.equip(wsword);
    character2.equip(wstaff);
    character3.equip(healerStaff);
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
    characterOfPlayer.add(character1);
    characterOfPlayer.add(character2);
    characterOfPlayer.add(character3);
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    weaponOfPlayer.add(knife);
    weaponOfPlayer.add(dsword);
    weaponOfPlayer.add(dstaff);
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
  }

  public void checkGame(String moves) throws InterruptedException {
    FinalReality game = new FinalReality(characterOfPlayer, characterOfComputer, weaponOfPlayer, blackMagic, whiteMagic, queue, moves);
    GameDriver.playGame(game);
  }
  @Test
  void notOver() throws InterruptedException {
    checkGame("2\n2\n1\n1\n1\n1\n1\n1\n1\n1\n1\n");
  }

  @Test
  void getWin() {
  }

  @Test
  void update() {
  }

  @Test
  void actionAtack() {
  }

  @Test
  void atack() {
  }

  @Test
  void actionEquip() {
  }

  @Test
  void equip() {
  }

  @Test
  void actionMagic() {
  }

  @Test
  void magic() {
  }

  @Test
  void changeSpellBlackMagic() {
  }

  @Test
  void changeSpellWhiteMagic() {
  }

  @Test
  void getCharacterOfPlayer() {
  }

  @Test
  void getCharacterOfComputer() {
  }
}