package cl.uchile.dcc.finalreality.model.state;

/**
 * A {@link State} that paralyzes for one turn.
 *
 * @author Ignacio Alveal
 */
public class Paralysis extends AbstractState {

  @Override
  public void paralysis() {
    this.changeState(new Paralysis());
  }

  @Override
  public void unparalysis() {
    this.changeState(new Normal());
  }

  @Override
  public void burned(int burnedDamage, int burnedTime) {
    this.changeState(new ParalysisBurned(burnedDamage, burnedTime));
  }

  @Override
  public void poisoned(int poisonedDamage, int poisonedTime) {
    this.changeState(new ParalysisPoisoned(poisonedDamage, poisonedTime));
  }

  @Override
  public boolean isParalysis() {
    return true;
  }
}
