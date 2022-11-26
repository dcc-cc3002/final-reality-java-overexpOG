package cl.uchile.dcc.finalreality.model.state;

public class ParalysisBurned extends AbstractState {

  private final int burnedDamage;
  private final int burnedTime;

  public ParalysisBurned(int burnedDamage, int burnedTime) {
    this.burnedDamage = burnedDamage;
    this.burnedTime = burnedTime;
  }

  @Override
  public void paralysis() {
    this.changeState(new ParalysisBurned(burnedDamage, burnedTime));
  }

  @Override
  public void unparalysis() {
    this.changeState(new Burned(burnedDamage, burnedTime));
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new ParalysisBurned(burnedDamage, burnedTime));
  }

  @Override
  public void unburned() {
    this.changeState(new Paralysis());
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new ParalysisBurnedPoisoned(burnedDamage, burnedTime,
            poisonedDamage, poisonedTime));
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
