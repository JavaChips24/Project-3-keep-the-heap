import java.util.Arrays;

import java.util.Arrays;
/**
   A class that implements the ADT maxheap by using an array.
 
   @author Frank M. Carrano
   @author Timothy M. Henry
   @version 5.0
*/
public final class MaxHeap<T extends Comparable<? super T>>
             implements MaxHeapInterface<T>
{
   private T[] heap;      // Array of heap entries; ignore heap[0]
   private int lastIndex; // Index of last entry and number of entries
   private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;
   
   public MaxHeap()
   {
      this(DEFAULT_CAPACITY); // Call next constructor
   } // end default constructor
   
   public MaxHeap(int initialCapacity)
   {
      // Is initialCapacity too small?
      if (initialCapacity < DEFAULT_CAPACITY)
         initialCapacity = DEFAULT_CAPACITY;
      else // Is initialCapacity too big?
         checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempHeap = (T[])new Comparable[initialCapacity + 1];
      heap = tempHeap;
      lastIndex = 0;
      integrityOK = true;
   } // end constructor

   public void add(T newEntry)
   {
        checkIntegrity();        // Ensure initialization of data fields
        int newIndex = lastIndex + 1;
        int parentIndex = newIndex / 2;
        while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
        {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
        } // end while

        heap[newIndex] = newEntry;
        lastIndex++;
        ensureCapacity();
   } // end add

   public T removeMax()
    {
        checkIntegrity();             // Ensure initialization of data fields
        T root = null;

        if (!isEmpty())
        {
            root = heap[1];            // Return value
            heap[1] = heap[lastIndex]; // Form a semiheap
            lastIndex--;               // Decrease size
            reheap(1);                 // Transform to a heap
        } // end if

        return root;
    } // end removeMax


   public T getMax()
   {
		checkIntegrity();
      T root = null;
      if (!isEmpty())
         root = heap[1];
      return root;
   } // end getMax

   public boolean isEmpty()
   {
      return lastIndex < 1;
   } // end isEmpty

   public int getSize()
   {
      return lastIndex;
   } // end getSize

   public void clear()
   {
		checkIntegrity();
      while (lastIndex > -1)
      {
         heap[lastIndex] = null;
         lastIndex--;
      } // end while
      lastIndex = 0;
   } // end clear
   
// Private methods
// . . .

    /**
    * Checks that the capacity is not greater than the max capacity allowed.
    * @param capacity The given capacity to be checked for validity.
    */
    private void checkCapacity(int capacity) {
        if (capacity > MAX_CAPACITY) {
        throw new IllegalStateException("Attempt to create a heap whose " +
                                            "capacity exceeds allowed " +
                                            "maximum of " + MAX_CAPACITY);
        }
    } // end checkCapacity

    /**
    * Check if the integrity of the stack is maintained.
    */
    private void checkIntegrity() {
        if(!integrityOK) {
        throw new SecurityException("MaxHeap object is corrupt.");
        }
    } // end checkIntegrity

    /**
    * Checks if heap is at size limit, if it is create a new heap of double size.
    */
    private void ensureCapacity() {
        if (lastIndex >= heap.length - 1) {
           int newLength = 2 * heap.length;
           checkCapacity(newLength);
           heap = Arrays.copyOf(heap, newLength);
        }
    }

    /**
     * 
     * @param rootIndex
     * @return int representing the number of tempSwaps
     */
    private int reheap(int rootIndex) {
        int tempSwaps = 0;
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;

        while(!done && (leftChildIndex <= lastIndex)) {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;

            if ((rightChildIndex <= lastIndex) &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
                    
                    largerChildIndex = rightChildIndex;

            }

            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
                tempSwaps++;

            } else {
                done = true;
            }
        } // end while
        heap[rootIndex] = orphan;
        return tempSwaps;
    } // end reheap (powerpoint version)
} // end MaxHeap