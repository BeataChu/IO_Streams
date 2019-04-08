package task1And2;

import java.io.*;

/*класс с байтовыми потоками */
public class MyByteStream implements MyStream {
    final String NO_SUCH_FILE = "Я не нашел файл для чтения с таким именем. Попробуйте еще разок";
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
            System.out.println(NO_SUCH_FILE);
            System.exit(-1);

        } catch (IOException ex) {
            System.out.println("Попытка чтения не удалась.");
        }
        return bytesToString.split("\\s*(\\s|,|;|\\.)\\s*");

    }

    @Override
    public void writeKeysToFile(String filename, String text) {

        try {
            File myFile = new File(filename);
            boolean wasCreated = myFile.createNewFile();
            String creationResult = (wasCreated)? "Был создан новый файл для записи. " : "Файл для записи существует. ";
            System.out.print(creationResult);
            try (FileOutputStream fos = new FileOutputStream(filename)) {
                byte[] buffer = text.getBytes();
                fos.write(buffer, 0, buffer.length);
            } catch (IOException ex) {
                System.out.println("Попытка записи не удалась. Попробуй еще раз.");
            }
            System.out.print("Файл записан");

        } catch (IOException ex) {
            System.out.println("Неправильное имя файла.");
        }

    }
}
