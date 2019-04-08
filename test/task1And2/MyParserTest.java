package task1And2;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static java.io.File.createTempFile;
import static org.junit.Assert.assertEquals;

public class MyParserTest {
    File tempFile;
    String filePrefix = "inputFile1";
    String fileSuffix = ".tmp";


    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        tempFile = createTempFile(filePrefix, fileSuffix);

    }

    @After
    public void tearDown() throws Exception {
        tempFile.deleteOnExit();
    }

    @Test
    public void parseIfMyStreamIsNullThrowNPException() {
        expectedException.expect(NullPointerException.class);
        MyParser.parse(System.in,null);
    }

    @Test
    public void parseIfUserInputStreamIsNullThrowNPException() {
        expectedException.expect(NullPointerException.class);
        MyParser.parse(null,new MyCharStream());
    }

    @Test
    public void IfNoKeysPrintText() throws IOException {

        String fileAddress = tempFile.getAbsolutePath().toString() + "\r\n";
        String inputString = fileAddress + fileAddress;
        InputStream is = new ByteArrayInputStream(inputString.getBytes());

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer));
        MyParser.parse(is, new MyCharStream());

        String[] outputLines = buffer.toString().split("\\r?\\n");

        assertEquals(MyParser.NO_KEY_WORDS, outputLines[outputLines.length - 1]);
            buffer.close();

    }
}