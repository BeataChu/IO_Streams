package task3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ActorTest {
    Actor actor;
    String name1 = "Имя1";
    String lastname1 = "Фамилия1";
    String name2 = "Имя2";
    String lastname2 = "Фамилия2";
    Movie movie;
    String movieName = "Название фильма";

    @Before
    public void setUp() {
        actor = new Actor(name1, lastname1);
        movie = new Movie(movieName, 1995);
    }

    @Test
    public void changeNameTest() {
        actor.changeName(name2);
        assertEquals(name2, actor.getName());
    }

    @Test
    public void changeLastnameTest() {
        actor.changeLastname(lastname2);
        assertEquals(lastname2, actor.getLastname());
    }

    @Test
    public void addMovieToFilmographyOnceReturnTrue() {
        assertTrue(actor.addMovie(movie));
    }

    @Test
    public void addMovieTwiceReturnFalse() {
        actor.addMovie(movie);
        assertFalse(actor.addMovie(movie));
    }

    @Test
    public void removeMovieFromSetReturnTrue() {
        actor.addMovie(movie);
        assertTrue(actor.removeMovie(movie));
    }

    @Test
    public void removeMovieNotPresentInSetReturnFalse() {
        actor.addMovie(movie);
        actor.removeMovie(movie);
        assertFalse(actor.removeMovie(movie));
    }
}