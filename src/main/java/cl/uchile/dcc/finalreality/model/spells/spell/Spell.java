package cl.uchile.dcc.finalreality.model.spells.spell;

import cl.uchile.dcc.finalreality.gameimplementation.FinalReality;
import cl.uchile.dcc.finalreality.model.character.nonplayable.NonPlayableCharacter;
import cl.uchile.dcc.finalreality.model.character.player.mage.Mage;

public interface Spell {
  void magic(FinalReality game, Mage actualCharacter, NonPlayableCharacter enemyCharacter);
}
