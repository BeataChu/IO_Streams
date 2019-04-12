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
    public void changeNameTest(){
       movie.changeMovieName(movieName2);
        assertEquals(movieName2, movie.getName());
    }

    @Test
    public void addActorOnceReturnAppropriateText(){
        assertEquals(movie.ADDED, movie.addActor(actor));
    }
    @Test
    public void addActorTwiceReturnAppropriateText(){
        movie.addActor(actor);
        assertEquals(movie.ALREADY_ON_THE_LIST, movie.addActor(actor));
    }

    @Test
    public void removeActorFromTheListReturnText(){

        assertEquals(movie.REMOVED, movie.deleteActor(actor));
    }

    @Test
    public void removeMovieNotPresentOnTheListReturnText(){
        assertEquals(actor.REMOVED, actor.removeMovie(movie));
    }
}