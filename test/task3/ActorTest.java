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
    public void setUp(){
        actor = new Actor(name1, lastname1);
        movie = new Movie(movieName, 1995);
    }

    @Test
    public void changeNameTest(){
        actor.changeName(name2);
        assertEquals(name2, actor.getName());
    }

    @Test
    public void changeLastnameTest(){
        actor.changeLastname(lastname2);
        assertEquals(lastname2, actor.getLastname());
    }

    @Test
    public void addMovieOnceReturnAppropriateText(){
        assertEquals(actor.ADDED, actor.addMovie(movie));
    }
    @Test
    public void addMovieTwiceReturnAppropriateText(){
        actor.addMovie(movie);
        assertEquals(actor.ALREADY_ON_THE_LIST, actor.addMovie(movie));
    }

    @Test
    public void removeMovieFromTheListReturnText(){
        actor.addMovie(movie);
        assertEquals(actor.REMOVED, actor.removeMovie(movie));
    }

    @Test
    public void removeMovieNotPresentOnTheListReturnText(){
        assertEquals(actor.NOT_ON_THE_LIST, actor.removeMovie(movie));
    }
}