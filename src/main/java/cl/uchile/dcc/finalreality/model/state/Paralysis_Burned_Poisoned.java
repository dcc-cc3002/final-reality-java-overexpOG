package cl.uchile.dcc.finalreality.model.state;

public class Paralysis_Burned_Poisoned extends State {

  @Override
  public void paralysis() {}

  @Override
  public void burned() {}

  @Override
  public void poisoned() {}

  @Override
  public boolean isParalysis_Burned_Poisoned () {
    return true;
  }
}
