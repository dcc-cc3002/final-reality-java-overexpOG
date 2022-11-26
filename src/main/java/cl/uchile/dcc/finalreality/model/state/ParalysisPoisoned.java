package cl.uchile.dcc.finalreality.model.state;

public class ParalysisPoisoned extends AbstractState {

  private final int poisonedDamage;
  private final int poisonedTime;

  public ParalysisPoisoned(int poisonedDamage, int poisonedTime) {
    this.poisonedDamage = poisonedDamage;
    this.poisonedTime = poisonedTime;
  }

  @Override
  public void paralysis() {
    this.changeState(new ParalysisPoisoned(poisonedDamage, poisonedTime));
  }

  @Override
  public void unparalysis() {
    this.changeState(new Poisoned(poisonedDamage, poisonedTime));
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {

    this.changeState(new ParalysisBurnedPoisoned(burnedDamage, burnedTime,
            poisonedDamage, poisonedTime))
    ;
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new ParalysisPoisoned(poisonedDamage, poisonedTime));
  }

  @Override
  public void unpoisoned() {
    this.changeState(new Paralysis());
  }

  @Override
  public boolean isParalysis() {
    return true;
  }

  @Override
  public boolean isPoisoned() {
    return true;
  }

  @Override
  public int getPoisonedDamage() {
    return poisonedDamage;
  }

  @Override
  public int getPoisonedTime() {
    return poisonedTime;
  }
}
