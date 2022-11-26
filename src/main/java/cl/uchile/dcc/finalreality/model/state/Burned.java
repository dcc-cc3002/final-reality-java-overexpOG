package cl.uchile.dcc.finalreality.model.state;

public class Burned extends AbstractState {

  private final int BurnedDamage;
  private final int BurnedTime;

  public Burned (int burnedDamage, int burnedTime) {
    this.BurnedDamage = burnedDamage;
    this.BurnedTime = burnedTime;
  }

  @Override
  public void paralysis() {
    this.changeState(new Paralysis_Burned(BurnedDamage, BurnedTime));
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {this.changeState(new Burned(burnedDamage, burnedTime));}

  @Override
  public void unburned() {this.changeState(new Normal());}

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new Burned_Poisoned(BurnedDamage, BurnedTime, poisonedDamage, poisonedTime));
  }

  @Override
  public boolean isBurned() {
    return true;
  }
}
