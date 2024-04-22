import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MaxHeapUnitTesting{
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

    @Test
    public void testReheap(){
        Integer[] sampleIntegers = {6, 9, 12, 3, 7, 4};
        MaxHeap<Integer> reheapTest = new MaxHeap<>(sampleIntegers);
        assertTrue("max should be 12", reheapTest.getMax() == 12 );
        assertTrue("size should be 6", reheapTest.getSize() == 6);
    }

    @Test
    public void testSwapsOnSequentialInsertions() {
        MaxHeap<Integer> maxheap = new MaxHeap<>();
        Integer[] elements = {3, 2, 1, 5, 4};
        maxheap.createHeap_Sequential(elements);
        assertTrue("Swaps should be greater than 0 after sequential insertions", maxheap.getSwaps() > 0);
    }

    @Test
    public void testSwapsOnOptimalMethod() {
        MaxHeap<Integer> maxheap = new MaxHeap<>();
        Integer[] elements = {3, 2, 1, 5, 4};
        maxheap.createHeap_SmartWay(elements);
        assertTrue("Swaps should be greater than 0 after optimal method", maxheap.getSwaps() > 0);
    }

    @Test
    public void testNoSwapsOnEmptyHeap() {
        MaxHeap<Integer> maxheap = new MaxHeap<>();
        Integer[] elements = {};
        maxheap.createHeap_Sequential(elements);
        assertEquals("Swaps should be 0 for an empty heap", 0, maxheap.getSwaps());
    }

    @Test
    public void testNoSwapsOnSingleElementHeap() {
        Integer[] elements = {1};
        MaxHeap<Integer> maxheap = new MaxHeap<>();
        maxheap.createHeap_Sequential(elements);
        assertEquals("Swaps should be 0 for a single-element heap", 0, maxheap.getSwaps());
    }

    // Add more tests as needed to cover different scenarios and edge cases.

}
