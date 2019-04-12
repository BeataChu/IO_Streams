package task3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/* класс фильмов */

public class Movie implements Serializable {
    private String name;
    private Set<Actor> cast;
    private int yearOfRelease;

    final String ADDED = "Актер" +
            " добавлен в список";
    final String ALREADY_ON_THE_LIST = "Актер уже есть в списке";
    final String REMOVED = "Актер удален из списка";
    final String NOT_ON_THE_LIST = "Актера не было в списке";

    public Movie(String name, int yearOfRelease){
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        cast = new HashSet<>();
    }

    public String addActor(Actor actor){
        return cast.add(actor) ? ADDED : ALREADY_ON_THE_LIST;
    }

    public String deleteActor(Actor actor){
        return cast.remove(actor) ? REMOVED : NOT_ON_THE_LIST;
    }

    public Set<Actor> getCast() {
        return cast;
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
}

