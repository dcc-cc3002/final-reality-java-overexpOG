package cl.uchile.dcc.finalreality.model.state;

public class Paralysis extends State{

  @Override
  public void paralysis() {}

  @Override
  public void burned() {
    this.changeState(new Paralysis_Burned());
  }

  @Override
  public void poisoned() {
    this.changeState(new Paralysis_Poisoned());
  }

  @Override
  public boolean isParalysis() {
    return true;
  }
}
