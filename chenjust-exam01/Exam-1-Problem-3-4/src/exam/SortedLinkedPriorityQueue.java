/**
 * 
 */
package exam;

/**
 * @author Justin
 *
 */
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of priority queues as sorted linked structures.
 *
 * @author Soren
 * @author Theodore
 */
public class SortedLinkedPriorityQueue<T> implements PriorityQueue<T> {
	Node<T> front;
	Comparator<T> comparator;
	int mySize;


  public SortedLinkedPriorityQueue(Comparator<T> comp) {
     this.comparator = comp;
  }

  public Comparator<T> comparator() {
  	  return comparator;
  } // comparator()

	/**
	 * Remove the least recently added element that is still in the queue.
	 *
	 * @return val, a value.
	 * @pre !this.isEmpty()
	 * @post The structure contains one fewer copy of val.
	 * @post Every element that remains in the queue was added more recently than
	 *       val.
	 * @exception Exception If the structure is empty.
	 */
  @Override
  public T get() throws Exception { 
	  if (!isEmpty()) {
		  T temp = this.front.value;
		  Node<T> temp2 = this.front.next;
		  this.front = temp2;
		  this.front.next = null;
		  return temp;
	  } else {
		  throw new Exception("The list is empty");
	  }
  } // get()
/**
 * Check if the linked list is empty or not
 * @return return true if front is null
 */
  @Override
  public boolean isEmpty() {
	  return this.front == null; // STUB;
  } // isEmpty()
  /**
   * Check if the linked list is full or not
   * @return always return false because linked list can never be full
   */
  @Override
  public boolean isFull() {
	  return false;
  } // isFull()

/**
 * Get an iterator that returns all of the elements in some order.
 */
  @Override
  public Iterator<T> iterator() {
	  return new Iterator<T>() {
		  Node<T> next;
		  T value;

		  @Override
		  public boolean hasNext() {
			  return this.next != null;
		  }

		  @Override
		  public T next() throws NoSuchElementException {
			  if (!this.hasNext()) {
			   throw new NoSuchElementException();
			  }
			  T val = this.value;
			  this.next = this.next.next;
			  return val;
		  } // next()

		  @Override
		  public void remove() {
			  this.value = this.next.value;
			  this.next = this.next.next;

		  } // next()
	  };
		// return null;
   } // iterator()

 /**
 * Determine what element will next be removed by get.
 *
 * @return val, a value.
 * @pre !this.isEmpty()
 * @post For all values, v, in the queue, comparator().compare(val, v) <= 0
 * @exception Exception If the structure is empty.
 */
 @Override
  public T peek() throws Exception {
	  if (!this.isEmpty()) {
		  return this.front.value;
	  } else {
		 throw new Exception("The list is empty");
	 }
  } // peek()

/**
 * Add an element to the queue.
 *
 * @param val the value to add.
 * @pre this.isFull()
 * @post The queue now contains an additional element of val.
 * @exception Exception If the structure is full.
 */
  @Override
  public void put(T val) throws Exception {
	 Node<T> pointer = this.front;
	 Node<T> newNode = new Node<T>(val, null);
	 if(this.isFull()) {
		 throw new Exception("The list is full");
	 }else {

	 if (!this.isFull()) {
		 if (this.front == null) {
			 this.front = newNode;
		 } else if (comparator.compare(newNode.value, this.front.value) > 0) {
			 newNode.next = pointer;
			 this.front = newNode;
		 } else {
			 while(pointer != null || comparator.compare(pointer.next.value, newNode.value) < 0) {
				 pointer = pointer.next;
			 }

			 if (pointer.next == null) {
				 pointer.next = newNode;
			 } else {
				 Node<T> temp = pointer.next;
				 newNode.next = temp;
				 pointer.next = newNode;
			 }
		  }

		}
	  }
	 } // put()

} // class SortedLinkedPriorityQueue
