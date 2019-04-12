package task3;

import java.io.Serializable;
import java.util.*;

/* класс для коллекции фильмов, реализован в виде синглтона */

public class MovieCollection implements Serializable {
    //поле синглтона, которое позволяет отслеживать версии
    private int version = 0;

    public int getVersion() {
        return version;
    }

    public void increaseVersion() {
        version++;
    }

    //компаратор на основе года выпуска фильма
    Comparator<Movie> comparator = Comparator.comparing(obj -> obj.getYearOfRelease());
    Set<Movie> collection = new TreeSet<>(comparator);

    //создаем синглтон
    private static MovieCollection instance;
    private MovieCollection() {}
    public static MovieCollection getInstance(){
        if (instance == null){
            instance = new MovieCollection();
        }
        return instance;
    }


    public Set<Movie> getCollection() {
        return collection;
    }

    public void addMovie(Movie movie){
        collection.add(movie);
    }

    public void deleteMovie(Movie movie){
                collection.remove(movie);
    }

    public Set<Actor> getSetOfAllActors(){
        Set<Actor> setOfAllActors = new HashSet<>();
        for (Movie anyMovie : collection){
            setOfAllActors.addAll(anyMovie.getCast());
        }
        return setOfAllActors;
    }





}




