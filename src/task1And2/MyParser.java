package task1And2;

import java.io.IOException;

/* класс для запуска работы потоков */
public class MyParser {
    private MyParser(){

    }

    public static void parse(MyStream stream) {
        if (stream == null){
            throw new NullPointerException("Передан пустой объект");
        }
        KeyWordCounter data = new KeyWordCounter();
        System.out.println("Сейчас мы будем считывать и записывать файл.");
        String inputFile = null;
        try {
            inputFile = ConsoleUtilities.readFileName("Введите имя файла для чтения:");
            String outputFile = ConsoleUtilities.readFileName("Введите имя файла для записи:");
            String[] words = stream.readText(inputFile);
            data.addKeysToMap(words);
            String result = data.toString();

            if (result.length() < 1) {
                System.out.println("В указанном файле нет ключевых слов Java. Попробуй указать другой файл для чтения");
            } else {
                stream.writeKeysToFile(outputFile, result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
