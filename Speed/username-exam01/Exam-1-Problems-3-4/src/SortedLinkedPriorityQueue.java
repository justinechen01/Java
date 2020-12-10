import java.util.Comparator;
import java.util.Iterator;

/**
 * An implementation of priority queues as sorted linked structures.
 *
 * @author Soren
 * @author Theodore
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
  Node<T> front;
  Comparator<T> comparator;
  
  public Comparator<T> comparator() {
    return comparator;
  } // comparator()
  
  @Override
  public T get() {
    return null; // STUB;
  } // get()
  
  @Override
  public boolean isEmpty() {
    return true; // STUB;
  } // isEmpty()
  
  @Override
  public boolean isFull() {
    return false; // STUB;
  } // isFull()
  
  @Override
  public Iterator<T> iterator() {
    return null; // STUB
  } // iterator()
  
  @Override
  public T peek() {
    return null; // STUB
  } // peek()
  
  @Override
  public void put(T val) {
    // STUB
  } // put()

} // class SortedLinkedPriorityQueue
