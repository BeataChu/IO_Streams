package task3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/* класс актеров */

public class Actor implements Serializable {
    private String name;
    private String lastname;
    private Set<Movie> filmography;

    public Actor (String name, String lastname){
        this.name = name;
        this.lastname = lastname;
        filmography = new HashSet<Movie>();
    }

    //мало ли, как в случае с братьями-сестрами Вачовски: сменил пол и поменял имя, был Эндрю - стал Лилли
    public void changeName (String newName){
        this.name = newName;
    }

    //тут все гораздо прозаичнее: замуж, после первой роли актер взял псевдоним из-за неблагозвучной фамилии и т.п.
    public void changeLastname(String newLastname){
        this.lastname = newLastname;
    }

    public boolean addMovie (Movie movie){
        return filmography.add(movie);
    }

    public boolean removeMovie (Movie movie){
        return filmography.remove(movie);
    }

    public String getName(){
        return name;
    }

    public String getLastname(){
        return lastname;
    }

    public Set<Movie> getFilmography() {
        return new HashSet<>(filmography);
    }

    public String toString(){
        return "Actor's name: " + name + " " + lastname;
    }

}



