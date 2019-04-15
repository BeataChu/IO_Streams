package task3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class IMDBCollectionTest {
    IMDBCollection imdb;
    Movie movie1, movie2;
    Actor actor1, actor2;
    String movieName1 = "Charlie and the Chocolate Factory";
    String movieName2 = "What's Eating Gilbert Grape";
    int year1 = 2005;
    int year2 = 1993;
    String name1 = "Johnny";
    String lastname1 = "Depp";
    String name2 = "Helena Bonham";
    String lastname2 = "Carter";


    @Before
    public void setUp() {
        imdb = IMDBCollection.getInstance();
        movie1 = new Movie(movieName1, year1);
        movie2 = new Movie(movieName2, year2);
        actor1 = new Actor(name1, lastname1);
        actor2 = new Actor(name2, lastname2);

    }

    @After
    public void tearDown() {

        imdb.clear();
    }

    @Test
    public void addMoviesToCollectionAddsOnlyOnce() {
        imdb.addMovie(movie1);
        imdb.addMovie(movie2);
        imdb.addMovie(movie2);
        String expectedString = String.format("\rMovie name: %s, year: %d\n\rMovie name: %s, year: %d\n", movieName2, year2, movieName1, year1);
        assertEquals(expectedString, imdb.showCollection());
    }

    @Test
    public void increaseVersionByOne() {
        int version = imdb.getVersion();
        imdb.increaseVersion();
        assertEquals(version + 1, imdb.getVersion());
    }
}