package dhbw.SE_Refactoring;

import static dhbw.SE_Refactoring.PriceCode.NEW_RELEASE;

public class RenterPoints {
    private int value;

    public void increase(){
        value++;
    }

    public int getValue(){
        return value;
    }

    public void increaseBonus(Rental rental){
        if ((rental.getMovie().getPriceCode() == NEW_RELEASE) && rental.getDaysRented() > 1) {
            increase();
        }
    }

    @Override
    public String toString() {
        return "You earned " + value + " frequent renter points";
    }
}
