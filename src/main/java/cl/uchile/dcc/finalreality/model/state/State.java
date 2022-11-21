package cl.uchile.dcc.finalreality.model.state;

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;

public abstract class State {
  private AbstractCharacter abstractcharacter;

  /**
   * Set this.abstractcharacter with abstractcharacter.
   */
  public void setAbstractCharacter(AbstractCharacter abstractcharacter) {
    this.abstractcharacter = abstractcharacter;
  }

  /**
   * Method that changes the state.
   */
  protected void changeState(State state) {
    abstractcharacter.setState(state);
  }

  /**
   * The state returns to normal.
   */
  public void normal() {
    this.changeState(new Normal());
  }

  /**
   * Paralyzed effect is added to the state.
   */
  public abstract void paralysis();

  /**
   * Burned effect is added to the state.
   */
  public abstract void burned();

  /**
   * Poisoned effect is added to the state.
   */
  public abstract void poisoned();

  /**
   * Returns true if the state is normal, false otherwise.
   */
  public boolean isNormal () {
    return false;
  }

  /**
   * Returns true if the state is paralysis, false otherwise.
   */
  public boolean isParalysis () {
    return false;
  }

  /**
   * Returns true if the state is burned, false otherwise.
   */
  public boolean isBurned () {
    return false;
  }

  /**
   * Returns true if the state is poisoned, false otherwise.
   */
  public boolean isPoisoned () {
    return false;
  }
}
