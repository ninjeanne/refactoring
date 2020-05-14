package dhbw.SE_Refactoring;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class RentalTest {

    @Test
    public void initialize() {
        Movie movie = new Movie("title", PriceCode.REGULAR);
        Rental rental = new Rental(movie, 30);

        Assert.assertEquals(movie, rental.getMovie());
        Assert.assertEquals(30, rental.getDaysRented());
    }

    @Test
    @Ignore
    public void initialize2() {
        Rental rental = new Rental(null, -1);

        Assert.assertNull(rental.getMovie());
        Assert.assertEquals(-1, rental.getDaysRented());
        Assert.assertTrue(false);//shall fail
        //TODO is this a wanted behaviour? Fix it later
    }

}
