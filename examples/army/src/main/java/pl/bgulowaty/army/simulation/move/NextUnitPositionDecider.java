package pl.bgulowaty.army.simulation.move;

import pl.bgulowaty.army.simulation.terrain.TerrainTile;
import pl.bgulowaty.army.simulation.unit.Unit;

public interface NextUnitPositionDecider {

  Move decide(TerrainTile currentPosition, Unit unit);
}
