import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class DoublyListTest {

    public DoublyList doublyList;
    @BeforeEach void setUp() {
        doublyList = new DoublyList();
    }

    @Test
    void isEmpty() {
        assertTrue(doublyList.isEmpty());
    }

    @Test
    void isNotEmpty() {
        doublyList.addLast(1);
        doublyList.addLast(2);

        assertFalse(doublyList.isEmpty());
    }

    @Test
    void checkFirst() {
        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);
        doublyList.addLast(4);
        doublyList.addLast(5);

        assertEquals(1, doublyList.getFirst());
    }

    @Test
    void checkFirstNull() {
       assertThrows(NullPointerException.class, () -> doublyList.getFirst());
    }

    @Test
    void checkLastNull() {
        assertThrows(NullPointerException.class, () -> doublyList.getLast());
    }

    @Test
    void checkLast() {
        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);
        doublyList.addLast(4);
        doublyList.addLast(5);

        assertEquals(5, doublyList.getLast());
    }

    @Test
    void checkSize() {
        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);

        assertEquals(3, doublyList.size());
    }

    @Test
    void checkAdd() {
        doublyList.addLast(1);
        assertEquals(1, doublyList.getFirst());
        assertEquals(1, doublyList.getLast());
    }

    @Test
    void checkAddNull() {
        assertThrows(NullPointerException.class, () -> doublyList.addFirst(null));
        assertThrows(NullPointerException.class, () -> doublyList.addLast(null));
    }

    @Test
    void checkInsert() {
        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);
        doublyList.addLast(4);
        doublyList.addLast(5);

        doublyList.insertAt(2, 6);
        assertEquals(6, doublyList.getAt(2));
    }

    @Test
    void checkGetAt() {
        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);
        doublyList.addLast(4);
        doublyList.addLast(5);

        assertEquals(4, doublyList.getAt(3));
    }

    @Test
    void checkRemoveFirst() {
        // No elements in linked list
        assertThrows(NoSuchElementException.class, () -> doublyList.removeFirst());

        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);
        doublyList.addLast(4);

        assertEquals(1, doublyList.removeFirst());
    }

    @Test
    void checkRemoveLast() {
        // No elements at in linked list
        assertThrows(NoSuchElementException.class, () -> doublyList.removeLast());
        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);
        doublyList.addLast(4);

        assertEquals(4, doublyList.removeLast());
    }

    @Test
    void checkRemoveAt() {
        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);
        doublyList.addLast(4);
        doublyList.addLast(5);

        assertEquals(3, doublyList.removeAt(2));
        assertEquals(4, doublyList.removeAt(2));
    }

    @Test
    void checkClear() {
        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);
        doublyList.addLast(4);
        doublyList.addLast(5);

        doublyList.clear();

        assertEquals(0, doublyList.size());
        assertTrue(doublyList.isEmpty());
        assertThrows(NullPointerException.class, () -> doublyList.getFirst());
        assertThrows(NullPointerException.class, () -> doublyList.getLast());

        assertThrows(NoSuchElementException.class, () -> doublyList.removeLast());
        assertThrows(NoSuchElementException.class, () -> doublyList.removeFirst());

        assertThrows(IndexOutOfBoundsException.class, () -> doublyList.removeAt(3));
    }

    @Test
    void checkContains() {
        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);
        doublyList.addLast(4);
        doublyList.addLast(5);
        doublyList.addLast(8);
        doublyList.addLast(9);
        doublyList.addLast(10);

        assertTrue(doublyList.contains(4));
        assertTrue(doublyList.contains(5));

        assertFalse(doublyList.contains(6));
        assertFalse(doublyList.contains(20));

        assertThrows(NullPointerException.class, () -> doublyList.contains(null));
        doublyList.clear();

        assertThrows(NullPointerException.class, () -> doublyList.contains(5));
    }

    @Test
    void checkIndexOf() {
        doublyList.addLast(1);
        doublyList.addLast(2);
        doublyList.addLast(3);
        doublyList.addLast(4);
        doublyList.addLast(5);
        doublyList.addLast(6);

        assertEquals(3, doublyList.indexOf(4));
        assertEquals(4, doublyList.indexOf(5));
        assertEquals(-1, doublyList.indexOf(10));

        assertThrows(NullPointerException.class, () -> doublyList.indexOf(null));
        doublyList.clear();

        assertThrows(NullPointerException.class, () -> doublyList.indexOf(5));
    }
}