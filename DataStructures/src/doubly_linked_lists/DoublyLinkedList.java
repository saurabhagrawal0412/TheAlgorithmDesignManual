package doubly_linked_lists;

public class DoublyLinkedList<T> {
  private DoublyLinkedListNode<T> head, tail;
  private int size;
  private final String NULL_ITEM_MSG = "Item is null";
  private final String INVALID_INDEX_MSG = "Invalid index";
  private final String EMPTY_LIST_MSG = "List is empty";

  private static class DoublyLinkedListNode<T> {
    T item;
    DoublyLinkedListNode<T> prev, next;

    DoublyLinkedListNode(final T item) {
      this.item = item;
    }

    public DoublyLinkedListNode(final T item, final DoublyLinkedListNode<T> prevNode,
        final DoublyLinkedListNode<T> nextNode) {
      this(item);
      if (prevNode != null) {
        prevNode.next = this;
        this.prev = prevNode;
      }
      if (nextNode != null) {
        nextNode.prev = this;
        this.next = nextNode;
      }
    }
  }

  public DoublyLinkedList() {
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  private boolean isInvalidInsertIndex(final int index) {
    return (index < 0 || index > size);
  }

  private boolean isInvalidDeleteIndex(final int index) {
    return (index < 0 || index >= size);
  }

  private void createFirstNode(final T item) {
    head = new DoublyLinkedListNode<T>(item);
    tail = head;
    size = 1;
  }

  private DoublyLinkedListNode<T> getNodeAtIndex(final int index) {
    DoublyLinkedListNode<T> node = null;
    if (index < (size - 1 - index)) {
      node = head;
      for (int currIndex = 0; currIndex < index; currIndex++) {
        node = node.next;
      }
    } else {
      node = tail;
      for (int currIndex = size - 1; currIndex > index; currIndex--) {
        node = node.prev;
      }
    }
    return node;
  }

  public void insertAtHead(final T item) {
    if (item == null) {
      throw new NullPointerException(NULL_ITEM_MSG);
    }
    if (isEmpty()) {
      createFirstNode(item);
    } else {
      DoublyLinkedListNode<T> node = new DoublyLinkedListNode<T>(item, null, head);
      head = node;
      size++;
    }
  }

  public void insertAtTail(final T item) {
    if (item == null) {
      throw new NullPointerException(NULL_ITEM_MSG);
    }
    if (isEmpty()) {
      createFirstNode(item);
    } else {
      DoublyLinkedListNode<T> node = new DoublyLinkedListNode<T>(item, tail, null);
      tail = node;
      size++;
    }
  }

  public void insertAtIndex(final int index, final T item) {
    if (item == null) {
      throw new NullPointerException(NULL_ITEM_MSG);
    } else if (isInvalidInsertIndex(index)) {
      throw new RuntimeException(INVALID_INDEX_MSG);
    }
    if (isEmpty()) {
      createFirstNode(item);
    } else if (index == 0) {
      insertAtHead(item);
    } else if (index == size) {
      insertAtTail(item);
    } else {
      DoublyLinkedListNode<T> prevNode = getNodeAtIndex(index - 1);
      DoublyLinkedListNode<T> nextNode = prevNode.next;
      new DoublyLinkedListNode<>(item, prevNode, nextNode);
      size++;
    }
  }

  public T get(final int index) {
    if (isInvalidInsertIndex(index)) {
      throw new RuntimeException(INVALID_INDEX_MSG);
    } else if (isEmpty()) {
      throw new RuntimeException(EMPTY_LIST_MSG);
    }
    return getNodeAtIndex(index).item;
  }

  public T deleteFromHead() {
    if (isEmpty()) {
      throw new RuntimeException(EMPTY_LIST_MSG);
    }
    T item = head.item;
    head = head.next;
    size--;
    return item;
  }

  public T deleteFromTail() {
    if (isEmpty()) {
      throw new RuntimeException(EMPTY_LIST_MSG);
    }
    T item = tail.item;
    tail = tail.prev;
    size--;
    return item;
  }

  public T deleteAtIndex(final int index) {
    if (isInvalidDeleteIndex(index)) {
      throw new RuntimeException(INVALID_INDEX_MSG);
    } else if (isEmpty()) {
      throw new RuntimeException(EMPTY_LIST_MSG);
    }
    if (index == 0) {
      return deleteFromHead();
    } else if (index == size - 1) {
      return deleteFromTail();
    } else {
      DoublyLinkedListNode<T> node = getNodeAtIndex(index);
      T item = node.item;
      DoublyLinkedListNode<T> prevNode = node.prev;
      DoublyLinkedListNode<T> nextNode = node.next;
      prevNode.next = nextNode;
      nextNode.prev = prevNode;
      size--;
      return item;
    }
  }

  public int indexOf(final T item) {
    if (item == null) {
      throw new NullPointerException(NULL_ITEM_MSG);
    } else if (isEmpty()) {
      throw new RuntimeException(EMPTY_LIST_MSG);
    }
    DoublyLinkedListNode<T> curr = head;
    int index = 0;
    while (curr != null) {
      if (curr.item == item) {
        return index;
      }
      curr = curr.next;
      index++;
    }
    return -1;
  }
}
