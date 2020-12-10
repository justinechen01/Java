/**
 * 
 */
package exam;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queues implemented with arrays.
 *
 * @author Samuel A. Rebelsky
 * @author Your Name Here
 */
public class ArrayBasedQueue<T> implements Queue<T> {
  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The values stored in the queue.
   */
  T[] values;

  /**
   * The index of the front of the queue.
   */
  int front;

  /**
   * The number of elements in the queue.
   */
  int size;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a new queue that holds up to capacity elements.
   */
  @SuppressWarnings({"unchecked"})
  // Handle array casting
  public ArrayBasedQueue(int capacity) throws Exception {
    if (capacity <= 0) {
      throw new Exception("Queues must have a positive capacity.");
    } // if (capacity <= 0)
    // Yay Java! It's not possible to say new T[capacity], so
    // we use this hack.
    this.values = (T[]) new Object[capacity];
    this.front = 0;
    this.size = 0;
  } // ArayBasedQueue(int capacity)

//+---------------+---------------------------------------------------
 // | Resizing    |
 // +-------------+
  /**
   * This method will resize the length of the array and add one more space for the array
   * so that more element can be added. 
   * @param cap, the capacity of the array.
   * @post array size increase
   */
 public void reSize(int cap) {
	 cap++; 
	 T[] temp = (T[]) new Object[cap];
	 for(int i = 0; i < this.size; i++) {
		 temp[i] = this.values[i];
	 }
	 this.values = temp; 
  }
 

  // +---------------+---------------------------------------------------
  // | Queue Methods |
  // +---------------+
 /**
  * This function will return false if there is at least one element in
  * the array. 
  * @param none
  * @return a boolean 
  */
  @Override
  public boolean isEmpty() {
    return this.size <= 0;
  } // isEmpty()
/**
 * In this function it will return true or false if the size of the array is equal
 * to the length of the array
 * @return a boolean
 */
  @Override
  public boolean isFull() {
	    return this.size >= this.values.length;
	  } // isFull()
/**
  * Add an element to the queue.
  * @param val the value to add.
  * @pre this.isFull()
  * @post The queue now contains an additional element of val.
  * @exception Exception If the structure is full.
  */
  @Override
  public void put(T val) throws Exception {
    if (this.isFull()) {
    	reSize(this.size);
    	 //System.out.println("TESTING FOR SIZE: "+ this.values.length);
      //throw new Exception("no more room!");
    } // this.isFull()
    this.values[this.back()] = val;

    ++this.size;
    //------Testing the whether or not the array length had changed or not?-----//
    //System.out.println("TEST after LENGTH:"+ this.values.length);
    //System.out.println("TEST after size:"+ this.size);
  } // put(T)
  /**
   * Remove the least recently added element that is still in the queue.
   *
   * @return val, a value.
   * @pre !this.isEmpty()
   * @post The structure contains one fewer copy of val.
   * @post Every element that remains in the queue was added more recently than val.
   * @exception Exception If the structure is empty.
   */
  @Override
  public T get() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("empty");
    } // if empty
    // Grab and clear the element at the front of the queue
    T result = this.values[this.front];
    this.values[this.front] = null;
    this.front = (this.front + 1) % this.values.length;
    // We're removing an element, so decrement the size
    --this.size;
    // And we're done
    return result;
  } // get(T)
  /**
   * Determine what element will next be removed by get.
   *
   * @return val, a value.
   * @pre !this.isEmpty()
   * @post Every other value in the queue was added more recently than val.
   * @exception Exception If the structure is empty.
   */
  @Override
  public T peek() throws Exception {
    if (this.isEmpty()) {
      throw new Exception("empty");
    } // if empty
    return this.values[this.front];
  } // peek()
/**
 * Take out an element in the array
 * @return return the return value from the get function
 * @post one of the value in the array gets remove
 */
  @Override
  public T dequeue() throws Exception {
    return this.get();
  } // dequeue
/**
 * Insert an element into the array and call the function put
 * @param Val, a generic value that is going to be added
 */
  @Override
  public void enqueue(T val) throws Exception {
    this.put(val);
  } // enqueue
/**
 * This an iterator that has the inner class of next, hasNext, and next. 
 * @return hasNext which returns a boolean, next which return the next value of the array,
 * and remove which removes an element in the array. 
 * 
 */
  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int pos = 0;

      /**
       * Check if there is an element at the next postion
       * @return true if the postion is less than the size
       */
      @Override
      public boolean hasNext() {
        return pos < size;
      }
      /**
       * @return val, an element of from the next position
       */
      @Override
      public T next() {
        T val = values[(front + pos) % values.length];
        pos += 1;
        return val;
      }

    /**
     * Remove the first element of the array
     */
      @Override
      public void remove () {
         T[] temp = (T[]) new Object[values.length-1];
    	 // System.out.println("Testing: "+ (values.length));
    	  for(int i = 0; i < values.length-1; i++) {
    		  temp[i] = values[i+1];	

    	  }    	
    	 values = temp;

    	 //pos -= 1; 

    	 /* For a b c d e f e 
    	  * I don't know why when expt.values print it prints b c d e f e b
    	  * even though my test case printed b c d e f e
    	 for(int i = 0; i<values.length; i++) {
    	 System.out.println(values[i]);
    	
    	 }
    	 */
      } // remove
    }; // new Iterator<T>()
  } // iterator()

  // +----------------+--------------------------------------------------
  // | Helper Methods |
  // +----------------+

  /**
   * Get the index of the back of the queue. The back is where we add the next element.
   */
  int back() {
    return (this.front + this.size) % this.values.length;
  } // back()

} // class ArrayBasedQueue<T>
