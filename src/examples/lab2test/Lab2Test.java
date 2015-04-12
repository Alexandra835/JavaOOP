package examples.lab2test;

import vectors.ArrayVector;
import vectors.Vector;

import java.util.Random;

public class Lab2Test {
    public static void main(String[] args) {
        // ===============================================
        double[] xdata = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0};
        ArrayVector x = new ArrayVector(xdata.length);
        for (int i = 0; i < xdata.length; i++) {
            x.setElement(i, xdata[i]);
        }
        System.out.println(sum(x));

        // ===============================================
        Random rand = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println();
        printOver50(array);
    }

    private static double sum(Vector vector) {
        double sum = 0.0;
        for (int i = 1; i < vector.getSize(); i += 2) {
            sum += vector.getElement(i);
        }
        return sum;
    }

    private static void printOver50(int[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 50)
            System.out.println(array[i]);
        }
    }
}
