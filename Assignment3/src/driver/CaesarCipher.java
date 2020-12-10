/*
 * Sources
 * https://stackoverflow.com/questions/10813154/how-do-i-convert-a-number-to-a-letter-in-java
 * https://beginnersbook.com/2013/12/java-string-tochararray-method-example/ 
 * Reilly Grant pointed us towards the above command on turning strings into arrays 
 *   (even though it was in the Assignment)
 * https://rosettacode.org/wiki/Vigen%C3%A8re_cipher#Java 
 * Jonathan Sadun helped with arithmetic for looping from a to z when decoding and typing on
 *   the command line
 * https://www.geeksforgeeks.org/difference-equals-method-java/
 */

package driver;

import java.io.PrintWriter;

public class CaesarCipher {

  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 2) { // test if input has two input words
      pen.println("Incorrect number of parameters");
      pen.flush();
    } else { // if it has the correct number of parameters
      char[] arr = args[1].toCharArray(); // convert the word to en/decode into an array

      int i = 0;
      boolean done = false;
      while (arr.length > i) {
        if (Character.isUpperCase(arr[i])) { // see if there are any upper case letters
          done = true;
        }
        i++;
      }
      // Call encode or decode if the user types in the right parameters
      // otherwise throw out a helpful error message indicating that the the text has
      // an uppercase or an incorrect command
      if ((args[0].equals("encode")) && (done == false)) {
        Encode(arr, args[1]);
      } else if ((args[0].equals("decode")) && (done == false)) {
        Decode(arr, args[1]);
      } else if ((args[0].equals("decode")) || (args[0].equals("encode")) && (done == true)) {
        pen.println("String to be en/decoded must be all lowercase");
        pen.flush();
      } else {
        pen.println("Valid options are \"encode\" and \"decode\"");
        pen.flush();
      }
    }
  }

  /*
   * Pre Condition: arr a char array, input a string of alphabetic characters
   * Post Condition: Prints out 25 possible permutations of the Caesar Cipher
   */
  public static void Encode(char arr[], String input) {
    PrintWriter pen = new PrintWriter(System.out, true);

    for (int n = 0; n < 26; n++) {
      pen.print("n = " + n + ": ");
      for (int i = 0; i < input.length(); i++) {
        char MyArray2 = arr[i];
        arr[i] = (char) (((int) arr[i] + n - 97) % 26 + 97);
        pen.print(arr[i]);
        pen.flush();
        arr[i] = MyArray2;
      }
      pen.println("");
      pen.flush();
    }
  }

  /*
   * Pre Condition: arr a char array, input a string of alphabetic characters, key a string of
   * alphabetic characters 
   * Post Condition: Prints out 25 potential decodes of the Caesar Cipher
   */
  public static void Decode(char arr[], String input) {
    PrintWriter pen = new PrintWriter(System.out, true);

    for (int n = 0; n < 26; n++) {
      pen.println("n = " + n + ": ");
      for (int i = 0; i < input.length(); i++) {
        char MyArray2 = arr[i];
        arr[i] = (char) ((((int) arr[i] - n - 97 + 26) % 26 + 97));
        pen.print(arr[i]);
        pen.flush();
        arr[i] = MyArray2;
      }
    }
    pen.println("");
    pen.flush();
  }
}
