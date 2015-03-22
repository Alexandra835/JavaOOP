package examples;

import vectors.ArrayVector;
import vectors.IncompatibleVectorSizesException;
import vectors.Vectors;

public class ArrayVectorTest {
    public static void main(String[] args) throws IncompatibleVectorSizesException {
        double[] xdata = {1.0, 2.0, 3.0, 4.0};
        double[] ydata = {5.0, 2.0, 4.0, 1.0};

        ArrayVector x = new ArrayVector(xdata.length);
        for (int i = 0; i < xdata.length; i++) {
            x.setElement(i, xdata[i]);
        }
        ArrayVector y = new ArrayVector(ydata.length);
        for (int i = 0; i < ydata.length; i++) {
            y.setElement(i, ydata[i]);
        }

        System.out.println("x = " + vectorToString(x));
        System.out.println("y = " + vectorToString(y));
        System.out.println("x + y = " + vectorToString(Vectors.sum(x, y)));
        System.out.println("x.max = " + x.max());
        System.out.println("x.min = " + x.min());
        System.out.println("10x = " + vectorToString(Vectors.mult(x, 10.0)));
        System.out.println("|x| = " + x.getNorm());
        System.out.println("<x, y> = " + Vectors.scalarMult(x, y));
    }

    private static String vectorToString(ArrayVector vector) {
        String result = "";
        for (int i = 0; i < vector.getSize() - 1; i++) {
            result += vector.getElement(i) + ", ";
        }
        return result + vector.getElement(vector.getSize() - 1);
    }
}
