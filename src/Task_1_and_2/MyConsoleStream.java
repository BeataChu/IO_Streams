package Task_1_and_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* класс для работы с консолью - дополнительный. Создавался для проверки эффективности такой структуры объекта */
public class MyConsoleStream implements MyStream {
    @Override
    public String[] readText(String inputFile) {
        List<String> wordsList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String line = reader.readLine();
                if (line.isEmpty()) break;
                wordsList.add(line);
            }
        } catch (IOException ex) {
            System.out.println("Ошибка чтения с консоли");
        }
        return wordsList.toArray(new String[wordsList.size()]);
    }

        @Override
        public void writeKeysToFile (String filename, String text){
            System.out.printf(text);
        }

}
