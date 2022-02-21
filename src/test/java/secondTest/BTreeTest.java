package secondTest;

import org.junit.jupiter.api.Test;
import second.BTree;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BTreeTest {
    private BTree first = new BTree(3);
    private BTree second = new BTree(3);

    @Test
    public void insertRemoveAndSearch() {
        first.insert(1);
        assertEquals(first.search(1).keys[0],1);
        first.insert(3);
        first.insert(7);
        first.insert(10);
        first.insert(11);
        first.insert(4);
        first.insert(5);
        first.insert(2);
        first.insert(12);
        first.insert(6);
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 10, 11, 12]", first.traverse().toString());
        first.remove(3);
        assertEquals("[1, 2, 4, 5, 6, 7, 10, 11, 12]", first.traverse().toString());
        first.remove(4);
        assertEquals("[1, 2, 5, 6, 7, 10, 11, 12]", first.traverse().toString());
        first.remove(4);
        assertEquals("[1, 2, 5, 6, 7, 10, 11, 12]", first.traverse().toString());
        first.insert(3);
        assertEquals("[1, 2, 3, 5, 6, 7, 10, 11, 12]", first.traverse().toString());
        first.search(7);
        assertArrayEquals(new Integer[]{7}, first.result.toArray(new Integer[0]));
        first.search(11);
        assertArrayEquals(new int[]{7, 10, 11}, first.result.stream().mapToInt(i -> i).toArray());
        first.search(10);
        assertArrayEquals(new int[]{7, 10}, first.result.stream().mapToInt(i -> i).toArray());
    }

    @Test
    void removeAndSearchWhenNodeEquals() {
        second.insert(1);
        second.insert(1);
        second.insert(1);
        second.insert(1);
        second.insert(1);
        assertEquals("[1, 1, 1, 1, 1]", second.traverse().toString());
        second.remove(1);
        assertEquals("[1, 1, 1, 1]", second.traverse().toString());
        second.search(1);
        assertArrayEquals(new int[]{1}, second.result.stream().mapToInt(i -> i).toArray());
    }
}