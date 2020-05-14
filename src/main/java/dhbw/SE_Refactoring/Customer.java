package dhbw.SE_Refactoring;

import java.util.Vector;

class Customer {
    private final String name;
    private final Vector<Rental> rentals = new Vector<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        TotalAmount totalAmount = new TotalAmount();
        RenterPoints renterPoints = new RenterPoints();
        CustomerLogger logger = new CustomerLogger(this, renterPoints, totalAmount);

        for (Rental currentRental : rentals) {
            double thisAmount;
            thisAmount = amountFor(currentRental);
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
     * @param each current rental
     * @return price of current rental
     */
    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
            case REGULAR:
                thisAmount += 2;
                if (each.getDaysRented() > 2) {
                    thisAmount += (each.getDaysRented() - 2) * 1.5;
                }
                break;
            case NEW_RELEASE:
                thisAmount += each.getDaysRented() * 3;
                break;
            case CHILDRENS:
                thisAmount += 1.5;
                if (each.getDaysRented() > 3) {
                    thisAmount += (each.getDaysRented() - 3) * 1.5;
                }
                break;
        }
        return thisAmount;
    }

}
