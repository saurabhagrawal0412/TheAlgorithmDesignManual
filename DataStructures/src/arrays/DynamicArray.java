/**
 * An array that resizes dynamically
 * Advantages:
 *  - An array that provides flexibility of size like a list
 *  - Provides O(1) access to elements
 * Implementation
 *  - Array doubles in size when it gets full
 *  - Array halves in size when it gets less than half
 * Complexity
 *  - Amortized complexity of O(1) for insertion and deletion
 */

package arrays;

/**
 * Class that stores and manipulates a dynamic array of any object
 * 
 * @param <T>
 *          Type of the DynamicArray to be created
 */
public class DynamicArray<T> {
  private Object[] array;
  private int currentLength;

  /**
   * Default constructor
   */
  public DynamicArray() {
    this(1);
  }

  /**
   * Constructor to create Dynamic array of a specific size
   * 
   * @param size
   *          Size of the dynamic array to be created
   */
  public DynamicArray(final int size) {
    if (size <= 0) {
      throw new RuntimeException("Illegal size provided for dynamic array");
    }
    currentLength = 0;
    array = new Object[size];
  }

  /**
   * Private method to validate an index
   * 
   * @param index
   *          Index to be validated
   * @return true if index is invalid, false otherwise
   */
  private boolean isInvalidIndex(final int index) {
    return (index < 0 || index >= currentLength) ? true : false;
  }

  /**
   * Method to add an item to the dynamic array Replaces the current array with
   * an array of double size if the current array gets full
   * 
   * @param item
   *          Item object to be added to the dynamic array
   */
  public void addItem(T item) {
    if (currentLength == array.length) {
      Object[] newArray = new Object[array.length * 2];
      // Copying all elements of old array into new
      for (int i = 0; i < array.length; i++) {
        newArray[i] = array[i];
      }
      array = newArray;
    }
    array[currentLength++] = item;
  }

  /**
   * Method to get item at a specific index from the dynamic array
   * 
   * @param index
   *          Index of the item to be fetched
   * @return Item at the given index
   */
  @SuppressWarnings("unchecked")
  public T getItem(int index) {
    if (isInvalidIndex(index)) {
      throw new RuntimeException("Illegal index");
    }
    return (T) array[index];
  }

  /**
   * Method to remove and return an item at a provided index
   * 
   * @param index
   *          Index of the item that need to be removed
   * @return Item that is removed
   */
  public T removeItem(final int index) {
    if (isInvalidIndex(index)) {
      throw new RuntimeException("Illegal index");
    }
    currentLength--;
    @SuppressWarnings("unchecked")
    T item = (T) array[index];

    /*
     * If the current length of array falls below 1/4 of the max size, we create
     * a new array of half the current array size, so that the new array will be
     * only half full
     */
    if (currentLength <= array.length / 4) {
      Object[] newArray = new Object[array.length / 2];
      for (int i = 0, j = 0; i < currentLength; i++, j++) {
        // Skipping the index to be removed
        if (j == index) {
          j++;
        }
        newArray[i] = array[j];
      }
      array = newArray;
    } else {
      for (int i = index + 1; i < currentLength; i++) {
        array[i - 1] = array[i];
      }
    }
    return item;
  }

  /**
   * Returns the size of the dynamic array
   * 
   * @return Dynamic array size
   */
  public int size() {
    return currentLength;
  }

  /**
   * Returns whether the dynamic array is empty or not
   * 
   * @return Returns true if the dynamic array is empty, false otherwise
   */
  public boolean isEmpty() {
    return (currentLength == 0) ? true : false;
  }
}
