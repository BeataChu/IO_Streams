package task3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class IMDBCollectionTest {
    IMDBCollection IMDBCollection;
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
        IMDBCollection = IMDBCollection.getInstance();
        movie1 = new Movie(movieName1, year1);
        movie2 = new Movie(movieName2, year2);
        actor1 = new Actor(name1,lastname1);
        actor2 = new Actor(name2, lastname2);
    }

    @After
    public void tearDown() {

        IMDBCollection.clear();
    }

    @Test
    public void addMoviesToCollection(){
        IMDBCollection.addMovie(movie1);
        IMDBCollection.addMovie(movie2);
        IMDBCollection.addMovie(movie2);
        expectedSet = new HashSet<Movie>();
        expectedSet.add(movie1);
        expectedSet.add(movie2);
        assertEquals(expectedSet, IMDBCollection.getCollection());
    }
}