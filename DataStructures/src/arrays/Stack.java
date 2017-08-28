/**
 * FIFO structure for any type of objects
 */

package arrays;

/**
 * Class that stores and manipulates a stack for any object
 *
 * @param <T>
 *          Type of the Stack to be created
 */
public class Stack<T> {
  private Object[] array;
  private int top;

  /**
   * Constructor for creating stack of a particular size
   * 
   * @param size
   *          Size of the stack to be created
   */
  public Stack(final int size) {
    array = new Object[size];
    top = 0;
  }

  /**
   * Method that pushes an item at the top of stack
   * 
   * @param item
   *          Item to be pushed
   */
  public void push(T item) {
    if (isFull()) {
      throw new RuntimeException("Stack is full, can't perform push");
    }
    array[top++] = item;
  }

  /**
   * Method that removes and returns the item at the top of stack
   * 
   * @return Item at the top
   */
  @SuppressWarnings("unchecked")
  public T pop() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty, can't perform pop");
    }
    return (T) array[--top];
  }

  /**
   * Similar to pop(), but does not remove the item from the top of the stack
   * 
   * @return Item at the top
   */
  @SuppressWarnings("unchecked")
  public T top() {
    if (isEmpty()) {
      throw new RuntimeException("Stack is empty, can't perform top");
    }
    return (T) array[top];
  }

  /**
   * Returns size of the stack
   * 
   * @return Size of the stack
   */
  public int size() {
    return top;
  }

  /**
   * Determines whether the stack is empty or not
   * 
   * @return true: if stack is empty, false: otherwise
   */
  public boolean isEmpty() {
    return (top == 0) ? true : false;
  }

  /**
   * Determines whether the stack is full or not
   * 
   * @return true: if stack is full, false: otherwise
   */
  public boolean isFull() {
    return (top >= array.length) ? true : false;
  }
}
