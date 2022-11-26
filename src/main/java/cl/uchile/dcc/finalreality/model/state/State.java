package cl.uchile.dcc.finalreality.model.state;

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;

public interface State {

  /**
   * Set this.abstractcharacter with abstractcharacter.
   */
  void setAbstractCharacter(AbstractCharacter abstractcharacter);

  /**
   * The state returns to normal.
   */
  void normal();

  /**
   * Paralyzed effect is added to the state.
   */
  void paralysis();

  /**
   * Burned effect is added to the state.
   */
  void burned(int burnedDamage, int burnedTime);

  /**
   * Poisoned effect is added to the state.
   */
  void poisoned(int poisonedDamage, int poisonedTime);

  /**
   * Paralyzed effect is removed to the state.
   */
  void unparalysis();

  /**
   * Burned effect is removed to the state.
   */
  void unburned();

  /**
   * Poisoned effect is removed to the state.
   */
  void unpoisoned();

  /**
   * Returns true if the state is normal, false otherwise.
   */
  boolean isNormal ();

  /**
   * Returns true if the state is paralysis, false otherwise.
   */
  boolean isParalysis ();

  /**
   * Returns true if the state is burned, false otherwise.
   */
  boolean isBurned ();

  /**
   * Returns true if the state is poisoned, false otherwise.
   */
  boolean isPoisoned ();

  /**
   * Returns the damage for burned.
   */
  int getBurnedDamage();

  /**
   * Returns the damage for poisoned.
   */
  int getPoisonedDamage();

  /**
   * Returns the burned duration.
   */
  int getBurnedTime();

  /**
   * Returns the poisoned duration.
   */
  int getPoisonedTime();
}
