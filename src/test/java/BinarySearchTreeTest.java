import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    public BinarySearchTree<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    void isEmpty() {
        assertTrue(bst.isEmpty());
    }

    @Test
    void isNotEmpty() {
        bst.insert(10);
        bst.insert(20);
        assertFalse(bst.isEmpty());
    }

    @Test
    void insertNull() {
        assertThrows(NullPointerException.class, () -> bst.insert(null));
    }

    @Test
    void checkContains() {
        bst.insert(5);
        bst.insert(10);
        bst.insert(20);
        bst.insert(3);

        assertTrue(bst.contains(10));
        assertTrue(bst.contains(3));
        assertFalse(bst.contains(99));

        assertThrows(NullPointerException.class, () -> bst.contains(null));
    }

    @Test
    void checkSize() {
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);

        assertEquals(3, bst.size());

        bst.insert(3);
        assertEquals(3, bst.size());
    }

    @Test
    void checkDeleteRoot() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);

        bst.delete(10);

        assertFalse(bst.contains(10));
        assertEquals(2, bst.size());
    }

    @Test
    void checkDeleteLeaf() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);

        bst.delete(5);

        assertFalse(bst.contains(5));
        assertEquals(2, bst.size());
    }

    @Test
    void checkDeleteOneChild() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(2);

        bst.delete(5);

        assertFalse(bst.contains(5));
        assertTrue(bst.contains(2));
        assertEquals(2, bst.size());
    }

    @Test
    void checkDeleteTwoChildren() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(12);
        bst.insert(20);

        bst.delete(15);

        assertFalse(bst.contains(15));
        assertEquals(4, bst.size());
    }

    @Test
    void deleteNonExisting() {
        bst.insert(10);
        bst.insert(5);

        bst.delete(999);

        assertEquals(2, bst.size());
        assertTrue(bst.contains(10));
        assertTrue(bst.contains(5));
    }

    @Test
    void deleteNull() {
        assertThrows(NullPointerException.class, () -> bst.delete(null));
    }

    @Test
    void checkHeight() {
        assertEquals(-1, bst.height());

        bst.insert(10);
        bst.insert(5);
        bst.insert(1);

        assertEquals(2, bst.height());
    }

    @Test
    void checkTraversals() {
        bst.inOrderTraversal();
        bst.preOrderTraversal();
        bst.postOrderTraversal();
        bst.levelOrderTraversal();
    }

    @Test
    void checkClearLikeBehavior() {
        bst.insert(10);
        bst.insert(5);
        bst.insert(3);

        bst.delete(10);
        bst.delete(5);
        bst.delete(3);

        assertEquals(0, bst.size());
        assertTrue(bst.isEmpty());
        assertFalse(bst.contains(10));
        assertEquals(-1, bst.height());
    }
}
