package Task_1_and_2;

import java.io.*;

/* класс с символьными потоками */
public class MyCharStream implements MyStream {
    @Override
    public String[] readText(String inputFile) {
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

    @Override
    public void writeKeysToFile(String filename, String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(text);
        } catch (IOException ex) {
            System.out.println("Ну вот, записать не получилось. Попробуй еще раз");
        }
        System.out.println("Файл записан");

    }
}
