package task3;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MovieCollectionTest {
    MovieCollection movieCollection;
    Movie movie1, movie2;
    Actor actor1, actor2;
    String movieName1 = "Название фильма1";
    String movieName2 = "Название фильма2";
    int year1 = 1995;
    int year2 = 2000;
    String name1 = "Имя1";
    String lastname1 = "Фамилия1";
    String name2 = "Имя2";
    String lastname2 = "Фамилия2";
    Set expectedSet;

    @Before
    public void setUp() {
        movieCollection = MovieCollection.getInstance();
        movie1 = new Movie(movieName1, year1);
        movie2 = new Movie(movieName2, year2);
        actor1 = new Actor(name1,lastname1);
        actor2 = new Actor(name2, lastname2);

    }

    @After
    public void tearDown() {
        movieCollection.collection.clear();
    }

    @Test
    public void addMoviesToCollection(){
        movieCollection.addMovie(movie1);
        movieCollection.addMovie(movie2);
        movieCollection.addMovie(movie2);
        expectedSet = new HashSet<Movie>();
        expectedSet.add(movie1);
        expectedSet.add(movie2);
        assertEquals(expectedSet, movieCollection.getCollection());
    }
}