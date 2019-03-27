package Task_1_and_2;
//комментарий для пул-риквеста
import java.io.*;

/*  Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
Выведите эти слова и их количество в другой файл. Используйте только байтовые потоки ввода-вывода.*/

public class ByteStreams {

    public static void main(String[] args) {
        CommonClass bytes = new CommonClass();
        System.out.println("Сейчас мы будем считывать и записывать файл побайтово.");
        String inputFile = bytes.readFileName("Введите имя файла для чтения:");
        String outputFile = bytes.readFileName("Введите имя файла для записи:");
        String[] words = readText(inputFile);
        bytes.addKeysToMap(words);
        String result = bytes.prepareResultingText();

        if (result.length() < 1) {
            System.out.println("В указанном файле нет ключевых слов Java. Попробуй указать другой файл для чтения");
        } else {
            writeKeysToFile(outputFile, result);
        }
    }

    //читаем содержимое файла и переводим его в массив строк
    public static String[] readText(String inputFile) {
        String bytesToString = "";
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(inputFile))) {
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            int result = bis.read();
            while (result != -1) {
                buf.write((byte) result);
                result = bis.read();
            }
            bytesToString = buf.toString();
            System.out.println ("Текст прочитан");
        } catch (FileNotFoundException e) {
            System.out.println("Я не нашел файл для чтения с таким именем. Попробуйте еще разок");
            System.exit(1);
        } catch (IOException ex) {
            System.out.println("Попытка чтения не удалась.");
        }
        return bytesToString.split("\\s*(\\s|,|;|\\.)\\s*");
    }


    //записываем в файл пары ключ-значение в виде строк
    public static void writeKeysToFile(String filename, String text) {
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println("Ну вот, записать не получилось. Попробуй еще раз");
        }
        System.out.println("Файл записан");
    }
}

