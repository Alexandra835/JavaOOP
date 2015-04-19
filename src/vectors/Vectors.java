package vectors;

import java.io.*;

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

    public static void outputVector (Vector v, OutputStream out) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(out);
        outputStream.writeInt(v.getSize());
        for (int i = 0; i < v.getSize(); i++) {
            outputStream.writeDouble(v.getElement(i));
        }
        outputStream.close();
    }

    public static Vector inputVector (InputStream in) throws IOException {
        DataInputStream inputStream = new DataInputStream(in);
        int length = inputStream.readInt();
        Vector vector = new ArrayVector(length);
        for (int i = 0; i < length; i++) {
            vector.setElement(i, inputStream.readDouble());
        }
        inputStream.close();
        return vector;
    }

    public static void writeVector (Vector v, Writer out) {
        PrintWriter writer = new PrintWriter(out);
        writer.print(v.getSize());
        for (int i = 0; i < v.getSize(); i++) {
            writer.print(' ');
            writer.print(v.getElement(i));
        }
        writer.close();
    }

    public static Vector readVector (Reader in) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(in);
        tokenizer.nextToken();
        int length = (int) tokenizer.nval;
        Vector vector = new ArrayVector(length);
        for (int i = 0; i < length; i++) {
            tokenizer.nextToken();
            vector.setElement(i, tokenizer.nval);
        }
        in.close();
        return vector;
    }

    public Vector unmodifiableVector(Vector vector) {
        return new UnmodifiableVector(vector);
    }
}