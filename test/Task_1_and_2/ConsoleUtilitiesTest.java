package Task_1_and_2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class ConsoleUtilitiesTest {


    @org.junit.Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void readFileName() throws IOException {
        //кладем данные в строку
        StringBuilder sb = new StringBuilder();
        sb.append(" ").append('\n');
        sb.append("C:\\Users\\Беата\\Desktop\\Streams.txt").append('\n');
        String data = sb.toString();

        //Оборачиваем строку в класс ByteArrayInputStream
        InputStream is = new ByteArrayInputStream(data.getBytes());

        //подменяем in
        System.setIn(is);



    }



}