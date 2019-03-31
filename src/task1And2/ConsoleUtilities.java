package task1And2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//класс для чтения файловых имен
public class ConsoleUtilities {

    private ConsoleUtilities() {

    }

    //читаем имя файла
    public static String readFileName(String prompt) throws IOException {
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
                throw ex;
            }
        } while (!ok);

        return fileName;
    }
}
