ackage com.company;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements List<T> {

    private final static int DEFAULT_CAPACITY = 10;
    private T[] array = (T[]) new Object[DEFAULT_CAPACITY];
    private StringBuilder builder = new StringBuilder();
    private int sizeOfArray = DEFAULT_CAPACITY;
    private int position = 0;

    @Override
    public void add(T value) {
        add(value, position);
    }

    @Override
    public void add(T value, int index) {
        if (index >= 0) {
            if (index >= sizeOfArray) {
                sizeOfArray += DEFAULT_CAPACITY / 2;
                array = Arrays.copyOf(array, sizeOfArray);
            }
            System.arraycopy(array, index, array, index + 1, sizeOfArray - index - 1);
            array[index] = value;
            position++;
        }
    }

    @Override
    public void addAll(List<T> list) {
        T[] newArray = (T[]) list.toArray();
        while (newArray.length > sizeOfArray) {
            sizeOfArray += newArray.length;
            array = Arrays.copyOf(array, sizeOfArray);
        }
        array = Arrays.copyOf(newArray, list.size());
    }

    @Override
    public T get(int index) {
        if (checkOfIndex(index)) {
            return array[index];
        }
        return null;
    }

    @Override
    public void set(T value, int index) {
        array[index] = checkOfIndex(index) ? value : null;
    }

    @Override
    public T remove(int index) {
        if (checkOfIndex(index)) {
            T removeElem = array[index];
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            position--;
            return removeElem;
        }
        return null;
    }

    @Override
    public T remove(T t) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(t)) {
                remove(i);
                return t;
            }
        }
        return null;
    }

    private boolean checkOfIndex(int index) {
        if (index < 0 || index > sizeOfArray) {
            throw new NoSuchElementException("The index is wrong.");
        }
        return true;
    }

    @Override
    public int size() {
        return sizeOfArray;
    }

    @Override
    public boolean isEmpty() {
        return position == 0;
    }

    @Override
    public Object[] toArray() {
        return array;
    }

    public void printArrayList() {
        System.out.println("My array list: ");
        builder.setLength(0);
        for (int j = 0; j < sizeOfArray; j++) {
            builder.append(array[j]).append(", ");
        }
        System.out.println(builder);
    }
}

