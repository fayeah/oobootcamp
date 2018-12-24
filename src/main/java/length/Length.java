package length;

public class Length {
    private double value;
    private Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getMeterValue() {
        return value * unit.getMultiple();
    }
}
