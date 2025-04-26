import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;


import java.util.Random;
import java.util.Comparator;

public class StudentTest {

  @Test
  public void test() throws Exception {
    // Create a comparator that compares integers in natural order
    Comparator<Integer> comparator = Integer::compareTo;
    Heap<Integer> heap = new Heap<>(comparator);

    // Test pushing elements into the heap
    heap.push(10);
    heap.push(5);
    heap.push(15);
    heap.push(7);

    // Test size
    assertEquals(4, heap.size());

    // Test peek
    assertEquals(5, heap.peek());

    // Test pop
    assertEquals(5, heap.pop());
    assertEquals(7, heap.pop());
    assertEquals(10, heap.pop());
    assertEquals(15, heap.pop());

    // size after pops
    assertEquals(0, heap.size());

    // empty heap - pop should throw NoSuchElementException
    assertThrows(NoSuchElementException.class, heap::pop);

    // empty heap - peek should throw NoSuchElementException
    assertThrows(NoSuchElementException.class, heap::peek);

    //pushing and popping random values to check heap ordering
    Random rand = new Random();
    Heap<Integer> randHeap = new Heap<>(comparator);

    for (int i = 0; i < 100; i++) {
      randHeap.push(rand.nextInt(100));
    }

    // heap still pops in order
    int prev = randHeap.pop();
    while (randHeap.size() > 0) {
      int current = randHeap.pop();
      assertTrue(prev <= current);
      prev = current;
    }
  }
}
