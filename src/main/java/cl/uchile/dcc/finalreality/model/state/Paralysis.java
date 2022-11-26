package cl.uchile.dcc.finalreality.model.state;

public class Paralysis extends AbstractState {

  @Override
  public void paralysis() {this.changeState(new Paralysis());}

  @Override
  public void unparalysis() {this.changeState(new Normal());}

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new Paralysis_Burned(burnedDamage, burnedTime));
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new Paralysis_Poisoned(poisonedDamage, poisonedTime));
  }

  @Override
  public boolean isParalysis() {
    return true;
  }
}
