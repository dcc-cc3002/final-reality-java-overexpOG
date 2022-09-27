package cl.uchile.dcc.finalreality.model.character;

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException;
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/**
 * an abstract class that allows characters to be added to the turn queue and makes
 * them wait for their turn.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author Ignacio Alveal
 */
public abstract class AbstractAddingQueue extends AbstractCharacter {
  protected final BlockingQueue<GameCharacter> turnsQueue;
  private ScheduledExecutorService scheduledExecutor;

  /**
   * Creates a new character.
   *
   * @param name
   *     the character's name
   * @param maxHp
   *     the character's max hp
   * @param defense
   *     the character's defense
   * @param turnsQueue
   *     the queue with the characters waiting for their turn
   */
  protected AbstractAddingQueue(final @NotNull String name, final int maxHp, final int defense,
                                final @NotNull BlockingQueue<GameCharacter> turnsQueue)
          throws InvalidStatValueException {
    super(name, maxHp, defense);
    this.turnsQueue = turnsQueue;
  }

  /**
   * Adds this character to the turns queue.
   */
  private void addToQueue() {
    try {
      turnsQueue.put(this);
    } catch (Exception e) {
      e.printStackTrace();
    }
    scheduledExecutor.shutdown();
  }

  @Override
  public void waitTurn() {
    scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
    if (this instanceof PlayerCharacter player) {
      scheduledExecutor.schedule(
        /* command = */ this::addToQueue,
        /* delay = */ player.getEquippedWeapon().getWeight() / 10,
        /* unit = */ TimeUnit.SECONDS);
    } else {
      var enemy = (Enemy) this;
      scheduledExecutor.schedule(
        /* command = */ this::addToQueue,
        /* delay = */ enemy.getWeight() / 10,
        /* unit = */ TimeUnit.SECONDS);
    }
  }
}
