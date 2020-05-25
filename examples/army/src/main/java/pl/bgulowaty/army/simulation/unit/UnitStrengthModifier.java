package pl.bgulowaty.army.simulation.unit;

public interface UnitStrengthModifier {

  UnitStrength apply(Unit unit);

  class ZeroModifier implements UnitStrengthModifier {

    @Override
    public UnitStrength apply(Unit unit) {
      return unit.getStrength();
    }
  }
}
