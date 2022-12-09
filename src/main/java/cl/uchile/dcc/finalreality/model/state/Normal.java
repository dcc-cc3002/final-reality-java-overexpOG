package cl.uchile.dcc.finalreality.model.state;

/**
 * A {@link State} that does nothing (normal).
 *
 * @author Ignacio Alveal
 */
public class Normal extends AbstractState {

  @Override
  public void paralysis() {
    this.changeState(new Paralysis());
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new Burned(burnedDamage, burnedTime));
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new Poisoned(poisonedDamage, poisonedTime));
  }

  @Override
  public boolean isNormal() {
    return true;
  }
}
