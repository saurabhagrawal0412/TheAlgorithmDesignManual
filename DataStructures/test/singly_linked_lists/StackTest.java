package singly_linked_lists;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

  private Stack<Integer> stack;
  private final int STACK_SIZE = 10;
  private final int UPPER_BOUND = 100;

  @Before
  public void setUp() throws Exception {
    stack = new Stack<>();
  }

  @After
  public void tearDown() throws Exception {
    stack = null;
  }

  private void pushData() {
    Random rand = new Random();
    for (int i = 0; i < STACK_SIZE; i++) {
      stack.push(rand.nextInt(UPPER_BOUND));
    }
  }

  private void popData() {
    for (int i = 0; i < STACK_SIZE; i++) {
      stack.pop();
    }
  }

  @Test
  public void testIsEmpty() {
    assertTrue(stack.isEmpty());
    pushData();
    assertFalse(stack.isEmpty());
  }

  @Test
  public void testPush() {
    pushData();
    assertTrue(true);
  }

  @Test(expected = RuntimeException.class)
  public void testPop() {
    pushData();
    popData();
    stack.pop();
  }

  @Test
  public void testTop() {
    pushData();
    Integer item = new Integer(500);
    stack.push(item);
    assertEquals(item, stack.top());
  }

}
