package examples.Lab4;

import vectors.ArrayVector;
import vectors.LinkedListVector;
import vectors.Vector;

import java.io.*;

public class Task2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Vector vector1 = new ArrayVector(5);
        vector1.setElement(0, 1.2);
        vector1.setElement(1, 3.4);
        vector1.setElement(2, 5.6);
        vector1.setElement(3, 7.8);
        vector1.setElement(4, 9.0);

        LinkedListVector vector2 = new LinkedListVector();
        vector2.add(1.2);
        vector2.add(3.4);
        vector2.add(5.6);
        vector2.add(7.8);
        vector2.add(9.0);

        System.out.println("До сериализации:\t");
        print(vector1);
        print(vector2);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("fileObject.txt"));
        out.writeObject(vector1);
        out.writeObject(vector2);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("fileObject.txt"));
        vector1 = (Vector) in.readObject();
        vector2 = (LinkedListVector) in.readObject();

        System.out.println("После сериализации:\t");
        print(vector1);
        print(vector2);
    }

    private static void print(Vector vector) {
        System.out.print(vector.getSize() + " ");
        for (int i = 0; i < vector.getSize(); i++) {
            System.out.print(vector.getElement(i) + " ");
        }
        System.out.println();
    }
}
