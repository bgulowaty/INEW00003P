package pl.bgulowaty.army.app;

import pl.bgulowaty.army.simulation.Simulation.RuntimeSimulationProperties;

public interface SimulationPropertiesProvider {

  RuntimeSimulationProperties getRuntimeProperties();

  InitialSimulationSetup getInitialSetup();
}
