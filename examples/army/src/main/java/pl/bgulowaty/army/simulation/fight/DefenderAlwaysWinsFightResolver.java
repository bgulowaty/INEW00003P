package pl.bgulowaty.army.simulation.fight;

public class DefenderAlwaysWinsFightResolver implements FightResolver {

  @Override
  public FightResult resolve(Fight fight) {
    System.out.println("Fight is being fought: " + fight);
    return new FightResult(fight.getDefenders());
  }
}
