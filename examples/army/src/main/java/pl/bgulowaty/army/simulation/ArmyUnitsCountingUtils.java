package pl.bgulowaty.army.simulation;

import pl.bgulowaty.army.simulation.unit.ArmyId;
import pl.bgulowaty.army.simulation.unit.Unit;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArmyUnitsCountingUtils {

  private ArmyUnitsCountingUtils() {
  }

  public static Map<ArmyId, Integer> getUnitCountByArmy(Set<Unit> units) {
    Map<ArmyId, Integer> countByArmyId = new HashMap<>();
    for(Unit unit: units) {
      ArmyId armyId = unit.getAssignedArmyId();
      Integer currentCount = countByArmyId.getOrDefault(armyId, 0);
      countByArmyId.put(armyId, currentCount + 1);
    }
    return countByArmyId;
  }
}
