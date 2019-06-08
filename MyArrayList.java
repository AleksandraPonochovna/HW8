package com.company;

public class MyArrayList<T> implements List<T> {

    private static final int DEFAULT_CAPACITY = 10;
    int i = 0;
    Object[] array = new Object[DEFAULT_CAPACITY];
    StringBuilder stringBuilder = new StringBuilder();
    private int size;

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
        check(i);
        add(value, i);
        i++;
    }

    public void check(int i) {
        if (i >= size) {
            size += DEFAULT_CAPACITY / 2;
            array = newArray(array);
        }
    }

    public Object[] newArray(Object[] newArray) {
        newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, i);
        return newArray;
    }

    @Override
    public void add(T value, int index) {
        check(index);
        array[index] = value;
    }

    @Override
    public void addAll(List<T> list) {
        Object[] obj = list.toArray();
        size = obj.length;
        array = newArray(array);
        System.arraycopy(obj, 0, this.array, 0, obj.length);
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public void set(T value, int index) {
        array[index] = value;
    }

    @Override
    public T remove(int index) {
        size -= 1;
        for (int j = index; j < size; j++) {
            array[j] = array[j + 1];
        }
        return (T) array;
    }

    @Override
    public T remove(T t) {
        for (int j = 0; j < size; j++) {
            if (array[j] == t) {
                return remove(j);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (array[0] == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return array;
    }
}
