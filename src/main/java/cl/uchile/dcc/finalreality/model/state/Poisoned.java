package cl.uchile.dcc.finalreality.model.state;

public class Poisoned extends AbstractState {

  private final int PoisonedDamage;
  private final int PoisonedTime;

  public Poisoned (int poisonedDamage, int poisonedTime) {
    this.PoisonedDamage = poisonedDamage;
    this.PoisonedTime = poisonedTime;
  }

  @Override
  public void paralysis() {
    this.changeState(new Paralysis_Poisoned(PoisonedDamage, PoisonedTime));
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new Burned_Poisoned(burnedDamage, burnedTime, PoisonedDamage, PoisonedTime));
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new Poisoned(poisonedDamage, poisonedTime));
  }

  @Override
  public void unpoisoned() {
    this.changeState(new Normal());
  }

  @Override
  public boolean isPoisoned () {
    return true;
  }
}
