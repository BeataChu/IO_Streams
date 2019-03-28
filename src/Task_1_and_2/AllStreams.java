package Task_1_and_2;
/*  Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
Выведите эти слова и их количество в другой файл. Используйте только байтовые потоки ввода-вывода.*/

import java.io.*;


// главный класс с методом main
public class AllStreams {

    public static void main(String[] args) {

        MyParser.parse(new MyByteStream());

        MyParser.parse(new MyCharStream());

        MyParser.parse(new MyConsoleStream());
    }


}

