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

        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size++;
        }

    }

    @Override
    public void addLast(Object data) {
        Node newNode = new Node(data);

        tail.next = newNode;
        tail.prev = newNode;
        tail = newNode;
        size++;
    }

    @Override
    public void insertAt(int index, Object data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 1) {
            addFirst(data);
            return;
        }

        int count = 0;
        Node newNode = new Node(data);
        Node curr = head;

        while (curr != null && count < index) {
            curr = curr.next;
            count++;
        }

        newNode.next = curr;
        newNode.prev = curr.prev;
        curr.prev.next = newNode;
        curr.prev = newNode;

    }

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

    @Override
    public Object removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
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
        while (curr != null && count < index) {
            curr = curr.next;
            count++;
        }

        if (curr != null) {
            return curr.data;
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

        while (curr != null) {
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
