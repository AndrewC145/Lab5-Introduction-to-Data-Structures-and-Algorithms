import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class DoublyListTest {
    @Test
    void isEmpty() {
        DoublyList doublyList = new DoublyList();
        assertTrue(doublyList.isEmpty());

    }

    @Test
    void isNotEmpty() {
        DoublyList doublyList = new DoublyList();
        doublyList.head = new DoublyList.Node<>(4);

    }

}