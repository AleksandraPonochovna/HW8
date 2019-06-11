package com.company;

public class MyArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int position = 0;
    private Object[] array = new Object[DEFAULT_CAPACITY];
    private StringBuilder stringBuilder = new StringBuilder();
    private int size = array.length;

    public void printArrayList() {
        System.out.println("My array list: ");
        stringBuilder.setLength(0);
        for (int j = 0; j < size; j++) {
            stringBuilder.append(array[j]).append(", ");
        }
        System.out.println(stringBuilder);
    }

    @Override
    public void add(T value) {
        check(position);
        add(value, position);
        position++;
    }

    private void check(int index) {
        if (index < 0 || index > position) {
            if (index >= size) {
                size += size / 2;
                array = newArray();
            }
        }
    }

    private Object[] newArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, position);
        return newArray;
    }

    @Override
    public void add(T value, int index) {
        check(index);
        System.arraycopy(array, index, array, index + 1, size - index - 1);
        array[index] = value;
        size++;
    }

    @Override
    public void addAll(List<T> list) {
        Object[] obj = list.toArray();
        size = array.length;
        array = newArray();
        System.arraycopy(obj, 0, this.array, 0, obj.length);
    }

    @Override
    public T get(int index) {
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
}

