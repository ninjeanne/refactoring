package dhbw.SE_Refactoring;

public abstract class Price {
    private final PriceCode priceCode;

    public Price(PriceCode category){
        this.priceCode = category;
    }

    public abstract double calculate(int days);
}
