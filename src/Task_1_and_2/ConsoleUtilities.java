package Task_1_and_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//читаем имя файла
public class ConsoleUtilities {

    //класс для чтения файловых имен
    public static String readFileName(String prompt) {
        boolean ok = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        do {
            try {
                System.out.println(prompt);
                fileName = reader.readLine();
                if (fileName.isEmpty()){
                    System.out.print("Имя файла не может быть пустым. ");
                    ok = false;
                } else {
                    ok = true;
                }
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
                ok = false;
            }
        } while (!ok);

        return fileName;
    }
}
