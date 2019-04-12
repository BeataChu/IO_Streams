package task3;

import task1And2.ConsoleUtilities;

import java.io.*;

public class MainClass {
    public static void main(String[] args) throws Exception {

        MovieCollection myCollection = MovieCollection.getInstance();

        //обращаемся к объекту из другого пакета - ввод имени файла был реализован ранее
        ConsoleUtilities consUtil = new ConsoleUtilities(System.in);
        String prompt = "Введите имя файла для сериализации";
        String filename = consUtil.readFileName(prompt);

        //создаем файл-заготовку
        try {
            File myFile = new File(filename);
            boolean wasCreated = myFile.createNewFile();
            String creationResult = (wasCreated)? "Был создан новый файл." : "Файл уже существует.";
            System.out.print(creationResult);
        } catch (IOException ex) {
            System.out.println("Неправильное имя файла.");
        }

        //сериализуем и десериализуем
        Serializer.serializeObj(filename, myCollection);
        myCollection = Serializer.deserializeObj(filename);

        //здесь меняем коллекцию

        //опять сериализуем
        Serializer.serializeObj(filename, myCollection);

    }
}
