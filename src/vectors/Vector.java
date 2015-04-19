package vectors;

import java.io.Serializable;

public interface Vector extends Serializable, Cloneable {

    double getElement(int index);

    void setElement(int index, double value);

    int getSize();

    double getNorm();

    Object clone() throws CloneNotSupportedException;
}
