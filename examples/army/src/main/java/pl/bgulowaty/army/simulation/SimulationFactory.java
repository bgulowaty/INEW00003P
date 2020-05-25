package pl.bgulowaty.army.simulation;

import pl.bgulowaty.army.app.SimulationPropertiesProvider;
import pl.bgulowaty.army.simulation.fight.DefenderAlwaysWinsFightResolver;
import pl.bgulowaty.army.simulation.move.RandomNeighborNewPositionDecider;

public class SimulationFactory {

  private final SimulationPropertiesProvider simulationPropertiesProvider;

  public SimulationFactory(
      SimulationPropertiesProvider simulationPropertiesProvider) {
    this.simulationPropertiesProvider = simulationPropertiesProvider;
  }

  public Simulation create() {
    return new Simulation(
        simulationPropertiesProvider.getRuntimeProperties(),
        simulationPropertiesProvider.getInitialSetup().getInitialPositions(),
        new DefenderAlwaysWinsFightResolver(),
        new RandomNeighborNewPositionDecider());
  }
}
