package exam1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests of MathUtils.average
 * 
 * @author Tessa Ter
 * @author Jay Unit
 */
class AverageTest {

	@Test
  void testBasic() {
    assertEquals(11, MathUtils.averageNew(new long[] {10,11,12}));
  }
 // Testing overflow
  void testSimpleOverflow() {
    long val = (Long.MAX_VALUE / 2) + 3;
    assertEquals(val, MathUtils.averageNew(new long[] { val, val }));
    //assertEquals(val, MathUtils.average(new long[] { val, val, val }));
    assertEquals(val, MathUtils.averageNew(new long[] { val, val, val }));
  }
  @Test
 // Testing average of (10*(10+1)/2)/10
  void testOverflow10() {
	  long val[] = new long[10];
	  long count = 1;
	  long answer = 5;
	  for(int i = 0; val.length > i; i++) {
		  val[i] = count;
		  count++;
		  //System.out.println("TEST:"+ val[i]);
	  }
	  // System.out.println(val[0]);
	  //n(n+1)/2 
	  answer = (10*(10+1)/2)/10;
	  assertEquals(answer,MathUtils.averageNew(val));
  }
  @Test
 // (100*(100+1)/2)/100
  void testOverflow100() {
	  long val[] = new long[100];
	  long count = 1;
	  long answer = 50;
	  for(int i = 0; val.length > i; i++) {
		  val[i] = count;
		  count++;
	  }
	  //n(n+1)/2 
	 
	  assertEquals(answer,MathUtils.averageNew(val));
  }
  @Test
  // Test negative numbers
  void testOverflowNegative100() {
	  long val[] = new long[100];
	  long count = 1;
	  long answer = -50;
	  for(int i = 0; val.length > i; i++) {
		  val[i] = -count;
		  count++;
	  }
	  //n(n+1)/2 
	 
	  assertEquals(answer,MathUtils.averageNew(val));
  }
  @Test
  // testing the average of (1000*(1000+1)/2)/1000
  void testOverflow1000() {
	  long val[] = new long[1000];
	  long count = 1;
	  long answer = 500;
	  for(int i = 0; val.length > i; i++) {
		  val[i] = count;
		  count++;
	  }
	  //n(n+1)/2 
	  long myAnswer= (val.length*(val.length+1)/2)/val.length;
	  System.out.println("TEST: "+ myAnswer);
	  System.out.println("My answer 1000: " + answer);
	  System.out.println("Caluate answer 1000: "+ MathUtils.average(val));
	  System.out.println();
	  assertEquals(answer,MathUtils.averageNew(val));
  }
  

 @Test
 // Testing the average of (1000000*(1000000+1)/2)/1000000
  void testOverflow10000000() {
	  long values[] = new long[1000000];
	  long count = 1;
	  long myAnswer = 500000;
	  for(int i = 0; values.length > i; i++) {
		  values[i] = count;
		  count++;
	  }

	  System.out.println("TEST: "+ myAnswer);
	  System.out.println("Caluate answer 1000000: "+ MathUtils.average(values));
	  System.out.println();
	  assertEquals(myAnswer,MathUtils.averageNew(values));
  }
  @Test
 // Testing for underflow
  void testUnderflowNegative() { 
	  long val = (Long.MIN_VALUE / 2)+3;
	 // assertEquals(val, MathUtils.average(new long[] { val, val }));
	  assertEquals(val, MathUtils.averageNew(new long[] { val, val, val }));
  }
 // Testing with negative and postive number
  @Test
  void testMixed() { 
	  long val = 1;
	  long values[] = new long[] {1,2,3,-1,5,6,8,-2,-5};
	  assertEquals(val, MathUtils.averageNew(values));
	 // assertEquals(val, MathUtils.averageNew(new long[] { val, val, val }));
  }
  @Test
 // Testing with larger array of positive and negative problem
  void testMixedlarge() { 
	  long answer = 0;
	  long values[] = new long[15];
	  for(int i = 0; i<10; i++) {
		  values[i] = i;
		  answer+=i;
	  }
	  for(int j = 5; j<5;j++) {
		  values[j] = -j;
		  answer+=j;
	  }
	  answer = answer / 15; 
	  assertEquals(answer, MathUtils.averageNew(values));
	 // assertEquals(val, MathUtils.averageNew(new long[] { val, val, val }));
  }
  @Test
  // Testing for zero
  void testZero() {
	  long values[] = new long[] {0, 0, 0};
	  assertEquals(0, MathUtils.averageNew(values));
	  assertEquals(0, MathUtils.averageNew(new long[] { 0, 0 }));
  }
  
  

  
  
 

} // class AverageTest
