package pl.bgulowaty.army.simulation.unit;

import java.util.UUID;

public class SimpleUnit implements Unit {

  private final String name;
  private final UnitType unitType;
  private final UnitStrength unitStrength;
  private final ArmyId armyId;
  private final UnitId unitId;


  public SimpleUnit(
      String name, UnitType unitType, UnitStrength unitStrength,
      ArmyId armyId) {
    this.unitId = new UnitId(UUID.randomUUID());
    this.name = name;
    this.unitType = unitType;
    this.unitStrength = unitStrength;
    this.armyId = armyId;
  }

  @Override
  public UnitId getUnitId() {
    return unitId;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public UnitType getType() {
    return unitType;
  }

  @Override
  public UnitStrength getStrength() {
    return unitStrength;
  }

  @Override
  public ArmyId getAssignedArmyId() {
    return armyId;
  }
}
