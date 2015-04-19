package vectors;

import java.io.*;

public class LinkedListVector implements Vector {

    private LinkedList elements;

    public LinkedListVector() {
        elements = new LinkedList();
    }

    public LinkedListVector(int size) {
        this();
        for (int i = 0; i < size; i++) {
            elements.add(0.0);
        }
    }

    @Override
    public double getElement(int index) {
        if (index < 0 || index >= getSize())
            throw new VectorIndexOutOfBoundsException();
        return elements.get(index);
    }

    @Override
    public void setElement(int index, double value) {
        if (index < 0 || index >= getSize())
            throw new VectorIndexOutOfBoundsException();
        elements.set(index, value);
    }

    @Override
    public int getSize() {
        return elements.size();
    }

    @Override
    public double getNorm() {
        try {
            return Vectors.scalarMult(this, this);
        } catch (IncompatibleVectorSizesException e) {
            e.printStackTrace();
        }
        return -1.0;
    }

    public void add(double value) {
        elements.add(value);
    }

    public void add(int index, double value) {
        elements.add(index, value);
    }

    public double remove(int index) {
        return elements.remove(index);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof LinkedListVector))
            return false;
        LinkedListVector vector = (LinkedListVector) obj;
        if (elements.size() != vector.getSize())
            return false;
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i) != vector.getElement(i))
                return false;
        }
        return true;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash ^= elements.size();
//        for (Double value : elements) {
//            long bits = Double.doubleToLongBits(value);
//            hash ^= (int)(bits ^ (bits >>> 32));
//        }
//        return hash;
//    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        LinkedListVector result = (LinkedListVector) clone;
        result.elements = new LinkedList();
        for (int i = 0; i < elements.size(); i++) {
            result.elements.add(elements.get(i));
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < elements.size(); i++) {
            sb.append(elements.get(i));
            if (i != elements.size() - 1)
                sb.append(" ");
        }
        return sb.toString();
    }

    private class LinkedList implements Serializable {
        private int size;
        private Node head;

        private LinkedList() {
            this.size = 0;
            this.head = null;
        }

        public void add(double value) {
            add(this.size, value);
        }

        public void add(int index, double value) {
            if (this.head == null) {
                this.head = new Node(value);
                this.head.setNext(this.head);
                this.head.setPrevious(this.head);
            } else {
                if (index == 0) {
                    this.head = new Node(value, this.head, this.head.getPrevious());
                } else {
                    Node current = getNode(index);
                    Node newNode = new Node(value, current, current.getPrevious());
                    current.getPrevious().setNext(newNode);
                    current.setPrevious(newNode);
                }
            }
            this.size++;
        }

        public double get(int index) {
            Node current = getNode(index);
            return current.getValue();
        }

        public double remove(int index) {
            Node del = getNode(index);

            del.getPrevious().setNext(del.getNext());
            del.getNext().setPrevious(del.getPrevious());

            if (del == this.head) {
                head = del.getNext();
            }
            this.size--;
            return del.getValue();
        }

        public void set(int index, double value) {
            getNode(index).setValue(value);
        }

        public int size() {
            return this.size;
        }

        private Node getNode(int index) {
            Node current = this.head;

            while (index > 0) {
                current = current.getNext();
                index--;
            }

            return current;
        }


        private class Node implements Serializable {
            private double value;
            private Node next;
            private Node previous;

            private Node(double value) {
                this(value, null, null);
            }

            private Node(double value, Node next, Node previous) {
                this.value = value;
                this.next = next;
                this.previous = previous;
            }

            public double getValue() {
                return value;
            }

            public void setValue(double value) {
                this.value = value;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node getPrevious() {
                return previous;
            }

            public void setPrevious(Node previous) {
                this.previous = previous;
            }
        }
    }
}
