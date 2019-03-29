package Task_1_and_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class KeyWordCounterTest {
    Map<String, Integer> testKeyMap = new TreeMap<>();
    KeyWordCounter myKeyCounter;

    @Before
    public void setUp() throws Exception {
        myKeyCounter = new KeyWordCounter();
    }

    @After
    public void tearDown() throws Exception {
        testKeyMap = null;
    }

    @Test
    public void testAddKeysToMap() {
        String[] arr = {"a", "b", "while", "while", "void"};
        testKeyMap.put("void", 1);
        testKeyMap.put("while", 2);
        myKeyCounter.addKeysToMap(arr);
        assertEquals(testKeyMap, myKeyCounter.getMap());

    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    public void testAddKeysToMapFromNullArr() {
        expectedException.expect(NullPointerException.class);
        String[] arr = null;
        myKeyCounter.addKeysToMap(arr);
        assertNull(("Словарь должен быть пустым"), myKeyCounter.getMap());
    }

    @Test
    public void testAddNoKeysToMap() {
        String[] arr = {"a", "b", "c"};
        myKeyCounter.addKeysToMap(arr);
        assertEquals(testKeyMap, myKeyCounter.getMap());
    }

    @Test
    public void testToString() {
        String expected = "Ключевое слово: void, число вхождений: 1\nКлючевое слово: while, число вхождений: 2\n";
        String[] arr = {"void", "while", "while"};
        myKeyCounter.addKeysToMap(arr);
        assertEquals(expected, myKeyCounter.toString());
    }

    @Test
    public void testToStringNoKeyWords() {
        String expected = "";
        String[] arr = {"a", "b", "c"};
        myKeyCounter.addKeysToMap(arr);
        assertEquals(expected, myKeyCounter.toString());
    }


}