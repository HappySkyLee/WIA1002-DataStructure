package Lab.Lab3;

public class ArrayBag<T> implements BagInterface<T> {
    
    // Private fields based on the UML diagram
    private final T[] bag;
    private static final int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;

    /** * Default constructor that sets the capacity to DEFAULT_CAPACITY (25) 
     */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    /** * Constructor that allows setting a custom capacity 
     */
    @SuppressWarnings("unchecked")
    public ArrayBag(int capacity) {
        // The cast is safe because the new array contains null entries
        T[] tempBag = (T[]) new Object[capacity]; 
        this.bag = tempBag;
        this.numberOfEntries = 0;
    }

    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries >= bag.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T newEntry) {
        if (isFull()) {
            return false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
            return true;
        }
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        } else {
            T result = bag[numberOfEntries - 1]; // Get the last entry
            bag[numberOfEntries - 1] = null;     // Remove reference for garbage collection
            numberOfEntries--;
            return result;
        }
    }

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        
        if (index > -1) {
            // Replace the removed entry with the last entry in the array 
            // This avoids having to shift elements left and keeps the array contiguous
            bag[index] = bag[numberOfEntries - 1]; 
            bag[numberOfEntries - 1] = null;
            numberOfEntries--;
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (anEntry.equals(bag[i])) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) > -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray() {
        // Create a new array of the exact size of the entries
        T[] result = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
    }

    // --- Private Helper Method --- //
    
    /**
     * Locates a given entry within the array bag.
     * @return The index of the entry, or -1 if not found.
     */
    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;
        
        while (!found && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    //Q2
    @Override
    public BagInterface<T> union(BagInterface<T> anotherBag) {
        BagInterface<T> result = new ArrayBag<>(this.getCurrentSize() + anotherBag.getCurrentSize());
        
        // Add all entries from this bag to the result
        T[] thisBagArray = this.toArray();
        for (int i = 0; i < thisBagArray.length; i++) {
            result.add(thisBagArray[i]);
        }
        
        // Add all entries from anotherBag to the result
        T[] anotherBagArray = anotherBag.toArray();
        for (int i = 0; i < anotherBagArray.length; i++) {
            result.add(anotherBagArray[i]);
        }
        
        return result;
    }

    //Q3
    @Override
    public BagInterface<T> intersection(BagInterface<T> anotherBag) {
        BagInterface<T> result = new ArrayBag<>(Math.min(this.getCurrentSize(), anotherBag.getCurrentSize()));
        BagInterface<T> tempBag = new ArrayBag<>(anotherBag.getCurrentSize());

        // Copy entries so each match can be consumed only once.
        T[] anotherBagArray = anotherBag.toArray();
        for (int i = 0; i < anotherBagArray.length; i++) {
            tempBag.add(anotherBagArray[i]);
        }
        
        T[] thisBagArray = this.toArray();
        for (int i = 0; i < thisBagArray.length; i++) {
            T currentEntry = thisBagArray[i];
            if (tempBag.remove(currentEntry)) {
                result.add(currentEntry);
            }
        }
        return result;
    }
    //Q4
    @Override
    public BagInterface<T> difference(BagInterface<T> anotherBag) {
        BagInterface<T> result = new ArrayBag<>(this.getCurrentSize());
        
        T[] thisBagArray = this.toArray();
        for (int i = 0; i < thisBagArray.length; i++) {
            result.add(thisBagArray[i]);
        }
        T[] anotherBagArray = anotherBag.toArray();
        for (int i = 0; i < anotherBagArray.length; i++) {
            T currentEntry = anotherBagArray[i];
            if (this.contains(currentEntry)) {
                result.remove(currentEntry);
            }
        }
        return result;
    }
}