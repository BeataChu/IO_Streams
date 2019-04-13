package task3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

/* класс для коллекции фильмов, реализован в виде синглтона */

public class MovieCollection implements Serializable {
    Movie movie;
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
    Set<Movie> movieCollection = new TreeSet<>(comparatorM);
    Set<Actor> actorCollection = new TreeSet<>(comparatorA);

    //создаем синглтон
    private static MovieCollection instance;
    private MovieCollection() {}
    public static MovieCollection getInstance(){
        if (instance == null){
            instance = new MovieCollection();
        }
        return instance;
    }

    public Set<Movie> getMovieCollection() {
        return movieCollection;
    }

    public Set<Actor> getActorCollection() {
        return actorCollection;
    }

    public void addMovie(Movie movie){
       movieCollection.add(movie);
    }

    public void deleteMovie(String movieName){
        Iterator<Movie> iter = movieCollection.iterator();
        while(iter.hasNext()){
            Movie iterMovie = iter.next();
            if (iterMovie.getName().equals(movieName)){
                for (Actor actor: iterMovie.getCast()) {
                    actor.removeMovie(iterMovie);
                }
                iter.remove();
                break;
            }
        }
    }

    public void addActorToMovieByMovieName(String movieName, Actor actor) {
        for (Movie movie : movieCollection) {
            if (movie.getName().equals(movieName)) {
                movie.addActor(actor);
                actor.addMovie(movie);
                break;
            }
        }
    }

    public void deleteActor(String name, String lastName) {
        Iterator<Actor> iter = actorCollection.iterator();
        while(iter.hasNext()){
            Actor iterActor = iter.next();
            if (iterActor.getName().equals(name) && iterActor.getLastname().equals(lastName)){
                for (Movie movie : iterActor.getFilmography()) {
                    movie.deleteActor(iterActor);
                }
                iter.remove();
                break;
            }
        }
    }


    public String showCollection(){
        StringBuilder resultString = new StringBuilder();
        for (Movie movie : movieCollection){
            resultString.append("\r").append(movie).append("\n");
            for (Actor actor : movie.getCast()){
                resultString.append("\t").append(actor).append("\n");
            }
        }
        return resultString.toString();
    }



}




