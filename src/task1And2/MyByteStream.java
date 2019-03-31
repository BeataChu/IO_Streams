package task1And2;

import java.io.*;

/*класс с байтовыми потоками */
public class MyByteStream implements MyStream {
    @Override
    public String[] readText(String inputFile) {
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

    @Override
    public void writeKeysToFile(String filename, String text) {
        try {
            File myFile = new File(filename);
            myFile.createNewFile();
        } catch (IOException ex) {
            System.out.println("Неправильное имя файла.");
        }
        try (FileOutputStream fos = new FileOutputStream(filename)) {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        } catch (IOException ex) {
            System.out.println("Ну вот, записать не получилось. Попробуй еще раз.");
        }
        System.out.println("Файл записан");

    }
}
