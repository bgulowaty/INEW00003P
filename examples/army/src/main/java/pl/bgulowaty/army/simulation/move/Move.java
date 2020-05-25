package pl.bgulowaty.army.simulation.move;

import pl.bgulowaty.army.simulation.terrain.TerrainTile;
import pl.bgulowaty.army.simulation.unit.UnitStrength;
import pl.bgulowaty.army.simulation.unit.UnitStrengthModifier;

public class Move {
  private final UnitStrengthModifier strengthReduction;
  private final TerrainTile newTile;

  public Move(UnitStrengthModifier strengthReduction, TerrainTile newTile) {
    this.strengthReduction = strengthReduction;
    this.newTile = newTile;
  }

  UnitStrengthModifier getStrengthReduction() {
    return strengthReduction;
  }

  public TerrainTile getNewTile() {
    return newTile;
  }

  @Override
  public String toString() {
    return "Move{" +
        " newTile=" + newTile +
        '}';
  }
}
