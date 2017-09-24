/**
 * This program performs unit tests on the DynamicArray class
 */
package arrays;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

/**
 * UnitTest class for DynamicArray
 */
public class DynamicArrayTest {
  private DynamicArray<Integer> testArray;
  private static final int MAX_SIZE = 10;

  /**
   * Tests all the operations on DynamicArray
   */
  @Test
  public void testOperations() {
    // testing object creation
    testArray = new DynamicArray<>();
    assertNotNull(testArray);

    // testing insertion
    Random rand = new Random();
    for (int i = 0; i < MAX_SIZE; i++) {
      testArray.addItem(rand.nextInt(MAX_SIZE * 10));
    }
    assertEquals(MAX_SIZE, testArray.size());

    // testing deletion
    for (int i = 0; i < MAX_SIZE; i++) {
      testArray.removeItem(0);
    }
    assertTrue(testArray.isEmpty());
  }

}
