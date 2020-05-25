package pl.bgulowaty.army.simulation.unit;

public class UnitStrength {

  private final float value;

  public UnitStrength(float value) {this.value = value;}

  public float getValue() {
    return value;
  }

  public UnitStrength minus(UnitStrength losses) {
    return new UnitStrength(getValue() - losses.getValue());
  }

  public static UnitStrength of(float value) {
    return new UnitStrength(value);
  }

  public static UnitStrength zero() {
    return new UnitStrength(0);
  }
}
