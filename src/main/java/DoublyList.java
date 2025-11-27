import java.util.NoSuchElementException;

public class DoublyList implements DoublyLinkedList {

    // Node class for the linked list
    static class Node<T> {
        T data;
        Node<T> next;
        Node <T> prev;

        Node (T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    int size;

    // Doubly Linked list constructor
    public DoublyList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Add an element to the front of the linked list
     * @param data The element to be added
     */
    @Override
    public void addFirst(Object data) {
        if (data == null) {
            throw new NullPointerException();
        }

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;

    }

    /**
     * Add an element to the rear of the linked list
     * @param data The element to be added
     */
    @Override
    public void addLast(Object data) {
        if (data == null) {
            throw new NullPointerException();
        }
        Node newNode = new Node(data);

        if (tail == null) {
            head = newNode;
            tail = newNode;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }

    /**
     * Insert an element into the linked list at an index
     * @param index The index to be added at
     * @param data The item to be added
     */
    @Override
    public void insertAt(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (data == null) {
            throw new NullPointerException();
        }
        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }


        Node newNode = new Node(data);
        Node curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        newNode.next = curr;
        newNode.prev = curr.prev;
        curr.prev.next = newNode;
        curr.prev = newNode;
        size++;

    }

    /**
     * Remove the first element of the linked list
     * @return Object, the element that was removed
     */
    @Override
    public Object removeFirst() {
        if (size == 0 || head == null) {
            throw new NoSuchElementException();
        }

        Node curr = head;
        head = head.next;
        curr.prev = null;
        curr.next = null;
        size--;
        return curr.data;
    }


    /**
     * Remove the last element of the linked list
     * @return Object, the element that was removed
     */
    @Override
    public Object removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Node last = tail;
        tail = tail.prev;
        tail.next = null;
        last.prev = null;
        size--;
        return last.data;
    }

    /**
     * Remove an element at an index
     * @param index The index to remove at
     * @return Object, the element that was removed
     */
    @Override
    public Object removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            return removeFirst();
        }
        else if (index == size) {
            return removeLast();
        }

        int count = 0;
        Node curr = head;

        while (curr != null && count < index) {
            curr = curr.next;
            count++;
        }

        Node prev = curr.prev;
        prev.next = curr.next;
        curr.next.prev = prev;

        curr.next = null;
        curr.prev = null;
        size--;

        return curr.data;
    }

    /**
     * Get the first element
     * @return Object, the first element
     */
    @Override
    public Object getFirst() {
        return head.data;
    }

    /**
     * Get the last element
     * @return Object, the last element
     */
    @Override
    public Object getLast() {
        return tail.data;
    }

    /**
     * Get the element at a given index
     * @param index The index to search for
     * @return Object, the element at the index
     */
    @Override
    public Object getAt(int index) {
        int count = 0;

        Node curr = head;
        while (curr != null && count < index) {
            curr = curr.next;
            count++;
        }

        if (curr != null) {
            return curr.data;
        }
        return null;
    }

    /**
     * Get the size of the linked list
     * @return size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Check if the linked list is empty
     * @return boolean
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Delete the linked list
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Check if the linked list contains data
     * @param data The element to search for
     * @return boolean
     */
    @Override
    public boolean contains(Object data) {
        if (data == null || size == 0) {
            throw new NullPointerException();
        }
        Node curr = head;

        while (curr != null) {
            if (curr.data.equals(data)) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    /**
     * Get the index of element data
     * @param data The element to search for
     * @return int
     */
    @Override
    public int indexOf(Object data) {
        if (data == null || size == 0) {
            throw new NullPointerException();
        }
        Node curr = head;
        int index = 0;

        while (curr != null) {
            if (curr.data.equals(data)) {
                return index;
            }
            curr = curr.next;
            index++;
        }

        return -1;
    }

}
