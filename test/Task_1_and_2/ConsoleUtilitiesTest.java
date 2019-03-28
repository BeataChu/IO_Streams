package Task_1_and_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static org.junit.Assert.*;

public class ConsoleUtilitiesTest {


    final String input = "SomeRandomFileName";
    final String prompt = "Введите имя файла для чтения - тест:";
    final String crlf = "\n";
    final String consoleInput = input+crlf;

    @Test
    public void testReadRandomName(){
        InputStream is = new ByteArrayInputStream(consoleInput.getBytes());
        System.setIn(is);
        assertEquals(input, ConsoleUtilities.readFileName(prompt));
    }

    @Test
    public void testReadEmptyName() throws IOException {
        InputStream is = new ByteArrayInputStream((crlf + consoleInput).getBytes());
        System.setIn(is);
        assertEquals(input, ConsoleUtilities.readFileName(prompt));
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void testException() throws IOException {
        expectedException.expect(NullPointerException.class);

        InputStream is = new ByteArrayInputStream(consoleInput.getBytes());
        System.setIn(null);
        assertEquals(input, ConsoleUtilities.readFileName(prompt));
    }
}