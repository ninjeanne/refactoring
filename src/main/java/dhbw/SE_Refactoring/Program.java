package dhbw.SE_Refactoring;

public class Program {

    /**
     * This is the main entry point for the application
     */
    public static void main(String[] args) {
        String result;
        System.out.println("Welcome to the Movie Store");

        Movie firstMovie = new Movie("movie1", PriceCode.NEW_RELEASE);
        Movie secondMovie = new Movie("movie2", PriceCode.CHILDREN);
        Rental firstRental = new Rental(firstMovie, 10);
        Rental secondRental = new Rental(secondMovie, 5);
        Customer customerJoe = new Customer("joe");
        customerJoe.addRental(firstRental);
        customerJoe.addRental(secondRental);

        System.out.println("Let's get the Statement");
        result = customerJoe.statement();
        System.out.println(result);
    }
}


