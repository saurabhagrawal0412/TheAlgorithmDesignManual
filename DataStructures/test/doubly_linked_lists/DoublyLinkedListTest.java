package doubly_linked_lists;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DoublyLinkedListTest {

  private final int LIST_SIZE = 10;
  private DoublyLinkedList<Integer> list;
  private final int MAX_LIMIT = 100;
  
  @Before
  public void setUp() throws Exception {
    list = new DoublyLinkedList<>();
  }

  @After
  public void tearDown() throws Exception {
    list = null;
  }
  
  private void fillList() {
    Random rand = new Random();
    for (int i = 0; i < LIST_SIZE; i++) {
      list.insertAtTail(rand.nextInt(MAX_LIMIT));
    }
  }
  
  @Test
  public void testIsEmpty() {
    assertTrue(list.isEmpty());
    list.insertAtHead(1);
    assertFalse(list.isEmpty());
  }

  @Test
  public void testSize() {
    assertEquals(0, list.size());
    fillList();
    assertEquals(LIST_SIZE, list.size());
  }

  @Test
  public void testInsertAtHead() {
    Integer item1 = new Integer(MAX_LIMIT + 100);
    Integer item2 = new Integer(MAX_LIMIT + 200);
    list.insertAtHead(item1);
    list.insertAtHead(item2);
    assertEquals(1, list.indexOf(item1));
    assertEquals(0, list.indexOf(item2));
  }

  @Test
  public void testInsertAtTail() {
    Integer item1 = new Integer(MAX_LIMIT + 100);
    Integer item2 = new Integer(MAX_LIMIT + 200);
    list.insertAtTail(item1);
    list.insertAtTail(item2);
    assertEquals(0, list.indexOf(item1));
    assertEquals(1, list.indexOf(item2));
  }

  @Test
  public void testInsertAtIndex() {
    fillList();
    Integer item = new Integer(MAX_LIMIT + 100);
    list.insertAtIndex(LIST_SIZE/2, item);
    assertEquals(LIST_SIZE/2, list.indexOf(item));
  }

  @Test
  public void testGet() {
    fillList();
    Integer item = new Integer(MAX_LIMIT + 100);
    list.insertAtIndex(LIST_SIZE/2, item);
    assertEquals(item, list.get(LIST_SIZE/2));
  }

  @Test
  public void testDeleteFromHead() {
    Integer item1 = new Integer(MAX_LIMIT + 100);
    Integer item2 = new Integer(MAX_LIMIT + 200);
    list.insertAtHead(item1);
    list.insertAtHead(item2);
    assertEquals(item2, list.deleteFromHead());
    assertEquals(item1, list.deleteFromHead());
  }

  @Test
  public void testDeleteFromTail() {
    Integer item1 = new Integer(MAX_LIMIT + 100);
    Integer item2 = new Integer(MAX_LIMIT + 200);
    list.insertAtTail(item1);
    list.insertAtTail(item2);
    assertEquals(item2, list.deleteFromTail());
    assertEquals(item1, list.deleteFromTail());
  }

  @Test
  public void testDeleteAtIndex() {
    fillList();
    Integer item = new Integer(MAX_LIMIT + 100);
    list.insertAtIndex(LIST_SIZE/2, item);
    assertEquals(item, list.deleteAtIndex(LIST_SIZE/2));
  }

  @Test
  public void testIndexOf() {
    fillList();
    Integer item = new Integer(MAX_LIMIT + 100);
    list.insertAtIndex(LIST_SIZE/2, item);
    assertEquals(LIST_SIZE/2, list.indexOf(item));
  }

}
