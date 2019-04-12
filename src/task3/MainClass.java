package task3;

//Этот класс пока в разработке
import task1And2.ConsoleUtilities;

import java.io.*;

public class MainClass {
    public static void main(String[] args) throws Exception {
        MovieCollection movieCollection = MovieCollection.getInstance();
        SerialConsoleUtilities utilities = new SerialConsoleUtilities(System.in);

        String answer ="";
        do {
            showMenu();
            answer = utilities.myReadLine();

            switch (answer) {
                case ("1") :
                    utilities.addMovie();
                    break;
                case ("2") :
                    utilities.addActor();
                    break;
                case ("3") :
                    utilities.deleteMovie();
                    break;
                case ("4") :
                    utilities.deleteActor();
                case ("5") :
                    utilities.getCollection();
            }

        } while (!answer.equals("0"));
    }

    private static void showMenu(){
        System.out.println("Пожалуйста, выберите действие:");
        System.out.println("1 - добавить фильм");
        System.out.println("2 - добавить актера");
        System.out.println("3 - удалить фильм");
        System.out.println("4 - удалить актера");
        System.out.println("5 - показать всю коллекцию фильмов");
        System.out.println("0 - выход");
    }



        /*Movie WhatIsEating = new Movie("What's Eating Gilbert Grape", 1993);
        Movie Charlie = new Movie("Charlie and the Chocolate Factory", 2005);
        Movie Chocolat = new Movie("Chocolat", 2000);

        Actor Depp = new Actor("Johnny", "Depp");
        Actor Carter = new Actor("Helen Bonham", "Carter");
        Actor DiCaprio = new Actor ("Leonardo", "DiCaprio");
        Actor Steenburgen = new Actor("Mary", "Steenburgen");
        Actor SirLee = new Actor("Christopher", "Lee");
        Actor Binoche = new Actor("Juliette", "Binoche");
        Actor Dench = new Actor("Judy", "Dench");
        */


        File myFile;
        ConsoleUtilities consUtil = new ConsoleUtilities(System.in);
        String prompt = "Введите имя файла для сериализации";
        String filename = consUtil.readFileName(prompt);

        //создаем файл-заготовку
        try {
            myFile = new File(filename);
            boolean wasCreated = myFile.createNewFile();
            String creationResult = (wasCreated)? "Был создан новый файл." : "Файл уже существует.";
            System.out.print(creationResult);
        } catch (IOException ex) {
            System.out.println("Неправильное имя файла.");
        }









        //обращаемся к объекту из другого пакета - ввод имени файла был реализован ранее
    public void serializeCollection() throws Exception{




        /*сериализуем и десериализуем
        Serializer.serializeObj(filename, myCollection);
        myCollection = Serializer.deserializeObj(filename);

        //здесь меняем коллекцию

        //опять сериализуем
        Serializer.serializeObj(filename, myCollection); */

    }
}
