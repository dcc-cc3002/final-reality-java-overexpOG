package cl.uchile.dcc.finalreality.model.state;

/**
 * A {@link State} that deals burning damage over a time interval and paralyzes for one turn.
 *
 * @author Ignacio Alveal
 */
public class ParalysisBurned extends AbstractState {

  private final int burnedDamage;
  private final int burnedTime;

  /**
   * Creates a new ParalysisBurned state.
   *
   * @param burnedDamage
   *     the damage caused by the state
   * @param burnedTime
   *     the state time interval
   */
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

  @Override
  public int getBurnedDamage() {
    return burnedDamage;
  }

  @Override
  public int getBurnedTime() {
    return burnedTime;
  }
}
