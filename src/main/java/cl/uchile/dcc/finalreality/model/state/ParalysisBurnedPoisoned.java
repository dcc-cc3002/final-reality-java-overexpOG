package cl.uchile.dcc.finalreality.model.state;

/**
 * A {@link State} that deals burning damage, poison damage over a given period of time for each
 * and paralyzes for one turn.
 *
 * @author Ignacio Alveal
 */
public class ParalysisBurnedPoisoned extends AbstractState {

  private final int burnedDamage;
  private final int burnedTime;
  private final int poisonedDamage;
  private final int poisonedTime;

  /**
   * Creates a new ParalysisBurnedPoisoned state.
   *
   * @param burnedDamage
   *     the damage caused by the burned state
   * @param burnedTime
   *     the time interval of the burned state
   * @param poisonedDamage
   *     the damage caused by the poisoned state
   * @param poisonedTime
   *     the time interval of the poisoned state
   */
  public ParalysisBurnedPoisoned(int burnedDamage, int burnedTime,
                                 int poisonedDamage, int poisonedTime) {
    this.burnedDamage = burnedDamage;
    this.burnedTime = burnedTime;
    this.poisonedDamage = poisonedDamage;
    this.poisonedTime = poisonedTime;
  }

  @Override
  public void paralysis() {
    this.changeState(new ParalysisBurnedPoisoned(burnedDamage, burnedTime,
            poisonedDamage, poisonedTime));
  }

  @Override
  public void unparalysis() {
    this.changeState(new BurnedPoisoned(burnedDamage, burnedTime, poisonedDamage, poisonedTime));
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new ParalysisBurnedPoisoned(burnedDamage, burnedTime,
            poisonedDamage, poisonedTime));
  }

  @Override
  public void unburned() {
    this.changeState(new ParalysisPoisoned(poisonedDamage, poisonedTime));
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new ParalysisBurnedPoisoned(burnedDamage, burnedTime,
            poisonedDamage, poisonedTime));
  }

  @Override
  public void unpoisoned() {
    this.changeState(new ParalysisBurned(burnedDamage, burnedTime));
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

  @Override
  public int getBurnedDamage() {
    return burnedDamage;
  }

  @Override
  public int getBurnedTime() {
    return burnedTime;
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
