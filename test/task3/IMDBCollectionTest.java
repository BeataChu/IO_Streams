package task3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        imdb.addMovie(movie1);
    }

    @After
    public void tearDown() {

        imdb.clear();
    }

    @Test
    public void addMoviesToCollectionAddsOnlyOnce() {
        imdb.addMovie(movie2);
        imdb.addMovie(movie2);
        String expectedString = String.format("\rMovie name: %s, year: %d\n\rMovie name: %s, year: %d\n", movieName1, year1, movieName2, year2);
        assertEquals(expectedString, imdb.showCollection());
    }

    @Test
    public void addActorsToCollectionOnlyOnceAndShowCollection() {
        imdb.addActor(actor1);
        imdb.addActor(actor2);
        imdb.addActor(actor2);
        imdb.addActorToMovieByMovieName(movieName1, name1, lastname1);
        imdb.addActorToMovieByMovieName(movieName1,name2, lastname2);
        imdb.addActorToMovieByMovieName(movieName1,name2, lastname2);
        String expectedString = String.format("\rMovie name: %s, year: %d\n\tActor's name: %s %s\n\tActor's name: %s %s\n", movieName1, year1, name1, lastname1, name2, lastname2);
        assertEquals(expectedString, imdb.showCollection());
    }

    @Test
    public void increaseVersionByOne() {
        int version = imdb.getVersion();
        imdb.increaseVersion();
        assertEquals(version + 1, imdb.getVersion());
    }

    @Test
    public void returnProperObjectByMovieName(){
       assertEquals(String.format("Movie name: %s, year: %d", movieName1, year1), movie1.toString());
    }

    @Test
    public void returnNullIfMovieNameDoesNotComply(){
        assertNull(imdb.getMovieByMovieName(movieName1 + "123"));
    }

    @Test
    public void returnProperObjectByActorsName(){
        assertEquals(String.format("Actor's name: %s %s", name1, lastname1), actor1.toString());
    }

    @Test
    public void returnNullIfActorsNameDoesNotComply(){
        assertNull(imdb.getActorByName(name1, lastname2));
    }

    @Test
    public void deleteMovieFromCollection(){
        imdb.addActor(actor1);
        movie1.addActor(actor1);
        actor1.addMovie(movie1);
        imdb.deleteMovie(movieName1);
        assertEquals("", imdb.showCollection());
    }

    @Test
    public void deleteMovieFromFilmography(){
        imdb.addActor(actor1);
        movie1.addActor(actor1);
        actor1.addMovie(movie1);
        imdb.deleteMovie(movieName1);
        assertEquals(0, actor1.getFilmography().size());
    }

    @Test
    public void doNotAddActorToCastIfActorIsNull(){
        imdb.addActorToMovieByMovieName(movieName1, name1, lastname2);
        assertEquals(0, movie1.getCast().size());

    }

    @Test
    public void removeLinkButDoNotRemoveObjectsThemselves(){
        imdb.addActor(actor1);
        movie1.addActor(actor1);
        actor1.addMovie(movie1);
        imdb.removeLinkBetweenActorAndMovie(name1, lastname1, movieName1);
        assertEquals(0, movie1.getCast().size());
    }
}