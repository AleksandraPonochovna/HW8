package com.company;

public class MyArrayListApp {

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        MyArrayList<String> copyArrayList = new MyArrayList<>();
        myArrayList.isEmpty();
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4", 6);
        myArrayList.get(3);
        myArrayList.remove(2);
        myArrayList.remove("1");
        myArrayList.set("6", 7);
        copyArrayList.addAll(myArrayList);
        copyArrayList.printArrayList();
        myArrayList.printArrayList();
    }
}
