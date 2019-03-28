package Task_1_and_2;

import javax.lang.model.SourceVersion;
import java.util.Map;
import java.util.TreeMap;

//класс утилит для обработки текстовых данных:заполнение мапы и подготовка итоговой строки для записи
public class KeyWordCounter {
    private Map<String, Integer> keyMap = new TreeMap<>();

    //сравниваем слово со списком ключевых Java-слов и заполняем мапу вхождениями ключевых слов
    public void addKeysToMap(String[] stringArr){
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> item : keyMap.entrySet()) {
            sb.append("Ключевое слово: ").append(item.getKey()).append(", число вхождений: ").append(item.getValue()).append("\n");
        }
        return sb.toString();
    }

}
