/**
 * This program performs unit tests on the Stack class
 */

package arrays;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import arrays.Stack;

/**
 * Unit test class to test Stack
 */
public class StackTest {
  private Stack<Integer> testStack;
  private static final int MAX_SIZE = 10;

  /**
   * This function is executed before execution of every test case
   * 
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    testStack = new Stack<>(MAX_SIZE);
  }

  /**
   * This function is executed after execution of every test case
   * 
   * @throws Exception
   */
  @After
  public void tearDown() throws Exception {
    testStack = null;
  }

  /**
   * Local method to insert data in the stack
   */
  private void insertData() {
    Random rand = new Random();
    for (int i = 0; i < MAX_SIZE; i++) {
      testStack.push(rand.nextInt(MAX_SIZE) * 10);
    }
  }

  /**
   * Tests the method push() on Stack
   */
  @Test
  public void testPush() {
    insertData();
    assertEquals(MAX_SIZE, testStack.size());
  }

  /**
   * Tests the method pop() on Stack
   */
  @Test
  public void testPop() {
    insertData();
    for (int i = 0; i < MAX_SIZE; i++) {
      testStack.pop();
    }
    assertTrue(testStack.isEmpty());
  }
}
