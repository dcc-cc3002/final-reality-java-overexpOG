package cl.uchile.dcc.finalreality.model.state;

public class Burned extends State{

  @Override
  public void paralysis() {
    this.changeState(new Paralysis_Burned());
  }

  @Override
  public void burned() {}

  @Override
  public void poisoned() {
    this.changeState(new Burned_Poisoned());
  }

  @Override
  public boolean isBurned() {
    return true;
  }
}
