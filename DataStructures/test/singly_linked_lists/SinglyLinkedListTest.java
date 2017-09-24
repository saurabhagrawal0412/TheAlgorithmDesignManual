package singly_linked_lists;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import singly_linked_lists.SinglyLinkedList;

public class SinglyLinkedListTest {

  private final int LIST_SIZE = 10;
  private SinglyLinkedList<Integer> list;
  private final int MAX_LIMIT = 100;

  @Before
  public void setUp() throws Exception {
    list = new SinglyLinkedList<>();
  }

  @After
  public void tearDown() throws Exception {
    list = null;
  }

  private void fillList() {
    Random rand = new Random();
    for (int i = 0; i < LIST_SIZE; i++) {
      list.insert(rand.nextInt(MAX_LIMIT));
    }
  }

  private void emptyList() {
    int temp;
    for (int i = 0; i < LIST_SIZE; i++) {
      temp = list.get(0);
      list.delete(temp);
    }
  }

  @Test
  public void testIsEmpty() {
    assertTrue(list.isEmpty());
    list.insert(5);
    assertFalse(list.isEmpty());
  }

  @Test
  public void testSize() {
    assertEquals(0, list.size());
    fillList();
    assertEquals(LIST_SIZE, list.size());
  }

  @Test
  public void testInsert() {
    fillList();
    assertTrue(true);
  }
  
  @Test
  public void testInsertAtIndex() {
    fillList();
    Integer item = new Integer(200);
    list.insertAtIndex(5, item);
    assertEquals(item, list.get(5));
  }

  @Test
  public void testDelete() {
    fillList();
    emptyList();
    assertTrue(true);
  }
  
  @Test
  public void testDeleteAtIndex() {
    Integer item = new Integer(MAX_LIMIT + 1);
    list.insert(item);
    fillList();
    assertEquals(LIST_SIZE + 1, list.size());
    assertEquals(item, list.deleteAtIndex(LIST_SIZE));
    assertEquals(LIST_SIZE, list.size());
  }

  @Test
  public void testIndexOf() {
    list.insert(MAX_LIMIT + 1);
    fillList();
    assertEquals(LIST_SIZE, list.indexOf(MAX_LIMIT + 1));
  }

  @Test
  public void testGet() {
    list.insert(MAX_LIMIT + 1);
    fillList();
    assertEquals(new Integer(MAX_LIMIT + 1), list.get(LIST_SIZE));
  }
}
