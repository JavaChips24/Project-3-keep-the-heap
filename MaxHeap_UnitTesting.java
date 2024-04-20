import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaxHeap_UnitTesting{

    private MaxHeap<Integer> maxHeap;

    @Before
    public void setUp() {
        maxHeap = new MaxHeap<>();
    }

    @Test
    public void testIsEmpty_onNewHeap() {
        assertTrue("Newly created heap should be empty", maxHeap.isEmpty());
    }
}
