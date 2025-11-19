public interface DoublyLinkedList<T> {
    void addFirst(T data);
    void addLast(T data);
    void insertAt(int index, T data);

    T removeFirst();
    T removeLast();
    T removeAt(int index);

    T getFirst();
    T getLast();
    T getAt(int index);
    int size();
    boolean isEmpty();
    void clear();

    boolean contains(T data);
    int indexOf(T data);
}
