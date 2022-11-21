package cl.uchile.dcc.finalreality.model.state;

public class Normal extends State {

  @Override
  public void paralysis() {
    this.changeState(new Paralysis());
  }

  @Override
  public void burned() {
    this.changeState(new Burned());
  }

  @Override
  public void poisoned() {
    this.changeState(new Poisoned());
  }

  @Override
  public boolean isNormal() {
    return true;
  }
}
