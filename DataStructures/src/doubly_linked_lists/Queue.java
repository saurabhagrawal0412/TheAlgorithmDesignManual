package doubly_linked_lists;

public class Queue<T> {
  private DoublyLinkedList<T> list;
  private final String QUEUE_EMPTY_MSG = "Queue is empty";
  
  public Queue() {
    list = new DoublyLinkedList<>();
  }
  
  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  public int size() {
    return list.size();
  }
  
  public void enqueue(T item) {
    list.insertAtTail(item);
  }
  
  public T dequeue() {
    if (isEmpty()) {
      throw new RuntimeException(QUEUE_EMPTY_MSG);
    }
    return list.deleteFromHead();
  }
}
