package Lab.Lab3.Q1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BagInterface<String> myBag = new ArrayBag<>(); // Uses default capacity of 25

        // Add a few items
        myBag.add("Apple");
        myBag.add("Banana");
        myBag.add("Orange");

        // Print size and contents
        System.out.println("Size: " + myBag.getCurrentSize());
        System.out.println("Contents: " + Arrays.toString(myBag.toArray()));

        // Remove an item and check contents again
        myBag.remove("Banana");
        System.out.println("After removing Banana: " + Arrays.toString(myBag.toArray()));
    }
}