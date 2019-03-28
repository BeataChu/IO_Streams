package Task_1_and_2;

public interface MyStream {
    //читаем содержимое файла и переводим его в массив строк
    String[] readText(String inputFile);

    //записываем в файл пары ключ-значение в виде строк
    void writeKeysToFile(String filename, String text);
}

