/**
 * 
 */
package assignment;

/**
 * @author Justin
 *
 */
public class Contains {
	/**
	 * 
	 * @param dubs a double of array
	 * @param eps the number to be compared to
	 * @param d is the delta
	 * @return true or false
	 */
	public static boolean contains(double[] dubs, double eps, double d) {
		for(int i =0; i < dubs.length; i++) {
			if (Math.abs((dubs[i]-d)) < eps) {
				return true;
			}
		}
		return false; 
	}
}
