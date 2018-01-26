import java.util.*;
import java.lang.reflect.Array;

class MyArrayList<E> implements MyList<E> {
    private int numElements;
    private E[] arrayList;
    private Class <E> c;
    
    MyArrayList(Class <E> c) {
        this.c = c;
        arrayList = (E[])Array.newInstance(c, 10);
    }
    
    public int size() {
        return numElements;
    }
    
    public E set(int index, E element) {
        if (index >= numElements || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        E toReturn = arrayList[index];
        arrayList[index] = element;
        return toReturn;
    }
    
    public void removeRange(int fromIndex, int toIndex) {
        if (fromIndex >= numElements || toIndex > numElements || fromIndex > toIndex || fromIndex < 0 || toIndex < 0) {
            throw new IndexOutOfBoundsException("Index is out of bounds!");
        }
        for (int i = fromIndex; i < toIndex; i++) {
            arrayList[i] = arrayList[i + (toIndex - fromIndex)];
        }
        numElements -=(toIndex - fromIndex);
    }
    
    public E remove(int index) {
        if (index >= numElements || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        E toReturn = arrayList[index];
        for (int i = index; i < numElements; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        numElements--;
        return toReturn;
    }
    
    public Iterator<E> iterator() {
        Iterator <E> it = Arrays.asList(Arrays.copyOfRange(arrayList, 0, numElements)).iterator();
        return it;
    }
    
    public E get(int index) {
        if (index >= numElements || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
        return arrayList[index];
    }
    
    public void clear() {
        for (int i = 0; i < numElements; i++) {
            arrayList[i] = null;
        }
        numElements = 0;
    }
    
    public boolean isEmpty() {
        return !(numElements > 0);
    }
    
    public E[] toArray() {
        E[] toReturn = (E[])Array.newInstance(c, numElements);
        for (int i = 0; i < numElements; i++) {
            toReturn[i] = arrayList[i];
        }
        return toReturn;
    }
    
    public boolean add(E element) {
        checkSize();
        arrayList[numElements] = element;
        numElements++;
        return true;
    }
    
    public int indexOf(E element) {
        for (int i = 0; i < numElements; i++) {
            if (arrayList[i] == element) {
                return i;
            }
        }
        return -1;
    }
    
    public void add(int index, E element) {
        checkSize();
        if (index < numElements && index >= 0) {
            for (int i = numElements - 1; i >= index; i--) {
              arrayList[i + 1] = arrayList[i];
            }
            arrayList[index] = element;
            numElements++;
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }
    }
    
    private void checkSize() {
        if (numElements > arrayList.length) {
            E[] newArray = (E[])Array.newInstance(c, arrayList.length * 2);
            for (int i = 0; i < arrayList.length; i++) {
                newArray[i] = arrayList[i];
            }
            arrayList = newArray;
        }
        
    }
    
    
}