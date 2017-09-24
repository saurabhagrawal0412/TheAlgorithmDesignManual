package arrays;

public class Queue<T> {
  private int head, tail;
  private int currSize;
  private final int maxSize;
  private Object[] queueData;

  public Queue(final int maxSize) {
    this.maxSize = maxSize;
    queueData = new Object[maxSize];
    this.head = 0;
    this.tail = -1;
    this.currSize = 0;
  }

  public boolean isEmpty() {
    return currSize == 0;
  }

  public boolean isFull() {
    return currSize == maxSize;
  }
  
  public int getCurrentSize() {
    return this.currSize;
  }

  public void enqueue(T item) {
    if (isFull()) {
      throw new RuntimeException("Queue is full");
    }
    tail = (tail + 1) % maxSize;
    queueData[tail] = item;
    currSize++;
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new RuntimeException("Queue is empty");
    }
    @SuppressWarnings("unchecked")
    T item = (T) queueData[head];
    head = (head + 1) % maxSize;
    currSize--;
    return item;
  }
}
