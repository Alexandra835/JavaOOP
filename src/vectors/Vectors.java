package vectors;

public class Vectors {

    public static ArrayVector mult(Vector vector, double n) {
        ArrayVector result = new ArrayVector(vector.getSize());
        for (int i = 0; i < result.getSize(); i++) {
            result.setElement(i, vector.getElement(i) * n);
        }
        return result;
    }

    public static ArrayVector sum(Vector vector1, Vector vector2) throws IncompatibleVectorSizesException {
        if (vector1.getSize() != vector2.getSize())
            throw new IncompatibleVectorSizesException("Размер векторов не совпадает");
        ArrayVector result = new ArrayVector(vector1.getSize());
        for (int i = 0; i < result.getSize(); i++) {
            result.setElement(i, vector1.getElement(i) + vector2.getElement(i));
        }
        return result;
    }

    public static double scalarMult(Vector vector1, Vector vector2) throws IncompatibleVectorSizesException {
        if (vector1.getSize() != vector2.getSize())
            throw new IncompatibleVectorSizesException("Размер векторов не совпадает");
        double sum = 0.0;
        for (int i = 0; i < vector1.getSize(); i++) {
            sum += vector1.getElement(i) * vector2.getElement(i);
        }
        return sum;
    }
}