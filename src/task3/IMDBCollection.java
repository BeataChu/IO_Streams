package task3;

import java.io.Serializable;
import java.util.*;

/* класс для коллекции фильмов, реализован в виде синглтона */

public class IMDBCollection implements Serializable {

    //поле синглтона, которое позволяет отслеживать версии
    private int version = 0;

    public int getVersion() {
        return version;
    }

    public void increaseVersion() {
        version++;
    }

    //компаратор на основе года выпуска фильма
    Comparator<Movie> comparatorM = Comparator.comparing(obj -> obj.getYearOfRelease());
    Comparator<Actor> comparatorA = Comparator.comparing(obj -> obj.getLastname());
    private Set<Movie> movieCollection = new TreeSet<>(comparatorM);
    private Set<Actor> actorCollection = new TreeSet<>(comparatorA);

    //создаем синглтон
    private static IMDBCollection instance;

    private IMDBCollection() {
    }

    public static IMDBCollection getInstance() {
        if (instance == null) {
            instance = new IMDBCollection();
        }
        return instance;
    }

    public boolean addMovie(Movie movie) {
        return movieCollection.add(movie);
    }

    public boolean addActor(Actor actor) {
        return actorCollection.add(actor);
    }

    public Movie getMovieByMovieName(String movieName) {
        for (Movie movie : movieCollection) {
            if (movie.getName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public Actor getActorByName(String name, String lastName) {
        for (Actor actor : actorCollection) {
            if (actor.getName().equals(name) && actor.getLastname().equals(lastName)) {
                return actor;
            }
        }
        return null;
    }

    public void deleteMovie(String movieName) {
        Movie movie = getMovieByMovieName(movieName);
        if (movie != null) {
            movieCollection.remove(movie);
            for (Actor actor : movie.getCast()) {
                actor.removeMovie(movie);
            }
        }
    }

    public void addActorToMovieByMovieName(String movieName, String name, String lastName) {
        Actor actor = getActorByName(name, lastName);
        Movie movie = getMovieByMovieName(movieName);
        if (movie != null && actor != null) {
            movie.addActor(actor);
            actor.addMovie(movie);
        }
    }


    public void deleteActor(String name, String lastName) {
        Actor actor = getActorByName(name, lastName);
        if (actor != null) {
            actorCollection.remove(actor);
            for (Movie movie : actor.getFilmography()) {
                movie.removeActor(actor);
            }
        }
    }


    public String showCollection() {
        StringBuilder resultString = new StringBuilder();
        for (Movie movie : movieCollection) {
            resultString.append("\r").append(movie).append("\n");
            for (Actor actor : movie.getCast()) {
                resultString.append("\t").append(actor).append("\n");
            }
        }
        return resultString.toString();
    }

    public void clear() {
        movieCollection.clear();
        actorCollection.clear();
    }

    public void removeLinkBetweenActorAndMovie(String name, String lastName, String movieName) {
        Actor actor = getActorByName(name, lastName);
        Movie movie = getMovieByMovieName(movieName);
        if (actor != null && movie != null) {
            movie.removeActor(actor);
            actor.removeMovie(movie);
        }

    }
}




