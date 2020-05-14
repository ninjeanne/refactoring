package dhbw.SE_Refactoring;

import java.util.Enumeration;
import java.util.Vector;

import static dhbw.SE_Refactoring.PriceCode.NEW_RELEASE;

class Customer {
    private String name;
    private Vector rentals = new Vector();

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
        Enumeration enum_rentals = rentals.elements();
        String result = printCustomerDetails();
        result += printHeader();

        while (enum_rentals.hasMoreElements()) {
            double thisAmount;
            Rental each = (Rental) enum_rentals.nextElement();

            thisAmount = amountFor(each);
            renterPoints.increase();
            renterPoints.increaseBonus(each);
            result += printDetails(each, thisAmount);
            totalAmount.increase(thisAmount);
        }
        result += printFooter(totalAmount, renterPoints);
        return result;
    }

    private String printCustomerDetails(){
        return "Rental Record for " + this.getName() + "\n";
    }

    private String printHeader(){
        return "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";
    }

    /**
     * add footer lines
     * @param totalAmount the calculated total amount of the renting of the customer
     * @param renterPoints the renter points for the customer
     * @return the footer lines
     */
    private String printFooter(TotalAmount totalAmount, RenterPoints renterPoints){
        return totalAmount.toString() + renterPoints.toString();
    }

    /**
     * show figures for this rental
     * @param rental current rental
     * @param amount price amount of current rental
     * @return Details of the rental including the movie title, the days rented and the amount
     */
    private String printDetails(Rental rental, double amount) {
        return "\t" + rental.getMovie().getTitle() + "\t" + "\t" + rental.getDaysRented() + "\t" + amount + "\n";
    }

    /**
     * determine amounts for current rental
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
