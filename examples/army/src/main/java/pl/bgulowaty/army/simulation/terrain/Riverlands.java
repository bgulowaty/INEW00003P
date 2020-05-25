package pl.bgulowaty.army.simulation.terrain;

public class Riverlands extends BaseTerrainTile implements TerrainTile {

  public Riverlands(PossiblePassages possiblePassages) {
    super(possiblePassages);
  }

  @Override
  protected float defenderMultiplier() {
    return 2f;
  }

  @Override
  protected float attackerMultiplier() {
    return 0.75f;
  }
}
