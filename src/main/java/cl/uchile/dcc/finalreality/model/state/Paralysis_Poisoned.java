package cl.uchile.dcc.finalreality.model.state;

public class Paralysis_Poisoned extends State {

  @Override
  public void paralysis() {}

  @Override
  public void burned() {
    this.changeState(new Paralysis_Burned_Poisoned());
  }

  @Override
  public void poisoned() {}

  @Override
  public boolean isParalysis_Poisoned () {
    return true;
  }
}
