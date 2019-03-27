package Task_1_and_2;

import javax.lang.model.SourceVersion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
//комментарий для пул-риквеста
public class CommonClass {
    private Map<String, Integer> keyMap = new TreeMap<>();

    //считываем имя файла
    public String readFileName(String prompt) {
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
                }
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
                ok = false;
            }
        } while (!ok);
        return fileName;
    }

    //сравниваем слово со списком ключевых Java-слов и заполняем мапу вхождениями ключевых слов
    public void addKeysToMap (String[] stringArr){
        for (String s : stringArr) {
            if (SourceVersion.isKeyword(s)) {
                if (keyMap.containsKey(s)) {
                    keyMap.put(s, keyMap.get(s) + 1);
                } else {
                    keyMap.put(s, 1);
                }
            }
        }
    }

    public String prepareResultingText() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> item : keyMap.entrySet()) {
            sb.append("Ключевое слово: ").append(item.getKey()).append(", число вхождений: ").append(item.getValue()).append("\n");
        }
        return sb.toString();
    }

}
