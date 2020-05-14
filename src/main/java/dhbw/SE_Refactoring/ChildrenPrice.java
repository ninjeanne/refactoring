package dhbw.SE_Refactoring;

public class ChildrenPrice extends Price {

    public ChildrenPrice(){
        super(PriceCode.CHILDREN);
    }

    public double calculate(int days) {
        double thisAmount = 1.5;
        if (days > 3) {
            thisAmount += (days - 3) * 1.5;
        }
        return thisAmount;
    }
}
