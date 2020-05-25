package pl.bgulowaty.army.app;

import pl.bgulowaty.army.simulation.*;

public class Application {

  public static void main(String[] args) {
    SimulationPropertiesProvider simulationPropertiesProvider = new DummySimulationPropertiesProvider();
    SimulationFactory simulationFactory = new SimulationFactory(simulationPropertiesProvider);

    Simulation simulation = simulationFactory.create();
    ResultsPrinter resultsPrinter = new ResultsPrinter();

    new SimulationRunner(simulation, resultsPrinter).run();
  }
}
