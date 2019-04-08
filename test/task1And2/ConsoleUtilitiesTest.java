package task1And2;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ConsoleUtilitiesTest {

    final String INPUT = "SomeRandomFileName";
    final String PROMPT = "Введите имя файла для чтения - тест:";
    final String CRLF = "\n";
    final String CONSOLE_INPUT = INPUT+CRLF;
    InputStream in;
    ConsoleUtilities consoleUtilities;

    @Rule
    public ExpectedException expectedNPException = ExpectedException.none();
    @Rule
    public ExpectedException expectedIOException = ExpectedException.none();

    @Test
    public void testReadRandomName() throws IOException {
        in = new ByteArrayInputStream(CONSOLE_INPUT.getBytes());
        consoleUtilities = new ConsoleUtilities(in);
        assertEquals(INPUT, consoleUtilities.readFileName(PROMPT));
    }

    @Test
    public void testReadEmptyName() throws IOException {
        in = new ByteArrayInputStream((CRLF + CONSOLE_INPUT).getBytes());
        consoleUtilities = new ConsoleUtilities(in);
        assertEquals(INPUT, consoleUtilities.readFileName(PROMPT));
    }

    @Test
    public void testIfInputStreamIsNullThrowNPException() throws IOException {
        expectedNPException.expect(NullPointerException.class);
        consoleUtilities = new ConsoleUtilities(null);
        assertEquals(INPUT, consoleUtilities.readFileName(PROMPT));
    }

    @Test
    public void testIfInputStreamIsClosedThrowIOException() throws IOException{
        expectedIOException.expect(IOException.class);
        in = System.in;
        consoleUtilities = new ConsoleUtilities((in));
        in.close();

        assertEquals(INPUT, consoleUtilities.readFileName(PROMPT));
    }
}