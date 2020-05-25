package pl.bgulowaty.army.simulation.move;

import pl.bgulowaty.army.simulation.terrain.Direction;
import pl.bgulowaty.army.simulation.terrain.TerrainTile;
import pl.bgulowaty.army.simulation.unit.Unit;
import pl.bgulowaty.army.simulation.unit.UnitStrengthModifier;

import java.util.Random;

public class RandomNeighborNewPositionDecider implements NextUnitPositionDecider {

  private final Random randomSeed = new Random();

  @Override
  public Move decide(TerrainTile currentPosition, Unit unit) {
    Direction direction = randomDirection();

    return new Move(
        new UnitStrengthModifier.ZeroModifier(),
        currentPosition.findNeighbor(direction)
            .orElse(currentPosition) // they're lost
    );
  }

  public Direction randomDirection() {
    Direction[] valuesToChooseFrom = Direction.values();
    int randomIndex = randomSeed.nextInt(valuesToChooseFrom.length);
    return valuesToChooseFrom[randomIndex];
  }


}
