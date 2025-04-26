import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * This Heap class should implement a min heap. (Not a max heap!)
 *
 * The keys in the heap are stored in an array.
 * * There may be duplicate keys in the heap.
 * * The constructor takes an argument that specifies how objects in the 
 * heap are to be compared. This argument is a java.util.Comparator, 
 * which has a compare() method. The compare() method should 
 * return 0 if the two arguments are equal, 
 * return -1 if the first argument is less than the second, and
 * return 1 if the first argument is greater than the second argument.
 * * Here are some examples of a Comparator<String>:
 * (s, t) -> s.compareTo(t);
 * (s, t) -> t.length() - s.length();
 * (s, t) -> t.toLowerCase().compareTo(s.toLowerCase());
 * (s, t) -> s.length() <= 3 ? -1 : 1;  
 */

public class Heap<E> implements PriorityQueue<E> {
  private List<E> keys;
  private Comparator<E> comparator;
  
  /**
   * Creates a heap whose elements are prioritized by the comparator.
   */
  public Heap(Comparator<E> comparator) {
    keys = new ArrayList<>();
    this.comparator = comparator;
  }

  /**
   * Returns the comparator on which the keys in this heap are prioritized.
   */
  public Comparator<E> comparator() {
    return comparator;
  }

  /**
   * Returns the top of this heap. This will be the smallest key. 
   * @throws NoSuchElementException if the heap is empty.
   */
  public E peek() {
    if (keys.isEmpty()) {
        throw new NoSuchElementException("Heap is empty");
    }
    return keys.get(0);
  }

  /**
   * Inserts the given key into this heap.
   */
  public void push(E key) {
    keys.add(key);
    siftUp(keys.size() - 1);
  }

  /**
   * Removes and returns the smallest key in this heap.
   * @throws NoSuchElementException if the heap is empty.
   */
  public E pop() {
    if (keys.isEmpty()) {
        throw new NoSuchElementException("Heap is empty");
    }
    E min = keys.get(0);
    if(keys.size() > 1) {
        keys.set(0, keys.remove(keys.size() - 1));
        siftDown(0);
    } else {
        keys.remove(0);
    }
    return min;
  }

  /**
   * Exchanges the elements in the heap at the given indices in keys.
   */
  public void swap(int i, int j) {
    E temp = keys.get(i);
    keys.set(i, keys.get(j));
    keys.set(j, temp);
  }
  
  /**
   * Returns the number of keys in this heap.
   */
  public int size() {
    return keys.size();
  }

  /**
   * Returns a textual representation of this heap.
   */
  public String toString() {
    return keys.toString();
  }
  
  /**
   * Returns the index of the left child of p.
   */
  public static int getLeft(int p) {
    return 2 * p + 1;
  }

  /**
   * Returns the index of the right child of p.
   */
  public static int getRight(int p) {
    return 2 * p + 2;
  }

  /**
   * Returns the index of the parent of p.
   */
  public static int getParent(int p) {
    return (p - 1) / 2;
  }

  // Helper method to maintain the heap property when adding a new element
  private void siftUp(int index) {
    while (index > 0) {
      int parentIndex = getParent(index);
      if (comparator.compare(keys.get(index), keys.get(parentIndex)) < 0) {
        swap(index, parentIndex);
        index = parentIndex;
      } else {
        break;
      }
    }
  }

  // Helper method to maintain the heap property when removing the smallest element
  private void siftDown(int index) {
    int size = keys.size();
    while (true) {
      int leftIndex = getLeft(index);
      int rightIndex = getRight(index);
      int smallestIndex = index;

      if (leftIndex < size && comparator.compare(keys.get(leftIndex), keys.get(smallestIndex)) < 0) {
        smallestIndex = leftIndex;
      }
      if (rightIndex < size && comparator.compare(keys.get(rightIndex), keys.get(smallestIndex)) < 0) {
        smallestIndex = rightIndex;
      }
      if (smallestIndex == index) {
        break;
      }
      swap(index, smallestIndex);
      index = smallestIndex;
    }
  }
}