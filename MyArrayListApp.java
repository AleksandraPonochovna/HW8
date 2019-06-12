package com.company;

public class MyArrayListApp {

    public static void main(String[] args) {
        MyArrayList<String> myArrayList = new MyArrayList<>();
        MyArrayList<String> copyArrayList = new MyArrayList<>();
        myArrayList.add("1");
        myArrayList.add("2");
        myArrayList.add("3");
        myArrayList.add("4");
        myArrayList.add("5");
        myArrayList.add("6");
        myArrayList.add("7");
        myArrayList.add("8");
        myArrayList.add("9");
        myArrayList.add("10");
        myArrayList.add("11");
        myArrayList.add("12");
        myArrayList.add("13");
        myArrayList.add("14");
        myArrayList.add("15");
        myArrayList.add("16");
        myArrayList.add("17");
        myArrayList.add("18");
        myArrayList.add("19");
        myArrayList.remove(1);
        myArrayList.remove("1");
        myArrayList.add("!!!!", 10);
        System.out.println("Get 10: " + myArrayList.get(10));
        System.out.println("Get 0: " + myArrayList.get(0));
        myArrayList.printArrayList();
        copyArrayList.addAll(myArrayList);
        copyArrayList.printArrayList();
    }
}
