package dhbw.SE_Refactoring;

import org.junit.Assert;
import org.junit.Test;

public class MovieTest {

    @Test
    public void initializeVariables(){
        Movie movie = new Movie("title", Movie.REGULAR);
        Assert.assertEquals(Movie.REGULAR, movie.getPriceCode());
        Assert.assertEquals("title", movie.getTitle());
    }

    @Test
    public void initializeVariables2(){
        Movie movie = new Movie(null, -1);
        Assert.assertEquals(-1, movie.getPriceCode());
        Assert.assertNull(movie.getTitle());
        Assert.assertTrue(false);//shall fail for now
        //TODO is this a wanted behaviour? maybe fix it! Pricecode should be one of the 3 possibilities
    }

    @Test
    public void testSetter(){
        Movie movie = new Movie("title", Movie.NEW_RELEASE);
        Assert.assertEquals(Movie.NEW_RELEASE, movie.getPriceCode());
        movie.setPriceCode(Movie.REGULAR);
        Assert.assertEquals(Movie.REGULAR, movie.getPriceCode());
    }
}
