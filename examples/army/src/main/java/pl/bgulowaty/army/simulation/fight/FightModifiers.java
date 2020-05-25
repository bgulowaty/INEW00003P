package pl.bgulowaty.army.simulation.fight;

import pl.bgulowaty.army.simulation.unit.UnitStrengthModifier;

public interface FightModifiers {
  UnitStrengthModifier defenderModifier();

  UnitStrengthModifier attackerModifier();

}
