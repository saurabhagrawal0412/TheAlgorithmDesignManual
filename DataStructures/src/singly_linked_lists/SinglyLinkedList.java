package singly_linked_lists;

public class SinglyLinkedList<T> {
  private SinglyLinkedListNode<T> head;
  private int size;
  private final String ITEM_NULL_MSG = "Item is null";
  private final String INCORRECT_INDEX_MSG = "Incorrect index";
  private final String QUEUE_EMPTY_MSG = "Queue is empty";

  private static class SinglyLinkedListNode<T> {
    T item;
    SinglyLinkedListNode<T> next;

    SinglyLinkedListNode(final T item) {
      this.item = item;
    }

    SinglyLinkedListNode(final T item, final SinglyLinkedListNode<T> nextNode) {
      this(item);
      this.next = nextNode;
    }

    SinglyLinkedListNode(final T item, final SinglyLinkedListNode<T> prevNode, final SinglyLinkedListNode<T> nextNode) {
      this(item, nextNode);
      prevNode.next = this;
    }
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  private SinglyLinkedListNode<T> getNodeAtIndex(final int index) {
    SinglyLinkedListNode<T> curr = head;
    for (int i = 0; i < index; i++) {
      curr = curr.next;
    }
    return curr;
  }

  private SinglyLinkedListNode<T> getPreviousNode(final T item) {
    SinglyLinkedListNode<T> prev = head;
    SinglyLinkedListNode<T> curr = head.next;
    while (curr != null) {
      if (curr.item == item) {
        return prev;
      }
      prev = curr;
      curr = curr.next;
    }
    return null;
  }

  public void insert(final T item) {
    if (item == null) {
      throw new NullPointerException(ITEM_NULL_MSG);
    }
    if (isEmpty()) {
      head = new SinglyLinkedListNode<T>(item);
    } else {
      SinglyLinkedListNode<T> curr = new SinglyLinkedListNode<T>(item, head);
      head = curr;
    }
    size++;
  }

  public void insertAtIndex(final int index, final T item) {
    if (item == null) {
      throw new NullPointerException(ITEM_NULL_MSG);
    } else if (index < 0 || index >= size) {
      throw new RuntimeException(INCORRECT_INDEX_MSG);
    }
    if (index == 0) {
      SinglyLinkedListNode<T> node = new SinglyLinkedListNode<T>(item, head);
      head = node;
    } else {
      SinglyLinkedListNode<T> prev = getNodeAtIndex(index - 1);
      SinglyLinkedListNode<T> next = prev.next;
      new SinglyLinkedListNode<>(item, prev, next);
    }
    size++;
  }

  public boolean delete(final T item) {
    if (item == null) {
      throw new NullPointerException(ITEM_NULL_MSG);
    } else if (isEmpty()) {
      throw new RuntimeException(QUEUE_EMPTY_MSG);
    }
    if (head.item == item) {
      head = head.next;
      size--;
      return true;
    }
    SinglyLinkedListNode<T> prev = getPreviousNode(item);
    if (prev == null) {
      return false;
    }
    SinglyLinkedListNode<T> curr = prev.next;
    prev.next = curr.next;
    size--;
    return true;
  }

  public T deleteAtIndex(final int index) {
    if (index < 0 || index >= size) {
      throw new RuntimeException(INCORRECT_INDEX_MSG);
    } else if (isEmpty()) {
      throw new RuntimeException(QUEUE_EMPTY_MSG);
    }
    T item = null;
    if (index == 0) {
      item = head.item;
      head = head.next;
    } else {
      SinglyLinkedListNode<T> prevNode = getNodeAtIndex(index - 1);
      SinglyLinkedListNode<T> currNode = prevNode.next;
      item = currNode.item;
      prevNode.next = currNode.next;
    }
    size--;
    return item;
  }

  public int indexOf(final T item) {
    if (item == null) {
      throw new NullPointerException(ITEM_NULL_MSG);
    } else if (isEmpty()) {
      throw new RuntimeException(QUEUE_EMPTY_MSG);
    }
    int index = 0;
    SinglyLinkedListNode<T> curr = head;
    while (curr != null) {
      if (curr.item == item) {
        return index;
      }
      curr = curr.next;
      index++;
    }
    return -1;
  }

  public T get(final int index) {
    if (index < 0 || index >= size) {
      throw new RuntimeException(INCORRECT_INDEX_MSG);
    }
    return getNodeAtIndex(index).item;
  }
}
