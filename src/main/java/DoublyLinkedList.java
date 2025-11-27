/**
 * Interface for Doubly Linked List
 * @param <T> A generic data type
 */
public interface DoublyLinkedList<T> {
    /**
     * Add an element to the head of the linked list
     * @param data
     */
    void addFirst(T data);

    /**
     * Add an element to the tail of the linked list
     * @param data
     */
    void addLast(T data);

    /**
     * Insert an element data at a given index in the linked list
     * @param index
     * @param data
     */
    void insertAt(int index, T data);

    /**
     * Remove the first element
     * @return T, the element that was removed
     */
    T removeFirst();

    /**
     * Remove the last element
     * @return T, the element that was removed
     */
    T removeLast();

    /**
     * Remove an element at a certain index
     * @param index
     * @return T, the element that was removed
     */
    T removeAt(int index);

    /**
     * Get the first element in the linked list
     * @return T, the element that was retrieved
     */
    T getFirst();

    /**
     * Get the last element of the linked list
     * @return T, the element that was retrieved
     */
    T getLast();

    /**
     * Get an element at a certain index
     * @param index
     * @return T, the element that was retrieved
     */
    T getAt(int index);

    /**
     * Get the size of the linked list
     * @return The size of the linked list
     */
    int size();

    /**
     * Check if the linked list is empty or not
     * @return boolean
     */
    boolean isEmpty();

    /**
     * Delete the linked list
     */
    void clear();

    /**
     * Check if the linked list contains data
     * @param data
     * @return boolean
     */
    boolean contains(T data);

    /**
     * Get the index of data in the linked list
     * @param data
     * @return int
     */
    int indexOf(T data);
}
