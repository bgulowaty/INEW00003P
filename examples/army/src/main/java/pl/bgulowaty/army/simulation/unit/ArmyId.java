package pl.bgulowaty.army.simulation.unit;

import java.util.UUID;

public class ArmyId {

  private final UUID id;

  public ArmyId(UUID id) {this.id = id;}


  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    ArmyId armyId = (ArmyId) o;

    return id.equals(armyId.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
