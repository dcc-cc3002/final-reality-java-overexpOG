package cl.uchile.dcc.finalreality.model.state;

public class Paralysis_Burned_Poisoned extends AbstractState {

  private final int BurnedDamage;
  private final int BurnedTime;
  private final int PoisonedDamage;
  private final int PoisonedTime;

  public Paralysis_Burned_Poisoned (int burnedDamage, int burnedTime, int poisonedDamage, int poisonedTime) {
    this.BurnedDamage = burnedDamage;
    this.BurnedTime = burnedTime;
    this.PoisonedDamage = poisonedDamage;
    this.PoisonedTime = poisonedTime;
  }

  @Override
  public void paralysis() {
    this.changeState(new Paralysis_Burned_Poisoned(BurnedDamage, BurnedTime, PoisonedDamage, PoisonedTime));
  }

  @Override
  public void unparalysis() {
    this.changeState(new Burned_Poisoned(BurnedDamage, BurnedTime, PoisonedDamage, PoisonedTime));
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new Paralysis_Burned_Poisoned(burnedDamage, burnedTime, PoisonedDamage, PoisonedTime));
  }

  @Override
  public void unburned() {
    this.changeState(new Paralysis_Poisoned(PoisonedDamage, PoisonedTime));
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new Paralysis_Burned_Poisoned(BurnedDamage, BurnedTime, poisonedDamage, poisonedTime));
  }

  @Override
  public void unpoisoned() {
    this.changeState(new Paralysis_Burned(BurnedDamage, BurnedTime));
  }

  @Override
  public boolean isParalysis() {
    return true;
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
