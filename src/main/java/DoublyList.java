import java.util.NoSuchElementException;

public class DoublyList implements DoublyLinkedList {

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

    public DoublyList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(Object data) {
        Node newNode = new Node(data);

        newNode.next = head.next;
        newNode.prev = head;
        head = newNode;
        size++;

    }

    @Override
    public void addLast(Object data) {
        Node newNode = new Node(data);

        newNode.prev = tail.prev;
        tail.prev = newNode;
        newNode.next = tail;
        size++;
    }

    @Override
    public void insertAt(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Node newNode = new Node(data);
        Node curr = head;

        while (curr.next != null) {
            if (count == index) {
                Node next = curr.next;
                next.prev = newNode;
                newNode.next = next;
                curr.next = newNode;
                newNode.prev = curr;
            }
            count++;
            curr = curr.next;
        }

    }

    @Override
    public Object removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Node curr = head;
        head = head.next;
        curr.prev = null;
        curr.next = null;
        size--;
        return curr.data;
    }

    @Override
    public Object removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        Node last = tail.prev;
        Node lastPrev = last.prev;
        lastPrev.next = tail;
        last.prev = null;
        last.next = null;
        return last.data;
    }

    @Override
    public Object removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        int count = 0;
        Node curr = head;

        while (curr.next != null) {
            if (count == index) {
                Node next = curr.next;
                Node prev = curr.prev;

                prev.next = next;
                next.prev = prev;

                curr.next = null;
                curr.prev = null;
                return curr.data;
            }

            count++;
            curr = curr.next;
        }
        return null;
    }

    @Override
    public Object getFirst() {
        return head.data;
    }

    @Override
    public Object getLast() {
        return tail.data;
    }

    @Override
    public Object getAt(int index) {
        int count = 0;

        Node curr = head;

        while (curr.next != null) {
            if (count == index) {
                return curr.data;
            }
            count++;
            curr = curr.next;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    @Override
    public boolean contains(Object data) {
        Node curr = head;

        while (curr.next != null) {
            if (curr.data.equals(data)) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    @Override
    public int indexOf(Object data) {
        Node curr = head;
        int count = 0;
        while (curr.next != null) {
            if (curr.data.equals(data)) {
                return count;
            }
            count++;
            curr = curr.next;
        }

        return -1;
    }

}
