package pl.bgulowaty.army.simulation;

import pl.bgulowaty.army.simulation.terrain.TerrainTile;
import pl.bgulowaty.army.simulation.unit.ArmyId;
import pl.bgulowaty.army.simulation.unit.Unit;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import static pl.bgulowaty.army.simulation.ArmyUnitsCountingUtils.getUnitCountByArmy;

public class ArmyUnitsCounter {

  private final Map<TerrainTile, Set<Unit>> unitsByTile;

  public ArmyUnitsCounter(
      Map<TerrainTile, Set<Unit>> unitsByTile) {this.unitsByTile = unitsByTile;}


  Map<ArmyId, Integer> countEachArmyOccurrences() {
    Map<ArmyId, Integer> countByArmyId = new HashMap<>();
    for(Set<Unit> units: unitsByTile.values()) {

      Map<ArmyId, Integer> unitCountByArmy = getUnitCountByArmy(units);
      for(Entry<ArmyId, Integer> entry: unitCountByArmy.entrySet()){
        ArmyId armyId = entry.getKey();
        Integer currentValue = countByArmyId.getOrDefault(armyId, 0);
        countByArmyId.put(armyId, currentValue + 1);
      }
    }
    return countByArmyId;
  }

  int countUnits() {
    int unitCount = 0;
    for (Set<Unit> units: unitsByTile.values()) {
      for (Unit ignored : units)
        unitCount++;
    }

    return unitCount;
  }

  int countArmiesInTotal() {
    return countEachArmyOccurrences().keySet().size();
  }
}
