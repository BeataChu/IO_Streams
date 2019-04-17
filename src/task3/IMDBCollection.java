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

   
    /*АНЯ, КОМПИЛЯТОР ПРИ СЕРИАЛИЗАЦИИ РУГАЕТСЯ В ТЕСТЕ НА ЭТОМ МОМЕНТЕ - Я НЕ ЗНАЮ, КАК СДЕЛАТЬ СЕРИАЛИЗУЕМЫЙ КОМПАРАТОР,
    МНЕ САМ СИНТАКСИС НЕПОНЯТЕН, так что я пока сделаю сеты несортированными


    ВОТ ТАК БЫЛО РАНЬШЕ:
    создаем сортированные сеты на основе компараторов

    Comparator<Movie> comparatorM = Comparator.comparing(obj -> obj.getYearOfRelease());
    Comparator<Actor> comparatorA = Comparator.comparing(obj -> obj.getLastname());
    private Set<Movie> movieCollection = new TreeSet<>(comparatorM);
    private Set<Actor> actorCollection = new TreeSet<>(comparatorA);
    */

    private Set<Movie> movieCollection = new HashSet<>();
    private Set<Actor> actorCollection = new HashSet<>();

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

    // добавляем фильм в коллекцию фильмов
    public boolean addMovie(Movie movie) {
        return movieCollection.add(movie);
    }

    // добавляем актера в коллекцию актеров
    public boolean addActor(Actor actor) {
        return actorCollection.add(actor);
    }

    //возвращаем экзмепляр фильма по его названию
    public Movie getMovieByMovieName(String movieName) {
        for (Movie movie : movieCollection) {
            if (movie.getName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    //возвращаем экземпляр актера по имени-фамилии
    public Actor getActorByName(String name, String lastName) {
        for (Actor actor : actorCollection) {
            if (actor.getName().equals(name) && actor.getLastname().equals(lastName)) {
                return actor;
            }
        }
        return null;
    }

    //удаляем фильм из коллекции фильмов и из фильмографии актеров
    public void deleteMovie(String movieName) {
        Movie movie = getMovieByMovieName(movieName);
        if (movie != null) {
            movieCollection.remove(movie);
            for (Actor actor : movie.getCast()) {
                actor.removeMovie(movie);
            }
        }
    }

    //добавляем экзмепляр актера в актерский состав фильма по имени-фамилии
    public void addActorToMovieByMovieName(String movieName, String name, String lastName) {
        Actor actor = getActorByName(name, lastName);
        Movie movie = getMovieByMovieName(movieName);
        if (movie != null && actor != null) {
            movie.addActor(actor);
            actor.addMovie(movie);
        }
    }

    //удаляем актера из актерской коллекции и из акт.состава фильма
    public void deleteActor(String name, String lastName) {
        Actor actor = getActorByName(name, lastName);
        if (actor != null) {
            actorCollection.remove(actor);
            for (Movie movie : actor.getFilmography()) {
                movie.removeActor(actor);
            }
        }
    }

    //возвращаем коллекцию полностью в текстовом формате
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

    //удаляем актера из акт.состава фильма и фильм из фильмографии актера (не удаляя сами объекты)
    public void removeLinkBetweenActorAndMovie(String name, String lastName, String movieName) {
        Actor actor = getActorByName(name, lastName);
        Movie movie = getMovieByMovieName(movieName);
        if (actor != null && movie != null) {
            movie.removeActor(actor);
            actor.removeMovie(movie);
        }
    }

    //сервисные методы, которые возвращают размер сетов
    public int getNumberOfMovies(){
        return movieCollection.size();
    }

    public int getNumberOfActors(){
        return actorCollection.size();
    }
}




