package Task_1_and_2;
//комментарий для пул-риквеста
import java.io.*;

/*Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
Выведите эти слова и их количество в другой файл. Используйте только символьные потоки ввода-вывода.*/

public class CharacterStreams {
    public static void main(String[] args) {
        CommonClass letters = new CommonClass();
        System.out.println("Сейчас мы будем считывать и записывать файл посимвольно.");
        String inputFile = letters.readFileName("Введите имя файла для чтения:");
        String outputFile = letters.readFileName("Введите имя файла для записи:");
        String[] words = readText(inputFile);
        letters.addKeysToMap(words);
        String result = letters.prepareResultingText();

        if (result.length() < 1) {
            System.out.println("В указанном файле нет ключевых слов Java. Попробуй указать другой файл для чтения");
        } else {
            writeKeysToFile(outputFile, result);
        }
    }

    //читаем содержимое файла и переводим его в массив строк
    public static String[] readText(String inputFile) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line ;
            while ((line = br.readLine())!= null) {
                result.append(line);
            }
            System.out.println("-------------------\nТекст прочитан:\n-------------------\n");
        } catch (FileNotFoundException e) {
            System.out.println("Я не нашел файл для чтения с таким именем. Попробуй еще разок");
        } catch (IOException ex) {
            System.out.println("Попытка чтения не удалась.");
        }
        return result.toString().split("\\s*(\\s|,|;|\\.)\\s*");
    }


    //записываем в файл пары ключ-значение в виде строк
    public static void writeKeysToFile(String filename, String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(text);
        } catch (IOException ex) {
            System.out.println("Ну вот, записать не получилось. Попробуй еще раз");
        }
        System.out.println("Файл записан");
    }
}
