/**
 * 
 */
package exam;

/**
 * @author Justin
 *
 */
/**
 * A really simple experiment with ArrayBasedQueues.
 *
 * @author Samuel A. Rebelsky.
 */
public class ArrayBasedQueueExpt {
  /**
   * Do all the work. (Well, make the helpers do all the work.)
   */
  public static void main(String[] args) throws Exception {
    ReportingLinearStructure<String> expt =
        new ReportingLinearStructure<String>(new ArrayBasedQueue<String>(4), "expt.");
    // Put in a few values, then remove two

    expt.put("a");
    expt.put("b");
    expt.put("c");
    expt.put("d");
   // expt.info();
    expt.put("e");
    expt.put("f");
    expt.put("e");
    
    //expt.iterator().remove();
    expt.info();
    

    expt.isEmpty();
    expt.put("a");
    
    expt.info();
    expt.put("b");
    expt.info();
    expt.put("c");
    expt.info();
    expt.get();
    expt.get();
    expt.put("x");
    expt.info();
    expt.put("y");
    expt.info();
    expt.get();
    expt.get();
    expt.get();
    expt.info();
 
    // It's always good to see what happens after you've cleared
    // out a structure. So add a few more elements.
    expt.put("e");
    expt.info();
    expt.put("f");
    expt.info();
    expt.get();
    expt.info();
    expt.put("g");
    expt.get();
    expt.get();
    // And we're back down to the empty queue
    expt.info();

  } // main(String[])
} // class ArrayBasedQueueExpt
