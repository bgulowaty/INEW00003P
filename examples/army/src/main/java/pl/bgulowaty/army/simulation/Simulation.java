package pl.bgulowaty.army.simulation;

import pl.bgulowaty.army.simulation.fight.Fight;
import pl.bgulowaty.army.simulation.fight.FightResolver;
import pl.bgulowaty.army.simulation.fight.FightResult;
import pl.bgulowaty.army.simulation.move.Move;
import pl.bgulowaty.army.simulation.move.NextUnitPositionDecider;
import pl.bgulowaty.army.simulation.terrain.TerrainTile;
import pl.bgulowaty.army.simulation.unit.ArmyId;
import pl.bgulowaty.army.simulation.unit.Unit;

import java.util.*;

import static java.util.stream.Collectors.*;
import static pl.bgulowaty.army.simulation.ArmyUnitsCountingUtils.getUnitCountByArmy;

public class Simulation {

  private final RuntimeSimulationProperties runtimeSimulationProperties;
  private final Map<TerrainTile, Set<Unit>> unitByPosition;
  private final List<Unit> recentlyMovedUnits = new ArrayList<>();
  private final Random randomSeed = new Random();
  private final FightResolver fightResolver;
  private final NextUnitPositionDecider nextUnitMoveDecider;

  public Simulation(
      RuntimeSimulationProperties runtimeSimulationProperties,
      Map<TerrainTile, Set<Unit>> unitByPosition,
      FightResolver fightResolver,
      NextUnitPositionDecider nextUnitMoveDecider) {
    this.runtimeSimulationProperties = runtimeSimulationProperties;
    this.unitByPosition = unitByPosition;
    this.fightResolver = fightResolver;
    this.nextUnitMoveDecider = nextUnitMoveDecider;
  }

  void moveEachUnit() {
    recentlyMovedUnits.clear();

    for (TerrainTile tile: unitByPosition.keySet()) {
      moveUnitsInTile(tile);
    }
  }

  private void moveUnitsInTile(TerrainTile tile) {
    Set<Unit> units = unitByPosition.get(tile);
    for (Unit unit : units) {
      if (shouldMove()) {
        moveSingleUnit(tile, unit);
      }
    }
  }

  private void moveSingleUnit(TerrainTile currentPosition, Unit unit) {
    Move move = nextUnitMoveDecider.decide(currentPosition, unit);
    System.out.println("Moving " + unit.getName() + ": " + move);
    unitByPosition
        .get(currentPosition)
        .remove(unit);
    unitByPosition
        .getOrDefault(move.getNewTile(), new HashSet<>())
        .add(unit);
    recentlyMovedUnits.add(unit);
  }

  boolean shouldMove() {
    return randomSeed.nextFloat() <= runtimeSimulationProperties.movementProbability;
  }

  SimulationResults getResults() {
    Set<Unit> survivors = unitByPosition.values()
        .stream()
        .flatMap(Collection::stream)
        .collect(toSet());

    return new SimulationResults(survivors);
  }

  void resolveFightsInConflictingTiles() {
    for (TerrainTile tile: unitByPosition.keySet()) {
      if (thereAreDifferentArmyUnitsInTile(tile)) {
        resolveFightInTile(tile);
      }
    }
  }

  private boolean thereAreDifferentArmyUnitsInTile(TerrainTile tile) {
    Set<Unit> unitsInTile = unitByPosition.get(tile);
    Map<ArmyId, Integer> unitCountByArmy = getUnitCountByArmy(unitsInTile);

    return unitCountByArmy.keySet().size() > 1;
  }

  private void resolveFightInTile(TerrainTile tile) {
    Set<Unit> allUnitsInTile = unitByPosition.get(tile);
    Set<Unit> attackers = getAttackers(allUnitsInTile);
    Set<Unit> defenders = getDefenders(allUnitsInTile);
    FightResult fightResults = fightResolver.resolve(new Fight(attackers, defenders, tile));
    recentlyMovedUnits.removeAll(attackers);
    allUnitsInTile.clear();
    allUnitsInTile.addAll(fightResults.getSurvivors());
  }

  private Set<Unit> getDefenders(Set<Unit> fightingUnits) {
    return fightingUnits.stream()
        .filter(unit -> !recentlyMovedUnits.contains(unit))
        .collect(toSet());
  }

  private Set<Unit> getAttackers(Set<Unit> fightingUnits) {
    return fightingUnits.stream()
        .filter(recentlyMovedUnits::contains)
        .collect(toSet());
  }

  boolean thereAreUnitsOfMoreThanOneArmy() {
    int armiesInTotal = new ArmyUnitsCounter(unitByPosition).countArmiesInTotal();

    return armiesInTotal > 1;
  }

  boolean thereAreAnyUnits() {
    int unitsCount = new ArmyUnitsCounter(unitByPosition).countUnits();

    return unitsCount != 0;
  }

  public static class RuntimeSimulationProperties {
    private final float movementProbability;

    public RuntimeSimulationProperties(float movementProbability) {
      if (movementProbability < 0 || movementProbability > 1)
        throw new IllegalArgumentException("Movement proba needs to be between <0,1>");
      this.movementProbability = movementProbability;
    }
  }
}
