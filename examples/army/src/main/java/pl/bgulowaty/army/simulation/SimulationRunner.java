package pl.bgulowaty.army.simulation;

import java.time.Instant;

public class SimulationRunner {

  private final Simulation simulation;
  private final ResultsPrinter resultsPrinter;


  public SimulationRunner(
      Simulation simulation,
      ResultsPrinter resultsPrinter) {
    this.simulation = simulation;
    this.resultsPrinter = resultsPrinter;
  }


  public void run() {
    Instant conditionalStopTime = Instant.now().plusSeconds(15);

    while (
        simulation.thereAreAnyUnits() &&
        simulation.thereAreUnitsOfMoreThanOneArmy() &&
            timeLimitNotReached(conditionalStopTime)) {
      simulation.moveEachUnit();
      simulation.resolveFightsInConflictingTiles();
    }

    resultsPrinter.print(simulation.getResults());
  }

  private static boolean timeLimitNotReached(Instant conditionalStopTime) {
    return Instant.now().isBefore(conditionalStopTime);
  }
}
