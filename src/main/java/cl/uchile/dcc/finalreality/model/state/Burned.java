package cl.uchile.dcc.finalreality.model.state;

public class Burned extends AbstractState {

  private final int burnedDamage;
  private final int burnedTime;

  public Burned(int burnedDamage, int burnedTime) {
    this.burnedDamage = burnedDamage;
    this.burnedTime = burnedTime;
  }

  @Override
  public void paralysis() {
    this.changeState(new ParalysisBurned(burnedDamage, burnedTime));
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new Burned(burnedDamage, burnedTime));
  }

  @Override
  public void unburned() {
    this.changeState(new Normal());
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new BurnedPoisoned(burnedDamage, burnedTime, poisonedDamage, poisonedTime));
  }

  @Override
  public boolean isBurned() {
    return true;
  }

  @Override
  public int getBurnedDamage() {
    return burnedDamage;
  }

  @Override
  public int getBurnedTime() {
    return burnedTime;
  }
}
