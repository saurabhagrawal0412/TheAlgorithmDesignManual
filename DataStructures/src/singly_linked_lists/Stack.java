package singly_linked_lists;

public class Stack<T> {
  private SinglyLinkedList<T> list;
  private final String STACK_EMPTY_MSG = "Stack is empty";
  
  public Stack() {
    list = new SinglyLinkedList<>();
  }
  
  public boolean isEmpty() {
    return list.isEmpty();
  }
  
  public void push(T item) {
    list.insert(item);
  }
  
  public T pop() {
    if (isEmpty()) {
      throw new RuntimeException(STACK_EMPTY_MSG);
    }
    return list.deleteAtIndex(0);
  }
  
  public T top() {
    if (isEmpty()) {
      throw new RuntimeException(STACK_EMPTY_MSG);
    }
    return list.get(0);
  }
}
