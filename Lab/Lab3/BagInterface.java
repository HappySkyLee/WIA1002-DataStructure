package Lab.Lab3;

public interface BagInterface<T> {
    //Q1
    public int getCurrentSize();
    public boolean isFull();
    public boolean isEmpty();
    public boolean add(T newEntry);
    public T remove();
    public boolean remove(T anEntry);
    public void clear();
    public int getFrequencyOf(T anEntry);
    public boolean contains(T anEntry);
    public T[] toArray();
    //Q2
    public BagInterface<T> union(BagInterface<T> anotherBag);
    //Q3
    public BagInterface<T> intersection(BagInterface<T> anotherBag);
    //Q4
    public BagInterface<T> difference(BagInterface<T> anotherBag);
}