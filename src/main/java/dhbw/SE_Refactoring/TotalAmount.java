package dhbw.SE_Refactoring;

public class TotalAmount {

    private double value;

    public void increase(double value) {
        this.value += value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Amount owed is " + value + "\n";
    }
}
