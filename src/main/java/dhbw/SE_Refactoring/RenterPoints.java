package dhbw.SE_Refactoring;

public class RenterPoints {
    private int value;

    public void increase(){
        value++;
    }

    public int getValue(){
        return value;
    }

    @Override
    public String toString() {
        return "You earned " + value + " frequent renter points";
    }
}
