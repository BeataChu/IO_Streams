package task3;

//Этот пока  в разработке

import task1And2.ConsoleUtilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

public class SerialConsoleUtilities extends ConsoleUtilities {
    public SerialConsoleUtilities(InputStream in){
        super(in);
    }

    MovieCollection movieCollection = MovieCollection.getInstance();

    //data input: readLine throws exception, myReadLine catches it
    public String myReadLine(){
        String answer = "";
        try {
            answer = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }


    public void addMovie() throws IOException {
        System.out.println("Введите название фильма");
        String movieName = reader.readLine();
        System.out.println("Введите год выпуска фильма");
        int yearOfRelease = Integer.parseInt(reader.readLine());
        movieCollection.addMovie(new Movie(movieName, yearOfRelease));
    }

    public void deleteMovie() throws IOException{
        System.out.println("Введите название фильма");
        String movieName = reader.readLine();
        movieCollection.deleteMovie(movieName);
    }

    public void addActor() throws IOException{
        System.out.println("Введитя имя актера/актрисы");
        String name = reader.readLine();
        System.out.println("Введите фамилию актера/актрисы");
        String lastName = reader.readLine();
        Actor actor = new Actor(name, lastName);
        System.out.println("Введите название фильмов, в которых актер снимался");

        while (true){
            String movieName = reader.readLine();
            String movieResult = movieCollection.addActorToMovieByMovieName(movieName, actor);
            System.out.println(movieResult);
        }
    }

    public void deleteActor() throws IOException{

    }

    public void getCollection(){

    }


}
