package cl.uchile.dcc.finalreality.model.state;

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter;

public abstract class AbstractState implements State {
  private AbstractCharacter abstractcharacter;

  @Override
  public void setAbstractCharacter(AbstractCharacter abstractcharacter) {
    this.abstractcharacter = abstractcharacter;
  }

  /**
   * Method that changes the state.
   */
  protected void changeState(AbstractState state) {
    abstractcharacter.setState(state);
  }

  @Override
  public void normal() {
    this.changeState(new Normal());
  }

  @Override
  public void unparalysis() {}

  @Override
  public void unburned() {}

  @Override
  public void unpoisoned() {}

  @Override
  public boolean isNormal() {
    return false;
  }

  @Override
  public boolean isParalysis() {
    return false;
  }

  @Override
  public boolean isBurned() {
    return false;
  }

  @Override
  public boolean isPoisoned() {
    return false;
  }

  @Override
  public int getBurnedDamage() {
    return 0;
  }

  @Override
  public int getPoisonedDamage() {
    return 0;
  }

  @Override
  public int getBurnedTime() {
    return 0;
  }

  @Override
  public int getPoisonedTime() {
    return 0;
  }
}
