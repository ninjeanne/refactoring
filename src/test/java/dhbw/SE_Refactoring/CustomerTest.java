package dhbw.SE_Refactoring;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {

    private Movie movie;
    private Rental rental;
    private Customer customer;

    @Before
    public void beforeEach(){
        movie = new Movie("title", Movie.REGULAR);
        rental= new Rental(movie, 4);
        customer = new Customer("someName");
    }

    @Test
    public void initialize(){
        Customer customer = new Customer("someName");
        Assert.assertEquals("someName", customer.getName());
    }

    @Test
    public void statementRegular(){
        movie = new Movie("title", Movie.REGULAR);
        rental= new Rental(movie, 2);
        customer = new Customer("someName");
        customer.addRental(rental);
        Assert.assertEquals("Rental Record for someName\n" + "\tTitle\t\tDays\tAmount\n" + "\ttitle\t\t2\t2.0\n" + "Amount owed is 2.0\n"
                + "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void statementRegularOtherDays(){
        movie = new Movie("title", Movie.REGULAR);
        rental= new Rental(movie, 30);
        customer = new Customer("someName");
        customer.addRental(rental);
        Assert.assertEquals("Rental Record for someName\n" + "\tTitle\t\tDays\tAmount\n" + "\ttitle\t\t30\t44.0\n" + "Amount owed is 44.0\n"
                + "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void statementRelease(){
        movie = new Movie("title", Movie.NEW_RELEASE);
        rental= new Rental(movie, 2);
        customer = new Customer("someName");
        customer.addRental(rental);
        Assert.assertEquals("Rental Record for someName\n" + "\tTitle\t\tDays\tAmount\n" + "\ttitle\t\t2\t6.0\n" + "Amount owed is 6.0\n"
                + "You earned 2 frequent renter points", customer.statement());
    }

    @Test
    public void statementReleaseMultipleRentals(){
        movie = new Movie("title", Movie.NEW_RELEASE);
        rental= new Rental(movie, 2);
        customer = new Customer("someName");
        customer.addRental(rental);
        customer.addRental(rental);
        Assert.assertEquals("Rental Record for someName\n" + "\tTitle\t\tDays\tAmount\n" + "\ttitle\t\t2\t6.0\n" + "\ttitle\t\t2\t6.0\n"
                + "Amount owed is 12.0\n" + "You earned 4 frequent renter points", customer.statement());
    }

    @Test
    public void statementReleaseFrequentPoints(){
        movie = new Movie("title", Movie.NEW_RELEASE);
        rental= new Rental(movie, 30);
        customer = new Customer("someName");
        customer.addRental(rental);
        Assert.assertEquals("Rental Record for someName\n" + "\tTitle\t\tDays\tAmount\n" + "\ttitle\t\t30\t90.0\n" + "Amount owed is 90.0\n"
                + "You earned 2 frequent renter points", customer.statement());
    }

    @Test
    public void statementChildrens(){
        movie = new Movie("title", Movie.CHILDRENS);
        rental= new Rental(movie, 2);
        customer = new Customer("someName");
        customer.addRental(rental);
        Assert.assertEquals("Rental Record for someName\n" + "\tTitle\t\tDays\tAmount\n" + "\ttitle\t\t2\t1.5\n" + "Amount owed is 1.5\n"
                + "You earned 1 frequent renter points", customer.statement());
    }

    @Test
    public void statementWrongPrice(){
        movie = new Movie("title", -1);
        rental= new Rental(movie, 2);
        customer = new Customer("someName");
        customer.addRental(rental);
        Assert.assertEquals("Rental Record for someName\n" + "\tTitle\t\tDays\tAmount\n" + "\ttitle\t\t2\t0.0\n" + "Amount owed is 0.0\n"
                + "You earned 1 frequent renter points", customer.statement());
        Assert.assertTrue(false);//should fail!
    }

    @Test
    public void statementWrongDays(){
        movie = new Movie("title", Movie.REGULAR);
        rental= new Rental(movie, -1);
        customer = new Customer("someName");
        customer.addRental(rental);
        Assert.assertEquals("Rental Record for someName\n" + "\tTitle\t\tDays\tAmount\n" + "\ttitle\t\t-1\t2.0\n" + "Amount owed is 2.0\n"
                + "You earned 1 frequent renter points", customer.statement());
        Assert.assertTrue(false);//should fail!
    }
}
