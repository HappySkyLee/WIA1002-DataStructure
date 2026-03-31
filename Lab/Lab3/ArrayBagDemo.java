package Lab.Lab3;

import java.util.Arrays;

public class ArrayBagDemo {
    private static void testAdd(BagInterface<String> aBag, String[] content){
        System.out.println("Adding to bag: " + Arrays.toString(content));
        for (String item : content) {
            aBag.add(item);
        }
    }

    private static void displayBag(BagInterface<String> aBag){
        System.out.println("Bag contains " + aBag.getCurrentSize() + " items:");
        System.out.println(Arrays.toString(aBag.toArray()));
    }

    public static void main(String[] args) {
        BagInterface<String> bag1 = new ArrayBag<>(); // Uses default capacity of 25
        BagInterface<String> bag2 = new ArrayBag<>();

        System.out.println("\nBag 1:");
        testAdd(bag1, new String[]{"A", "A", "B", "A", "C", "A"});
        displayBag(bag1);

        System.out.println("\nBag 2:");  
        testAdd(bag2, new String[]{"A", "B", "A", "C", "B", "C", "D", "another string"});
        displayBag(bag2);

        BagInterface<String> bag3 = bag1.union(bag2);
        System.out.println("\nBag 3 (Union of bag 1 and bag 2):");
        displayBag(bag3);

        //Q3
        BagInterface<String> bag4 = bag1.intersection(bag2);
        System.out.println("\nBag 4 (Intersection of bag 1 and bag 2):");
        displayBag(bag4);

        //Q4 
        BagInterface<String> bag5 = bag1.difference(bag2);
        System.out.println("\nBag 5 (Difference of bag 1 and bag 2):");
        displayBag(bag5);

        BagInterface<String> bag6 = bag2.difference(bag1);
        System.out.println("\nBag 6 (Difference of bag 2 and bag 1):");
        displayBag(bag6);
    }
  
}