package task1And2;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* класс для запуска работы потоков */
public class MyParser {
    final static String NO_KEY_WORDS = "В указанном файле нет ключевых слов Java. Попробуй указать другой файл для чтения";

    private MyParser(){
    }

    public static void parse(InputStream in, MyStream stream) {

        ConsoleUtilities consoleUtilities = new ConsoleUtilities(in);
        if (stream == null){
            throw new NullPointerException("Передан пустой объект");
        }
        KeyWordCounter data = new KeyWordCounter();
        System.out.println("Сейчас мы будем считывать и записывать файл.");

        String inputFile = null;

        try {
            inputFile = consoleUtilities.readFileName("Введите имя файла для чтения:");
            String outputFile = consoleUtilities.readFileName("Введите имя файла для записи:");
            String[] words = stream.readText(inputFile);
            Map<String,Integer> keyMap = data.addKeysToMap(words);
            String result = data.toString(keyMap);

            if (result.length() < 1) {
                System.out.println(NO_KEY_WORDS);
            } else {
                stream.writeKeysToFile(outputFile, result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
