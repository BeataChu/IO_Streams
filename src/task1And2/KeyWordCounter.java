package task1And2;

import javax.lang.model.SourceVersion;
import java.util.Map;
import java.util.TreeMap;

//класс утилит для обработки текстовых данных:заполнение мапы и подготовка итоговой строки для записи
public class KeyWordCounter {

    //сравниваем слово со списком ключевых Java-слов и заполняем мапу вхождениями ключевых слов
    public Map<String, Integer> addKeysToMap(String[] stringArr){
        Map<String, Integer> keyMap = new TreeMap<>();
        for (String word : stringArr) {
            if (SourceVersion.isKeyword(word)) {
                if (keyMap.containsKey(word)) {
                    keyMap.put(word, keyMap.get(word) + 1);
                } else {
                    keyMap.put(word, 1);
                }
            }
        }
        return keyMap;
    }

    public String toString(Map<String, Integer> keyMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> item : keyMap.entrySet()) {
            sb.append("Ключевое слово: ").append(item.getKey()).append(", число вхождений: ");
            sb.append(item.getValue()).append("\n");
        }
        return sb.toString();
    }
}
