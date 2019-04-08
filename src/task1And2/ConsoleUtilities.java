package task1And2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


//класс для чтения файловых имен
public class ConsoleUtilities {

    InputStream in;
    BufferedReader reader;

    public ConsoleUtilities(InputStream in) {
        this.in = in;
        reader = new BufferedReader(new InputStreamReader(in));
    }

    //читаем имя файла
    public String readFileName(String prompt) throws IOException {
        boolean ok = true;

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
