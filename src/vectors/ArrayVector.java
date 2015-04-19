package vectors;

import java.util.Iterator;

public class ArrayVector implements Vector {
    private double[] elements;

    public ArrayVector(int length) {
        elements = new double[length];
    }

    public double getElement(int index) {
        if (index < 0 || index >= getSize())
            throw new VectorIndexOutOfBoundsException();
        return elements[index];
    }

    public void setElement(int index, double value) {
        if (index < 0 || index >= getSize())
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

    @Override
    public Iterator iterator() {
        return new ArrayListIterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof ArrayVector))
            return false;
        ArrayVector vector = (ArrayVector) obj;
        if (elements.length != vector.getSize())
            return false;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != vector.getElement(i))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash ^= elements.length;
        for (Double value : elements) {
            long bits = Double.doubleToLongBits(value);
            hash ^= (int) (bits ^ (bits >>> 32));
        }
        return hash;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        ArrayVector result = (ArrayVector) clone;
        result.elements = elements.clone();
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < elements.length; i++) {
            sb.append(elements[i]);
            if (i != elements.length - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    private class ArrayListIterator implements Iterator {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < elements.length;
        }

        @Override
        public Object next() {
            return elements[index++];
        }

        @Override
        public void remove() {

        }
    }
}