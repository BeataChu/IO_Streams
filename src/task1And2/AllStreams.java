package task1And2;
/*  Прочитайте файл, содержащий код на языке Java. Определите, какие ключевые слова языка Java это код содержит.
Выведите эти слова и их количество в другой файл. Используйте только байтовые потоки ввода-вывода.*/


// главный класс с методом main
public class AllStreams {

    public static void main(String[] args) {

        MyParser.parse(System.in, new MyByteStream());

        MyParser.parse(System.in, new MyCharStream());

    }


}

