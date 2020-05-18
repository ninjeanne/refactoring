package dhbw.SE_Refactoring;

import java.util.ArrayList;

class Customer {

    private final String name;
    private final ArrayList<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        if (name == null) {
            this.name = "unknown";
            return;
        }
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        TotalAmount totalAmount = new TotalAmount();
        RenterPoints renterPoints = new RenterPoints();
        CustomerLogger logger = new CustomerLogger(this, renterPoints, totalAmount);

        for (Rental currentRental : rentals) {
            double thisAmount = amountFor(currentRental);
            renterPoints.increase();
            renterPoints.increaseBonus(currentRental);
            logger.addDetails(currentRental, thisAmount);
            totalAmount.increase(thisAmount);
        }

        return logger.printResult();
    }

    /**
     * determine amounts for current rental
     *
     * @param rental current rental
     * @return price of current rental
     */
    private double amountFor(Rental rental) {
        return rental.getPrice();
    }

}
