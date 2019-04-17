package task3;
/* Сериализация
 Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в главных ролях (один актер мог сниматься
 и в нескольких фильмах). Необходимо написать приложение, позволяющее при запуске восстанавливать коллекцию фильмов,
 позволять ее модифицировать, а по завершении работы приложения –  сохранять (в файл). Для восстановления/сохранения
 коллекции использовать  сериализацию/десериализацию.*/

import java.io.*;

/* Класс для осуществления сериализации-десериализации */

public class Serializer implements Serializable {

    public static void serializeObj(String filename, IMDBCollection imdb) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            imdb.increaseVersion();
            oos.writeObject(imdb);
            System.out.println("Объект был сериализован, версия коллекции: " + imdb.getVersion());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static IMDBCollection deserializeObj(String filename) throws IOException, ClassNotFoundException {
        IMDBCollection imdb = null;
        try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(filename))) {
            imdb = (IMDBCollection) oin.readObject();
            System.out.println("Объект был десериализован, версия коллекции: " + imdb.getVersion());
            oin.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return imdb;

    }
}

