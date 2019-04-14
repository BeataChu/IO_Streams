package task3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
Movie movie;
Actor actor;
String movieName1 = "Название фильма1";
String movieName2 = "Название фильма2";
int year1 = 1995;
int year2 = 2000;
String actorName = "Имя";
String actorLastname = "Фамилия";

@Before
public void setUp() {
    actor = new Actor(actorName, actorLastname);
    movie = new Movie(movieName1, year1);
}

    @Test
    public void addActorOnceReturnTrue(){
        assertTrue(movie.addActor(actor));
    }
    @Test
    public void addActorTwiceReturnFalse(){
        movie.addActor(actor);
        assertFalse(movie.addActor(actor));
    }

    @Test
    public void deleteActorFromCastReturnTrue(){
        movie.addActor(actor);
        assertTrue(movie.removeActor(actor));
    }

    @Test
    public void deleteActorNotPresentInCastReturnFalse() {
        assertFalse(movie.removeActor(actor));
    }

    @Test
    public void changeMovieNameTest(){
        movie.changeMovieName(movieName2);
        assertEquals(movieName2, movie.getName());
    }

}