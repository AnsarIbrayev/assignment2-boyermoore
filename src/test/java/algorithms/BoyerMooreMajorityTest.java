package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoyerMooreMajorityTest {

    @Test
    void testMajorityExists() {
        int[] arr = {2, 2, 1, 2, 3, 2, 2};
        assertEquals(2, BoyerMooreMajority.findMajorityElement(arr));
    }

    @Test
    void testNoMajority() {
        int[] arr = {1, 2, 3, 4};
        assertNull(BoyerMooreMajority.findMajorityElement(arr));
    }

    @Test
    void testSingleElement() {
        int[] arr = {5};
        assertEquals(5, BoyerMooreMajority.findMajorityElement(arr));
    }
}