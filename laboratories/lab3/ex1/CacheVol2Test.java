package lab3.ex1;

import lab3.ex1.CacheVol2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheVol2Test {

    @Test
    void test1() {
        CacheVol2<Integer, Integer> cache;
        cache = new CacheVol2<>(8);
        assertThrows(IllegalArgumentException.class, () -> {
            cache.get(99);
        });
    }

    @Test
    void test2() {
        CacheVol2<Integer, Integer> cache;
        cache = new CacheVol2<>(3);
        cache.put(1, 1);
        cache.put(2, 4);
        cache.put(3, 9);
        cache.put(4,44);
        assertThrows(IllegalArgumentException.class, () -> {cache.get(1);});
        assertEquals(cache.get(2), 4);
        assertEquals(cache.get(3), 9);
    }

    @Test
    void test3() {
        CacheVol2<Integer, Integer> c;
        c = new CacheVol2<>(4);
        c.put(1, 1);
        c.put(2, 4);
        c.put(3, 9);
        c.put(4,44);
        assertDoesNotThrow(() -> {c.get(1);});
        assertEquals(c.get(2), 4);
        assertEquals(c.get(3), 9);
    }
}
