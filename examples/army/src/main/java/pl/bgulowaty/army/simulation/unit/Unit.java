package pl.bgulowaty.army.simulation.unit;

import java.util.UUID;

public interface Unit {

  UnitId getUnitId();

  String getName();

  UnitType getType();

  UnitStrength getStrength();

  ArmyId getAssignedArmyId();

  class UnitId {

    private final UUID id;

    public UnitId(UUID id) {this.id = id;}

    @Override
    public boolean equals(Object o) {
      if (this == o)
        return true;
      if (o == null || getClass() != o.getClass())
        return false;

      UnitId unitId = (UnitId) o;

      return id.equals(unitId.id);
    }

    @Override
    public int hashCode() {
      return id.hashCode();
    }
  }
}
