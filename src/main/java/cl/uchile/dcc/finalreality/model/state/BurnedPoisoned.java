package cl.uchile.dcc.finalreality.model.state;

public class BurnedPoisoned extends AbstractState {

  private final int burnedDamage;
  private final int burnedTime;
  private final int poisonedDamage;
  private final int poisonedTime;

  public BurnedPoisoned(int burnedDamage, int burnedTime, int poisonedDamage, int poisonedTime) {
    this.burnedDamage = burnedDamage;
    this.burnedTime = burnedTime;
    this.poisonedDamage = poisonedDamage;
    this.poisonedTime = poisonedTime;
  }

  @Override
  public void paralysis() {
    this.changeState(new ParalysisBurnedPoisoned(burnedDamage,
            burnedTime, poisonedDamage, poisonedTime));
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new BurnedPoisoned(burnedDamage, burnedTime, poisonedDamage, poisonedTime));
  }

  @Override
  public void unburned() {
    this.changeState(new Poisoned(poisonedDamage, poisonedTime));
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new BurnedPoisoned(burnedDamage, burnedTime, poisonedDamage, poisonedTime));
  }

  @Override
  public void unpoisoned() {
    this.changeState(new Burned(burnedDamage, burnedTime));
  }

  @Override
  public boolean isBurned() {
    return true;
  }

  @Override
  public boolean isPoisoned() {
    return true;
  }
}
