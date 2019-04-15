package task3;

import org.junit.*;

import java.io.File;

import static java.io.File.createTempFile;
import static org.junit.Assert.*;

public class SerializerTest {
    String filePrefix = "inputFile1";
    String fileSuffix = ".tmp";
    File tempFile;
    final String NAME1 = "Johnny";
    final String LASTNAME1 = "Depp";
    final String NAME2 = "Helena Bonham";
    final String LASTNAME2 = "Carter";
    final String MOVIE_NAME_1 = "Charlie and the Chocolate Factory";
    final String MOVIE_NAME_2 = "What's Eating Gilbert Grape";
    final int YEAR1 = 2005;
    final int YEAR2 = 1993;
    IMDBCollection imdb;

    @Before
    public void setUp() throws Exception {
        tempFile = createTempFile(filePrefix, fileSuffix);
        imdb = IMDBCollection.getInstance();
        Actor actor1 = new Actor(NAME1, LASTNAME1);
        Actor actor2 = new Actor(NAME2, LASTNAME2);
        Movie movie1 = new Movie(MOVIE_NAME_1, YEAR1);
        Movie movie2 = new Movie(MOVIE_NAME_2, YEAR2);
        imdb.addMovie(movie1);
        imdb.addMovie(movie2);
        imdb.addActor(actor1);
        imdb.addActor(actor2);
        imdb.addActorToMovieByMovieName(MOVIE_NAME_1, NAME1, LASTNAME1);
        imdb.addActorToMovieByMovieName(MOVIE_NAME_2, NAME1, LASTNAME1);
        imdb.addActorToMovieByMovieName(MOVIE_NAME_1, NAME2, LASTNAME2);
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

        String expectedString = String.format("\rMovie name: %s, year: %d\n\tActor's name: %s %s\n\rMovie name: %s, year: %d\n\tActor's name: %s %s\n\tActor's name: %s %s\n", MOVIE_NAME_2, YEAR2, NAME1, LASTNAME1, MOVIE_NAME_1, YEAR1, NAME1, LASTNAME1, NAME2, LASTNAME2);
        assertEquals(expectedString, imdb.showCollection());
    }
}