package task3;
/* Сериализация
 Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в главных ролях (один актер мог сниматься
 и в нескольких фильмах). Необходимо написать приложение, позволяющее при запуске восстанавливать коллекцию фильмов,
 позволять ее модифицировать, а по завершении работы приложения –  сохранять (в файл). Для восстановления/сохранения
 коллекции использовать  сериализацию/десериализацию.*/

import java.io.*;
import java.util.Set;

/* Класс для осуществления сериализации-десериализации */

public class Serializer {

    public static void serializeObj(String filename, MovieCollection movieCollection) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
        movieCollection.increaseVersion();
        oos.writeObject(movieCollection);
        oos.flush();
        oos.close();
        System.out.print("Объект был сериализован, версия коллекции: " + movieCollection.getVersion());
    }

    public static MovieCollection deserializeObj(String filename) throws IOException, ClassNotFoundException {
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(filename));
        MovieCollection movieCollection = (MovieCollection) oin.readObject();
        System.out.print("Объект был десериализован, версия коллекции: " + movieCollection.getVersion());
        oin.close();
        return movieCollection;

    }
}

