package dhbw.SE_Refactoring;

public class CustomerLogger {
    private final StringBuilder builder = new StringBuilder();
    private final Customer customer;
    private final TotalAmount totalAmount;
    private final RenterPoints renterPoints;

    public CustomerLogger(Customer customer, RenterPoints renterPoints, TotalAmount totalAmount) {
        this.customer = customer;
        this.renterPoints = renterPoints;
        this.totalAmount = totalAmount;
        addCustomerDetails();
        addHeader();
    }

    /**
     * show figures for this rental
     *
     * @param rental current rental
     * @param amount price amount of current rental
     */
    public void addDetails(Rental rental, double amount) {
        builder.append("\t").append(rental.getMovie().getTitle()).append("\t\t").append(rental.getDaysRented()).append("\t").append(amount).append("\n");
    }

    public String printResult() {
        addFooter();
        return builder.toString();
    }

    /**
     * add footer lines
     */
    private void addFooter() {
        builder.append(totalAmount.toString()).append(renterPoints.toString());
    }

    private void addCustomerDetails() {
        builder.append("Rental Record for ").append(customer.getName()).append("\n");
    }

    private void addHeader() {
        builder.append("\tTitle\t\tDays\tAmount\n");
    }
}
