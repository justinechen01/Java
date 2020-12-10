/**
 * 
 */
package assignment;

/**
 * @author Justin
 * citation https://www.geeksforgeeks.org/modular-exponentiation-power-in-modular-arithmetic/
 */
public class FastExponentiation {
/**
 * 
 * @param x the based number
 * @param y the power of the x
 * @param m mod 
 * @return
 */
	public static int fastModExp(int x, int y, int m) {
  
	    if (x == 0)  
	        return 0;  
	    if (y == 0)  
	        return 1;  
	    long temp;  
	    if (y % 2 == 0) {  
	        temp = fastModExp(x, y / 2, m);  
	        temp = (temp * temp) % m;  
	    } else {  
	        temp = x % m;  
	        temp = (temp * fastModExp(x, y - 1,  
	                             m) % m) % m;  
	    }  
	      
	    return (int)((temp + m) % m);  
	}
}
