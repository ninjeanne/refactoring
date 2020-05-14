package dhbw.SE_Refactoring;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class MovieTest {

    @Test
    public void initializeVariables(){
        Movie movie = new Movie("title", PriceCode.REGULAR);
        Assert.assertEquals(PriceCode.REGULAR, movie.getPriceCode());
        Assert.assertEquals("title", movie.getTitle());
    }

    @Test
    @Ignore
    public void initializeVariables2(){
        Movie movie = new Movie(null, null);
        Assert.assertNull(movie.getPriceCode());
        Assert.assertNull(movie.getTitle());
        Assert.assertTrue(false);//shall fail for now
        //TODO is this a wanted behaviour? maybe fix it! Pricecode should be one of the 3 possibilities
    }

    @Test
    public void testSetter(){
        Movie movie = new Movie("title", PriceCode.NEW_RELEASE);
        Assert.assertEquals(PriceCode.NEW_RELEASE, movie.getPriceCode());
        movie.setPriceCode(PriceCode.REGULAR);
        Assert.assertEquals(PriceCode.REGULAR, movie.getPriceCode());
    }
}
