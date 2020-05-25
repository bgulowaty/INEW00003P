package pl.bgulowaty.army.simulation.terrain;

import pl.bgulowaty.army.simulation.unit.Unit;
import pl.bgulowaty.army.simulation.unit.UnitStrength;
import pl.bgulowaty.army.simulation.unit.UnitStrengthModifier;
import pl.bgulowaty.army.simulation.unit.UnitType;

public class Mountains implements TerrainTile {

  private final PossiblePassages neighbourhood;

  public Mountains(PossiblePassages neighbourhood) {this.neighbourhood = neighbourhood;}

  @Override
  public PossiblePassages getPassages() {
    return neighbourhood;
  }

  @Override
  public UnitStrengthModifier defenderModifier() {
    return new DefenderMountainsUnitStrengthModifier();
  }

  @Override
  public UnitStrengthModifier attackerModifier() {
    return new AttackerMountainsUnitStrengthModifier();
  }

  private static class DefenderMountainsUnitStrengthModifier implements UnitStrengthModifier {

    @Override
    public UnitStrength apply(Unit unit) {
      if (unit.getType() == UnitType.ARTILLERY)
        return UnitStrength.of(unit.getStrength().getValue() + 2);

      return unit.getStrength();
    }
  }

  private static class AttackerMountainsUnitStrengthModifier implements UnitStrengthModifier {

    @Override
    public UnitStrength apply(Unit unit) {
      if (unit.getType() == UnitType.ARTILLERY)
        return UnitStrength.of(unit.getStrength().getValue() - 2);

      return unit.getStrength();
    }
  }
}
