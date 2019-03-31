package task1And2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import static java.io.File.createTempFile;
import static org.junit.Assert.*;

public class MyByteStreamTest {
    File tempFile;
    MyByteStream byteStream;
    String filePrefix = "inputFile";
    String fileSuffix = ".tmp";
    BufferedWriter bw;

    @Before
    public void setUp() throws Exception {
        tempFile = createTempFile(filePrefix, fileSuffix);
        byteStream = new MyByteStream();

    }

    @After
    public void tearDown() throws Exception {
        bw.close();
        tempFile.deleteOnExit();
    }

    @Test
    public void readText() throws Exception{
        bw = new BufferedWriter(new FileWriter(tempFile));
        String expectedString = "public static String readFileName throws IOException";
        String[] expected = expectedString.split("\\s*(\\s|,|;|\\.)\\s*");
        bw.write(expectedString);
        bw.close();
        assertArrayEquals(expected, byteStream.readText(tempFile.getAbsolutePath()));
    }

    @Test
    public void writeKeysToFile() {


    }
}