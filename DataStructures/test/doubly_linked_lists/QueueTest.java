package doubly_linked_lists;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {

  private Queue<Integer> queue;
  private static int MAX_SIZE = 10;
  private static int MAX_VAL = 100;

  @Before
  public void setUp() throws Exception {
    queue = new Queue<>();
  }

  @After
  public void tearDown() throws Exception {
    queue = null;
  }

  private void fillQueue() {
    Random rand = new Random();
    for (int i = 0; i < MAX_SIZE; i++) {
      queue.enqueue(rand.nextInt(MAX_VAL));
    }
  }
  
  private void emptyQueue() {
    for (int i = 0; i < MAX_SIZE; i++) {
      queue.dequeue();
    }
  }

  @Test
  public void testIsEmpty() {
    assertTrue(queue.isEmpty());
    fillQueue();
    assertFalse(queue.isEmpty());
  }

  @Test
  public void testSize() {
    assertEquals(0, queue.size());
    fillQueue();
    assertEquals(MAX_SIZE, queue.size());
  }

  @Test
  public void testEnqueue() {
    fillQueue();
    assertTrue(true);
  }

  @Test(expected = RuntimeException.class)
  public void testDequeue() {
    fillQueue();
    emptyQueue();
    queue.dequeue(); // Executing dequeue on empty queue will cause exception
  }

}
