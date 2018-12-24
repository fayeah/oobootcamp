package length;

public enum Unit {
    METER("meter", 1),
    KILOMETER("kilometer", 1000),
    MILLIMETER("millimeter", 0.001);

    private String code;
    private double multiple;

    private Unit(String code, double mutiple) {
        this.code = code;
        this.multiple = mutiple;
    }

    public double getMultiple() {
        return multiple;
    }
}
