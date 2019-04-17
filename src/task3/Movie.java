package task3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/* класс фильмов */

public class Movie implements Serializable {
    private String name;
    private Set<Actor> cast;
    private int yearOfRelease;

    public Movie(String name, int yearOfRelease){
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        cast = new HashSet<>();
    }

    public boolean addActor(Actor actor) {
        return  cast.add(actor);
    }

    public boolean removeActor(Actor actor){
        return cast.remove(actor);
    }

    public Set<Actor> getCast() {
        return new HashSet<>(cast);
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getName() {
        return name;
    }

    //вдруг поменялся перевод или что-нибудь еще случилось
    public void changeMovieName(String name){
        this.name = name;
    }

    public String toString(){
        return "Movie name: " + name + ", year: " + yearOfRelease;
    }
}