package pl.bgulowaty.army.simulation;

import pl.bgulowaty.army.simulation.unit.Unit;

import java.util.Set;

public class SimulationResults {

  private final Set<Unit> survivors;

  public SimulationResults(Set<Unit> survivors) {this.survivors = survivors;}

  Set<Unit> getSurvivors() {
    return survivors;
  }

  @Override
  public String toString() {
    return "SimulationResults{" +
        "survivors=" + survivors +
        '}';
  }
}
