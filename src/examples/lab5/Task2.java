package examples.lab5;

import vectors.ArrayVector;
import vectors.LinkedListVector;
import vectors.Vector;

import java.util.Iterator;

public class Task2 {
    public static void main(String[] args) {
        double[] data1 = {1.0, 2.0, 3.0, 4.0};

        Vector vector1 = new ArrayVector(data1.length);
        for (int i = 0; i < data1.length; i++) {
            vector1.setElement(i, data1[i]);
        }

        Iterator iterator1 = vector1.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println();
        double[] data2 = {5.0, 6.0, 7.0, 8.0};

        Vector vector2 = new LinkedListVector(data2.length);
        for (int i = 0; i < data2.length; i++) {
            vector2.setElement(i, data2[i]);
        }

        Iterator iterator2 = vector2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
    }
}
