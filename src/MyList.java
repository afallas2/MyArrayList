import java.util.Iterator;

interface MyList<E> {
    
    // Appends the specified element to the end of this list
    boolean add(E element);

    // Inserts the specified element at the specified position in this list
    void add(int index, E element);
    
    // Removes all of the elements from this list
    void clear();

    // Returns the element at the specified position in this list    
    E get(int index);
    
    // Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element
    int indexOf(E element);
    
    // Returns true if this list contains no elements
    boolean isEmpty();
    
    // Returns an iterator over the elements in this list in proper sequence
    Iterator<E> iterator();
    
    // Removes the element at the specified position in this list
    E remove(int index);
    
    // Removes from this list all of the elements whose index is between fromIndex, inclusive, and toIndex, exclusive
    void removeRange(int fromIndex, int toIndex);
    
    // Replaces the element at the specified position in this list with the specified element
    E set(int index, E element);
    
    // Returns the number of elements in this list
    int size();

    // Returns an array containing all of the elements in this list in proper sequence (from first to last element)
    E[] toArray();
    /*
    
    // Trims the capacity of this ArrayList instance to be the list's current size
    void trimToSize();*/
}