package Task_1_and_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static org.junit.Assert.*;

public class ConsoleUtilitiesTest {


    final String INPUT = "SomeRandomFileName";
    final String PROMPT = "Введите имя файла для чтения - тест:";
    final String CRLF = "\n";
    final String CONSOLE_INPUT = INPUT+CRLF;

    @Test
    public void testReadRandomName() throws IOException {
        InputStream is = new ByteArrayInputStream(CONSOLE_INPUT.getBytes());
        System.setIn(is);
        assertEquals(INPUT, ConsoleUtilities.readFileName(PROMPT));
    }

    @Test
    public void testReadEmptyName() throws IOException {
        InputStream is = new ByteArrayInputStream((CRLF + CONSOLE_INPUT).getBytes());
        System.setIn(is);
        assertEquals(INPUT, ConsoleUtilities.readFileName(PROMPT));
    }

    @Rule
    public ExpectedException expectedNPException = ExpectedException.none();
    @Test
    public void testNPException() throws IOException {
        expectedNPException.expect(NullPointerException.class);

        InputStream is = new ByteArrayInputStream(CONSOLE_INPUT.getBytes());
        System.setIn(null);
        assertEquals(INPUT, ConsoleUtilities.readFileName(PROMPT));
    }

    @Rule
    public ExpectedException expectedIOException = ExpectedException.none();
    @Test
    public void testIOException() throws IOException{
        expectedIOException.expect(IOException.class);
        System.in.close();

        assertEquals(INPUT, ConsoleUtilities.readFileName(PROMPT));
    }
}