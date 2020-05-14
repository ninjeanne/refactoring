package dhbw.SE_Refactoring;

public enum PriceCode {
    REGULAR(new RegularPrice()),
    NEW_RELEASE(new NewReleasePrice()),
    CHILDREN(new ChildrenPrice());

    private final Price price;

    PriceCode(Price price) {
        this.price = price;
    }

    public double getPrice(int days){
        return price.calculate(days);
    }
}
