package pl.bgulowaty.army.app;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import pl.bgulowaty.army.simulation.unit.ArmyId;
import pl.bgulowaty.army.simulation.terrain.Direction;
import pl.bgulowaty.army.simulation.Simulation.RuntimeSimulationProperties;
import pl.bgulowaty.army.simulation.terrain.Grasslands;
import pl.bgulowaty.army.simulation.terrain.Mountains;
import pl.bgulowaty.army.simulation.terrain.PossiblePassages;
import pl.bgulowaty.army.simulation.terrain.Riverlands;
import pl.bgulowaty.army.simulation.unit.SimpleUnit;
import pl.bgulowaty.army.simulation.unit.Unit;
import pl.bgulowaty.army.simulation.unit.UnitStrength;
import pl.bgulowaty.army.simulation.unit.UnitType;

import java.util.HashMap;
import java.util.UUID;

import static com.google.common.collect.ImmutableMap.of;
import static pl.bgulowaty.army.simulation.terrain.PossiblePassages.noPassages;

public class DummySimulationPropertiesProvider implements SimulationPropertiesProvider {

  @Override
  public RuntimeSimulationProperties getRuntimeProperties() {
    return new RuntimeSimulationProperties(0.5f);
  }

  // Dont use this method as example, its made this way for sake of project compilation
  // In the project, those intial value should be read from user input
  @Override
  public InitialSimulationSetup getInitialSetup() {
    ArmyId redArmy = new ArmyId(UUID.randomUUID());
    ArmyId blueArmy = new ArmyId(UUID.randomUUID());

    Mountains someMountains = new Mountains(noPassages());
    Riverlands riverlands = new Riverlands(
        new PossiblePassages(of(
            Direction.BOTTOM, someMountains,
            Direction.TOP, someMountains)));
    Grasslands grasslands = new Grasslands(new PossiblePassages(of(
        Direction.RIGHT, riverlands,
        Direction.LEFT, someMountains,
        Direction.TOP, someMountains)));

    Unit redArmy1stPlatoon =
        new SimpleUnit("RedArmy1stPlatoon", UnitType.ARTILLERY, new UnitStrength(20), redArmy);

    Unit blueArmy1stPlatoon =
        new SimpleUnit("BlueArmy1stPlatoon", UnitType.CAVALRY, new UnitStrength(30), blueArmy);

    return new InitialSimulationSetup(
        new HashMap<>(ImmutableMap.of(
            riverlands, Sets.newHashSet(redArmy1stPlatoon),
            someMountains, Sets.newHashSet(),
            grasslands, Sets.newHashSet(blueArmy1stPlatoon)
        ))
    );
  }
}
