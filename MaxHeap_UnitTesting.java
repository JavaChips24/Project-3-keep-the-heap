import static org.junit.Assert.*;
import org.junit.Test;
public class MaxHeap_UnitTesting{

    @Test
    public void testIsEmptyNewHeap() {
        var nonEmptyHeap = new MaxHeap<Integer>();
        assertTrue("Newly created heap should be empty", nonEmptyHeap.isEmpty());
        }
    @Test
    public void testAdd() {
        var addedToHeap = new MaxHeap<Integer>();
        addedToHeap.add(6);
        assertFalse("Newly created heap should not be empty", addedToHeap.isEmpty());
        }
    
        @Test
        public void testClear() {
            var clearTestHeap = new MaxHeap<Integer>();
            clearTestHeap.add(6);
            clearTestHeap.add(8);
            clearTestHeap.clear();
            assertTrue("Cleared heap should be empty", clearTestHeap.isEmpty());
        }
    
        @Test
        public void testGetMax() {
            var maxTestHeap = new MaxHeap<Integer>();
            maxTestHeap.add(6);
            maxTestHeap.add(8);
            assertTrue("max should be 8", maxTestHeap.getMax()==8);
        }
    
        @Test
        public void testGetSize() {
            var sizeTestHeap = new MaxHeap<Integer>();
            sizeTestHeap.add(6);
            sizeTestHeap.add(8);
            assertTrue("Size should be two", sizeTestHeap.getSize()==2);
        }
    
        @Test
        public void testRemoveMax() {
            var maxTestHeap = new MaxHeap<Integer>();
            maxTestHeap.add(6);
            maxTestHeap.add(8);
            maxTestHeap.removeMax();
            assertTrue("new max should be 6", maxTestHeap.getMax()==6);
        }

    
}
