package dhbw.SE_Refactoring;

public class Movie {

    private final String title;
    private PriceCode priceCode;

    public Movie(String title, PriceCode priceCode) {
        this.title = title;
        setPriceCode(priceCode);
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(PriceCode priceCode) {
        if (priceCode == null) {
            this.priceCode = PriceCode.REGULAR;
            return;
        }
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

}
