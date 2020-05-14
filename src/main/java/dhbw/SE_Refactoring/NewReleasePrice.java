package dhbw.SE_Refactoring;

public class NewReleasePrice extends Price {

    public NewReleasePrice(){
        super(PriceCode.NEW_RELEASE);
    }

    public double calculate(int days) {
        return days * 3;
    }
}
