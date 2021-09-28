package org.example;

public class CollectionMain {
    public static void main(String[] args) {
        MathSet defaultConstruct = new MathSet();
        System.out.println(defaultConstruct);
        MathSet customSize = new MathSet(5);
        System.out.println("customSize = " + customSize);
        customSize.add(16);
        System.out.println("customSize = " + customSize);
        customSize.add(7,98,97,45);
        System.out.println("customSize = " + customSize);
        Number[] list1 = {1,32,53,34,15};
        MathSet arrayConstruct = new MathSet(list1);
        System.out.println(arrayConstruct);
        arrayConstruct.sortAsc();
        System.out.println("Sorted = " + arrayConstruct);
        System.out.println("arrayConstruct = " + arrayConstruct);
        arrayConstruct.sortDesc();
        System.out.println("Sorted = " + arrayConstruct);
        Number[] list2 = {15,63,87,86,49,10};
        MathSet arraysConstruct = new MathSet(list1, list2);
        System.out.println("arraysConstruct = " + arraysConstruct);
        arraysConstruct.join(arrayConstruct);
        System.out.println("Join = " + arraysConstruct);
        arrayConstruct.clear();
        System.out.println("Cleared = " + arrayConstruct);
        System.out.println("Average: " + customSize.getAverage());
        System.out.println("Median: " + customSize.getMedian());
        System.out.println("Max: " + customSize.getMax());
        System.out.println("Min: " + customSize.getMin());
        
    }
}
