package pl.bgulowaty.army.simulation.terrain;

import pl.bgulowaty.army.simulation.fight.FightModifiers;

import java.util.Optional;

public interface TerrainTile extends FightModifiers {

  PossiblePassages getPassages();

  default Optional<TerrainTile> findNeighbor(Direction direction) {
    return getPassages().findByDirection(direction);
  }
}
