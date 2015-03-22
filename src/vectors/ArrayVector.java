package vectors;

public class ArrayVector implements Vector {
    private double[] elements;

    public ArrayVector(int length) {
        elements = new double[length];
    }

    public double getElement(int index) {
        if (index >= getSize())
            throw new VectorIndexOutOfBoundsException();
        return elements[index];
    }

    public void setElement(int index, double value) {
        if (index >= getSize())
            throw new VectorIndexOutOfBoundsException();
        elements[index] = value;
    }

    public int getSize() {
        return elements.length;
    }

    public double min() {
        double min = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] < min)
                min = elements[i];
        }
        return min;
    }

    public double max() {
        double max = elements[0];
        for (int i = 1; i < elements.length; i++) {
            if (elements[i] > max)
                max = elements[i];
        }
        return max;
    }

    public void sort() {
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    double swap = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = swap;
                }
            }
        }
    }

    public double getNorm() {
        try {
            return Math.sqrt(Vectors.scalarMult(this, this));
        } catch (IncompatibleVectorSizesException e) {
            e.printStackTrace();
        }
        return -1.0;
    }
}