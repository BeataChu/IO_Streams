package task3;

import org.junit.*;

import java.io.File;

import static java.io.File.createTempFile;
import static org.junit.Assert.*;

public class SerializerTest {
    String filePrefix = "inputFile1";
    String fileSuffix = ".tmp";
    File tempFile;
    String name1 = "Johnny";
    String lastname1 = "Depp ";
    String name2 = "Helena Bonham";
    String lastname2 = "Carter";
    String movieName1 = "Charlie and the Chocolate Factory";
    String movieName2 = "What's Eating Gilbert Grape";
    int year1 = 2005;
    int year2 = 1993;
    IMDBCollection imdb;
    Actor actor1;

    @Before
    public void setUp() throws Exception {
        tempFile = createTempFile(filePrefix, fileSuffix);
        imdb = IMDBCollection.getInstance();
        actor1 = new Actor(name1, lastname1);
        Actor actor2 = new Actor(name2, lastname2);
        Movie movie1 = new Movie(movieName1, year1);
        Movie movie2 = new Movie(movieName2, year2);
        imdb.addMovie(movie1);
        imdb.addMovie(movie2);
        imdb.addActor(actor1);
        imdb.addActor(actor2);
        imdb.addActorToMovieByMovieName(movieName1, name1, lastname1);
        imdb.addActorToMovieByMovieName(movieName2, name1, lastname1);
        imdb.addActorToMovieByMovieName(movieName1, name2, lastname2);
    }

    @After
    public void tearDown() throws Exception {
       tempFile.deleteOnExit();
    }

    @Test
    public void testSerialization() throws Exception
    {
            Serializer.serializeObj(tempFile.getAbsolutePath(), imdb);
            imdb = Serializer.deserializeObj(tempFile.getAbsolutePath());
            /*непонятно, что с чем сравнивать. До этого я сравнивала по showCollection, но поскольку
            теперь это у меня не сортированный список, вывод фильмов и актеров происходит в случайном
            порядке
             */

            assertEquals(actor1.toString(), imdb.getActorByName(name1, lastname1).toString());
    }
}