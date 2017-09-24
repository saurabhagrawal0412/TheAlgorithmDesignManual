package arrays;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {
  private Queue<String> queue;
  private final int queueSize = 5;

  @Before
  public void setUp() throws Exception {
    queue = new Queue<>(queueSize);
  }

  @After
  public void tearDown() throws Exception {
    queue = null;
  }

  private void fillQueue() {
    for (int i = 0; i < queueSize; i++) {
      queue.enqueue(i + " ");
    }
  }
  
  private void emptyQueue() {
    for (int i = 0; i < queueSize; i++) {
      queue.dequeue();
    }
  }
  
  @Test
  public void testIsEmpty() {
    assertTrue(queue.isEmpty());
    queue.enqueue("test data");
    assertFalse(queue.isEmpty());
  }

  @Test
  public void testIsFull() {
    assertFalse(queue.isFull());
    fillQueue();
    assertTrue(queue.isFull());
  }

  @Test
  public void testGetCurrentSize() {
    assertEquals(0, queue.getCurrentSize());
    fillQueue();
    assertEquals(queueSize, queue.getCurrentSize());
    emptyQueue();
    assertEquals(0, queue.getCurrentSize());
  }
  
  @Test(expected = RuntimeException.class)
  public void testEnqueue() {
    fillQueue();
    queue.enqueue("This will cause RuntimeException");
  }

  @Test(expected = RuntimeException.class)
  public void testDequeue() {
    fillQueue();
    emptyQueue();
    queue.dequeue(); // This will cause RuntimeException
  }

}
