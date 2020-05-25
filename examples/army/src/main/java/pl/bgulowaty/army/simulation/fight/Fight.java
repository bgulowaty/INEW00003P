package pl.bgulowaty.army.simulation.fight;

import pl.bgulowaty.army.simulation.terrain.TerrainTile;
import pl.bgulowaty.army.simulation.unit.Unit;

import java.util.Set;

public class Fight {

  private final Set<Unit> attackers;

  private final Set<Unit> defenders;

  private final FightModifiers fightModifiers;

  public Fight(Set<Unit> attackers, Set<Unit> defenders, FightModifiers terrainTile) {
    this.attackers = attackers;
    this.defenders = defenders;
    this.fightModifiers = terrainTile;
  }

  Set<Unit> getAttackers() {
    return attackers;
  }

  Set<Unit> getDefenders() {
    return defenders;
  }

  FightModifiers getFightModifiers() {
    return fightModifiers;
  }

  @Override
  public String toString() {
    return "Fight{" +
        "attackers=" + attackers +
        ", defenders=" + defenders +
        ", fightModifiers=" + fightModifiers +
        '}';
  }
}
