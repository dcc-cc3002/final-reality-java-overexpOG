package cl.uchile.dcc.finalreality.model.state;

public class Poisoned extends State {

  @Override
  public void paralysis() {
    this.changeState(new Paralysis_Poisoned());
  }

  @Override
  public void burned() {
    this.changeState(new Burned_Poisoned());
  }

  @Override
  public void poisoned() {}

  @Override
  public boolean isPoisoned () {
    return true;
  }
}
