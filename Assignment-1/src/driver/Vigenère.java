/*
 * Sources
 * https://stackoverflow.com/questions/10813154/how-do-i-convert-a-number-to-a-letter-in-java
 * https://beginnersbook.com/2013/12/java-string-tochararray-method-example/ 
 * Reilly Grant pointed ustowards the above command on turning strings into arrays (even though it 
 *   was in the Assignment)
 * https://rosettacode.org/wiki/Vigen%C3%A8re_cipher#Java 
 * Jonathan Sadun helped with arithmetic for looping from a to z when decoding and typing on the 
 *   command line
 * https://www.geeksforgeeks.org/difference-equals-method-java/
 */

package driver;

import java.io.PrintWriter;

public class Vigenère {

  public static void main(String[] args) throws Exception {

    PrintWriter pen = new PrintWriter(System.out, true);

    if (args.length != 3) { // test if input has two input words
      pen.println("Incorrect number of parameters");
      pen.flush();
    } else { // if it has the correct number of parameters
      char[] arr = args[1].toCharArray(); // convert the word to en/decode into an array

      int i = 0;
      boolean done = false;
      while (arr.length > i) { // see if there is any upper case letter
        if (Character.isUpperCase(arr[i])) {
          done = true;
        }
        i++;
      }
      // Call encode or decode if the user types in the right parameters
      // otherwise throw out a helpful error message indicating that the the text has
      //  an uppercase or an incorrect command
      if ((args[0].equals("encode")) && (done == false)) {
        Encode(arr, args[1], args[2]);
      } else if ((args[0].equals("decode")) && (done == false)) {
        Decode(arr, args[1], args[2]);
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
   * Pre Condition: arr a char array, input a string of alphabetic characters, key a string of
   * alphabetic characters 
   * Post Condition: Prints out the string input as encoded by key
   */
  public static void Encode(char arr[], String input, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);
    
    char[] MyKey = key.toCharArray();
    int counter = 0;
    for (int m = 0; m < arr.length; m++) {
      // reset key back to the first letter when key is shorter than input
      if (counter == (MyKey.length)) {
        counter = 0;
      }
      // encodes input
      arr[m] = (char) ((((int) arr[m]) + ((int) MyKey[counter]) - 2 * 97) % 26 + 97); 
      pen.print(arr[m]);
      pen.flush();
      counter++;
    }
  }


  /*
   * Pre Condition: arr2 a char array, input a string of alphabetic characters, key a string of
   * alphabetic characters 
   * Post Condition: Prints out the string input as encoded by key
   */
  public static void Decode(char arr2[], String input, String key) {
    PrintWriter pen = new PrintWriter(System.out, true);

    char[] MyKey = key.toCharArray();
    int counter = 0;

    for (int m = 0; m < arr2.length; m++) {
      // reset key back to the first letter when key is shorter than input
      if (counter == (MyKey.length)) {
        counter = 0;
      }
      // decodes input
      arr2[m] = (char) ((((int) arr2[m]) - ((int) MyKey[counter]) + 26) % 26 + 97); 
      pen.print(arr2[m]);
      pen.flush();
      counter++;
    }
  }

}

