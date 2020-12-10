/**
 * 
 */
package assignment;

/**
 * @author Justin
 *
 */
public class ConcatReplicate {
	/**
	 *  takes an array of strings and an integer n and returns a single string 
	 *  that is the result of replicating them all n 
	 *  times and then concatenating them all together. 
	 * @param arr an array of strings
	 * @param n the number time to print each element in the array
	 * @return temp
	 */
  public static String concatAndReplicateAll(String[] arr, int n) {
	  int length = arr.length;
	  String result = new String("");
	  String [] temp = new String [length*n]; 
	  int count = 0;
	  if(arr.length <= 0) {
		  throw new IllegalArgumentException("Cannot have an empty array");
	  } else {
		  
	  
	    for(int i = 0; i < n; i++) { 
		    for(int j = 0; j < n; j++) {
			    temp [count] = arr[i];
			    count++;
		    }	 
	    }
	  
	    for(int i = 0; i < temp.length; i++) {
		    result += temp[i];
	    }
	    return result;
	    }
  }
  
}
