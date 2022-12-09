package cl.uchile.dcc.finalreality;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.gameimplementation.GameDriver;
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
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * main class, to run the game.
 *
 * @author Ignacio Alveal
 */
public class Main {
  /**
   * Run the game.
   */
  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<GameCharacter> queue = new LinkedBlockingQueue<>();
    PlayerCharacter character1 = new Thief("Haruhiro", 80, 12, queue);
    PlayerCharacter character2 = new BlackMage("Shihoru", 60, 12, 75, queue);
    PlayerCharacter character3 = new WhiteMage("Merry", 50, 12, 80, queue);
    final NonPlayableCharacter character4 = new Enemy("Jumbo", 90, 50, 5, queue, 20);
    final NonPlayableCharacter character5 = new Enemy("Arnold", 110, 50, 5, queue, 20);
    final Weapon dsword = new Sword("diamond sword", 100, 10);
    final Weapon wsword = new Sword("wooden sword", 1, 30);
    final Weapon knife = new Knife("wooden knife", 2, 20);
    final Weapon dstaff = new Staff("diamond staff", 1, 10, 100);
    final Weapon wstaff = new Staff("wooden staff", 1, 50, 1);
    final Weapon healerStaff = new Staff("healer staff", 1, 70, 1);
    character1.equip(wsword);
    character2.equip(wstaff);
    character3.equip(healerStaff);
    SpellBlackFactory firefactory = new FireFactory();
    firefactory.setMana(15);
    firefactory.setOdds(20);
    SpellBlackFactory thunderfactory = new ThunderFactory();
    thunderfactory.setMana(15);
    thunderfactory.setOdds(30);
    SpellWhiteFactory curefactory = new CureFactory();
    curefactory.setMana(15);
    SpellWhiteFactory palsyfactory = new PalsyFactory();
    palsyfactory.setMana(25);
    SpellWhiteFactory poisonfactory = new PoisonFactory();
    poisonfactory.setMana(40);
    ArrayList<PlayerCharacter> characterOfPlayer = new ArrayList<>();
    characterOfPlayer.add(character1);
    characterOfPlayer.add(character2);
    characterOfPlayer.add(character3);
    ArrayList<NonPlayableCharacter> characterOfComputer = new ArrayList<>();
    characterOfComputer.add(character4);
    characterOfComputer.add(character5);
    ArrayList<Weapon> weaponOfPlayer = new ArrayList<>();
    weaponOfPlayer.add(dsword);
    weaponOfPlayer.add(knife);
    weaponOfPlayer.add(dstaff);
    ArrayList<SpellBlackFactory> blackMagic = new ArrayList<>();
    blackMagic.add(firefactory);
    blackMagic.add(thunderfactory);
    ArrayList<SpellWhiteFactory> whiteMagic = new ArrayList<>();
    whiteMagic.add(curefactory);
    whiteMagic.add(palsyfactory);
    whiteMagic.add(poisonfactory);
    FinalReality game = new FinalReality(characterOfPlayer, characterOfComputer, weaponOfPlayer,
            blackMagic, whiteMagic, queue);
    GameDriver.playGame(game);
  }
}
