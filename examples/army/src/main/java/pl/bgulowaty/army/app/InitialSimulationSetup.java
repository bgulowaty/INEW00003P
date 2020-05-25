package pl.bgulowaty.army.app;

import pl.bgulowaty.army.simulation.terrain.TerrainTile;
import pl.bgulowaty.army.simulation.unit.Unit;

import java.util.Map;
import java.util.Set;

public class InitialSimulationSetup {

  private final Map<TerrainTile, Set<Unit>> initialPositions;

  public InitialSimulationSetup(
      Map<TerrainTile, Set<Unit>> initialPositions) {this.initialPositions = initialPositions;}

  public Map<TerrainTile, Set<Unit>> getInitialPositions() {
    return initialPositions;
  }
}
