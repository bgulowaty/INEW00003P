package pl.bgulowaty.army.simulation.terrain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class PossiblePassages {

  private final Map<Direction, TerrainTile> neighbors;

  public PossiblePassages(Map<Direction, TerrainTile> neighbors) {
    this.neighbors = neighbors;
  }


  public static PossiblePassages noPassages() {
    return new PossiblePassages(Collections.emptyMap());
  }

  public Optional<TerrainTile> findByDirection(Direction direction) {
    return Optional.ofNullable(neighbors.get(direction));
  }

}
