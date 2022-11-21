package cl.uchile.dcc.finalreality.model.state;

public class Paralysis_Burned extends State {

  @Override
  public void paralysis() {}

  @Override
  public void burned() {}

  @Override
  public void poisoned() {
    this.changeState(new Paralysis_Burned_Poisoned());
  }

  @Override
  public boolean isParalysis() {
    return true;
  }

  @Override
  public boolean isBurned() {
    return true;
  }
}
