package dhbw.SE_Refactoring;

public class RegularPrice extends Price {

    public RegularPrice(){
        super(PriceCode.REGULAR);
    }

    public double calculate(int days) {
        double thisAmount = 2;
        if (days > 2) {
            thisAmount += (days - 2) * 1.5;
        }
        return thisAmount;
    }
}
