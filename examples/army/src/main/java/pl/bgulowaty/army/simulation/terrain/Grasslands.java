package pl.bgulowaty.army.simulation.terrain;

import pl.bgulowaty.army.simulation.unit.UnitStrengthModifier;

public class Grasslands extends BaseTerrainTile implements TerrainTile {

  public Grasslands(PossiblePassages possiblePassages) {
    super(possiblePassages);
  }

  @Override
  protected float defenderMultiplier() {
    return 1.25f;
  }

  @Override
  protected float attackerMultiplier() {
    return 1f;
  }
}
