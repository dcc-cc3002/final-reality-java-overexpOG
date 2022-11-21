package cl.uchile.dcc.finalreality.model.state;

public class Burned_Poisoned extends State {

  @Override
  public void paralysis() {
    this.changeState(new Paralysis_Burned_Poisoned());
  }

  @Override
  public void burned() {}

  @Override
  public void poisoned() {}

  @Override
  public boolean isBurned() {
    return true;
  }

  @Override
  public boolean isPoisoned() {
    return true;
  }
}
