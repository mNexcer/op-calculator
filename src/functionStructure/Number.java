package functionStructure;

/**
 * Created by Maciej on 2016-11-01.
 */
public class Number {
    private double value;

    public Number(String value) {
        this.value = Evaluate(value);
    }

    public Number(double value) {
        this.value = value;
    }

    private double Evaluate(String value) {
        return Double.parseDouble(value);
    }

    public double getValue() {
        return value;
    }
}
