package pl.bgulowaty.army.simulation.fight;

import pl.bgulowaty.army.simulation.unit.Unit;

import java.util.Set;

public class FightResult {
  private final Set<Unit> survivors;

  public FightResult(Set<Unit> survivors) {this.survivors = survivors;}

  public Set<Unit> getSurvivors() {
    return survivors;
  }
}
