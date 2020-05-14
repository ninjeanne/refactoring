package dhbw.SE_Refactoring;

import org.junit.Assert;
import org.junit.Test;

public class MovieTest {

    @Test
    public void initializeVariables() {
        Movie movie = new Movie("title", PriceCode.REGULAR);
        Assert.assertEquals(PriceCode.REGULAR, movie.getPriceCode());
        Assert.assertEquals("title", movie.getTitle());
    }

    @Test
    public void initializeVariables2() {
        Movie movie = new Movie(null, null);
        Assert.assertNotNull(movie.getPriceCode());
        Assert.assertEquals(PriceCode.REGULAR, movie.getPriceCode());
        Assert.assertNull(movie.getTitle());
    }

    @Test
    public void testSetter() {
        Movie movie = new Movie("title", PriceCode.NEW_RELEASE);
        Assert.assertEquals(PriceCode.NEW_RELEASE, movie.getPriceCode());
        movie.setPriceCode(PriceCode.REGULAR);
        Assert.assertEquals(PriceCode.REGULAR, movie.getPriceCode());
    }
}
