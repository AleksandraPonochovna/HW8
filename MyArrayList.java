package com.company;

public class MyArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int position = 0;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private StringBuilder stringBuilder = new StringBuilder();
    private int size = array.length;

    @Override
    public void add(T value) {
        checkForAdd(position);
        add(value, position);
    }

    private void checkForAdd(int index) {
        if (index < 0) {
            throw new NoSuchFieldError();
        }
        if (index >= size) {
            size += size / 2;
            array = newArray();
        }
    }

    private T[] newArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, position);
        return (T[]) newArray;
    }

    @Override
    public void add(T value, int index) {
        checkForAdd(index);
        System.arraycopy(array, index, array, index + 1, size - index - 1);
        array[index] = value;
        position++;
    }

    @Override
    public void addAll(List<T> list) {
        Object[] obj = list.toArray();
        array = newArray();
        System.arraycopy(obj, 0, array, 0, obj.length);
    }

    @Override
    public T get(int index) {
        check(index);
        if (position > index) {
            return (T) array[index];
        }
        return null;
    }

    @Override
    public void set(T value, int index) {
        check(index);
        array[index] = value;
    }

    @Override
    public T remove(int index) {
        check(index);
        size--;
        System.arraycopy(array, index + 1, array, index, size - index);
        return (T) array[index];
    }

    @Override
    public T remove(T t) {
        for (int j = 0; j < size; j++) {
            if (array[j].equals(t)) {
                return remove(j);
            }
        }
        return null;
    }
    
    private void check(int index) {
        if (index < 0 || index > size) {
            throw new NoSuchFieldError();
        }
    }

    @Override
    public int size() {
        return position;
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
        stringBuilder.setLength(0);
        for (int j = 0; j < size; j++) {
            stringBuilder.append(array[j]).append(", ");
        }
        System.out.println(stringBuilder);
    }
}
