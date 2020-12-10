/**
 * 
 */
package exam1;

/**
 * @author Justin
 *
 */
/**
 * A simple set of utilities.
 * 
 * @author Ava Ridge
 * @author Justin Chen
 */
public class MathUtils {
  /**
   * Compute the average of an array of long values.
   */
	  public static long average(long[] values) {
		    long sum = 0;
		    for (long val :values) {
		      sum += val;
		    } // for
		    return sum/values.length;
		  } // average(long[])
  
  //(a / 2) + (b / 2) + (((a % 2) + (b % 2)) / 2)
  /**
   * This function is the new improved version the function average. The difference
   * between the two function is that this function do not have overflow
   * @post the average of the array without the overflow problem
   * @param values, an array with long
   * @return the calculated average without overflow or underflow
   */
  public static long averageNew(long[] values) {
	  long sum = 0;
	  long sum1 = 0;
	  for(int i = 0; i<values.length;i++) {
		  sum += values[i]/ values.length;
		  sum1 += values[i]%values.length; 
	  }
	  sum1= sum1 / values.length;
	  return  sum + sum1; 
  }
  
  
  

 
} // class MathUtils
