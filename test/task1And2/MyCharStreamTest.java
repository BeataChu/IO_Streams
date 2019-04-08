package task1And2;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static java.io.File.createTempFile;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class MyCharStreamTest {
    File tempFile;
    MyCharStream charStream;
    String filePrefix = "inputFile";
    String fileSuffix = ".tmp";
    BufferedWriter bw;
    String expectedString = "public static String readFileName throws IOExceptio";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        tempFile = createTempFile(filePrefix, fileSuffix);
        charStream = new MyCharStream();

    }

    @After
    public void tearDown() throws Exception {

        tempFile.deleteOnExit();
    }

    @Test
    public void ReadStringAndGetArrayOfAllWords() throws Exception{
        bw = new BufferedWriter(new FileWriter(tempFile));
        String[] expected = expectedString.split("\\s*(\\s|,|;|\\.)\\s*");
        bw.write(expectedString);
        bw.close();
        assertArrayEquals(expected, charStream.readText(tempFile.getAbsolutePath()));
    }

    //ВОТ ЭТОТ ТЕСТ НЕ РАБОТАЕТ :(
    @Test
    public void ifReadFileNameIsWrongThrowFNFException() throws FileNotFoundException {
        tempFile.deleteOnExit();
        expectedException.expect(FileNotFoundException.class);
        charStream.readText(tempFile.getAbsolutePath());

    }

    @Test
    public void writeToAnExistingFile() throws IOException{
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        charStream.writeKeysToFile(tempFile.getAbsolutePath(), expectedString);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        assertEquals("Файл для записи существует. Файл записан", buffer.toString());
        buffer.close();
    }

    @Test
    public void writeToANonexistingFile() throws IOException{
        tempFile.delete();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        charStream.writeKeysToFile(tempFile.getAbsolutePath(), expectedString);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        assertEquals("Был создан новый файл для записи. Файл записан", buffer.toString());
        buffer.close();
    }

    @Test
    public void writeEmptyTextToFile() throws IOException{
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        charStream.writeKeysToFile(tempFile.getAbsolutePath(), "");
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        assertEquals("Файл для записи существует. Файл записан", buffer.toString());
        buffer.close();
    }
}