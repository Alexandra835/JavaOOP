package examples.Lab4;

import vectors.ArrayVector;
import vectors.Vector;
import vectors.Vectors;

import java.io.*;

public class Task1 {
    public static void main(String[] args) throws IOException {
        Vector vector = new ArrayVector(5);
        vector.setElement(0, 1.2);
        vector.setElement(1, 3.4);
        vector.setElement(2, 5.6);
        vector.setElement(3, 7.8);
        vector.setElement(4, 9.0);

        // Текстовые потоки
        String textFileName = "fileText.txt";

        System.out.println("Работа с текстовыми потоками");
        System.out.print("До вывода в файлы:\t\t");
        print(vector);

        FileWriter fileWriter = new FileWriter(textFileName);
        Vectors.writeVector(vector, fileWriter);

        FileReader fileReader = new FileReader(textFileName);
        vector = Vectors.readVector(fileReader);

        System.out.print("После вывода в файлы:\t");
        print(vector);

        // Байтовые потоки
        String byteFileName = "fileByte.txt";

        System.out.println("Работа с байтовыми потоками");
        System.out.print("До вывода в файлы:\t\t");
        print(vector);

        FileOutputStream fileOutputStream = new FileOutputStream(byteFileName);
        Vectors.outputVector(vector, fileOutputStream);

        FileInputStream fileInputStream = new FileInputStream(byteFileName);
        vector = Vectors.inputVector(fileInputStream);

        System.out.print("После вывода в файлы:\t");
        print(vector);
    }

    private static void print(Vector vector) {
        System.out.print(vector.getSize() + " ");
        for (int i = 0; i < vector.getSize(); i++) {
            System.out.print(vector.getElement(i) + " ");
        }
        System.out.println();
    }
}
