package cl.uchile.dcc.finalreality.model.state;

/**
 * A {@link State} that deals poison damage over a time interval.
 *
 * @author Ignacio Alveal
 */
public class Poisoned extends AbstractState {

  private final int poisonedDamage;
  private final int poisonedTime;

  /**
   * Creates a new Poisoned state.
   *
   * @param poisonedDamage
   *     the damage caused by the poisoned state
   * @param poisonedTime
   *     the time interval of the poisoned state
   */
  public Poisoned(int poisonedDamage, int poisonedTime) {
    this.poisonedDamage = poisonedDamage;
    this.poisonedTime = poisonedTime;
  }

  @Override
  public void paralysis() {
    this.changeState(new ParalysisPoisoned(poisonedDamage, poisonedTime));
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new BurnedPoisoned(burnedDamage, burnedTime, poisonedDamage, poisonedTime));
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
