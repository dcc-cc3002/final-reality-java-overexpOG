package cl.uchile.dcc.finalreality.model.state;

public class Paralysis_Burned extends AbstractState {

  private final int BurnedDamage;
  private final int BurnedTime;

  public Paralysis_Burned (int burnedDamage, int burnedTime) {
    this.BurnedDamage = burnedDamage;
    this.BurnedTime = burnedTime;
  }

  @Override
  public void paralysis() {
    this.changeState(new Paralysis_Burned(BurnedDamage, BurnedTime));
  }

  @Override
  public void unparalysis() {
    this.changeState(new Burned(BurnedDamage, BurnedTime));
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new Paralysis_Burned(burnedDamage, burnedTime));
  }

  @Override
  public void unburned() {
    this.changeState(new Paralysis());
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new Paralysis_Burned_Poisoned(BurnedDamage, BurnedTime, poisonedDamage, poisonedTime));
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
