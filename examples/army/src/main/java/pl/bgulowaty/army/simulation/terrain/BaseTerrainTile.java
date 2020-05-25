package pl.bgulowaty.army.simulation.terrain;

import pl.bgulowaty.army.simulation.unit.UnitStrength;
import pl.bgulowaty.army.simulation.unit.UnitStrengthModifier;

public abstract class BaseTerrainTile implements TerrainTile {

  private final PossiblePassages possiblePassages;

  protected BaseTerrainTile(PossiblePassages possiblePassages) {
    this.possiblePassages = possiblePassages;
  }


  protected abstract float defenderMultiplier();
  protected abstract float attackerMultiplier();


  @Override
  public PossiblePassages getPassages() {
    return possiblePassages;
  }

  @Override
  public UnitStrengthModifier defenderModifier() {
    return unit -> UnitStrength.of(unit.getStrength().getValue() * defenderMultiplier());
  }

  @Override
  public UnitStrengthModifier attackerModifier() {
    return unit -> UnitStrength.of(unit.getStrength().getValue() * attackerMultiplier());
  }
}
