import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.Test;
public class MaxHeap_UnitTesting{
    public MaxHeap<Integer> fileToMaxHeap(String filename){
        List<Integer> dataArrayList = new ArrayList<>();
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                Integer data = Integer.valueOf(myReader.nextLine());
                dataArrayList.add(data);
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        Integer[]dataArray = (Integer[]) dataArrayList.toArray();
        MaxHeap<Integer> newMaxHeap = new MaxHeap<>(dataArray);
        return newMaxHeap;
    }
    public void resultFileWriter(String inputFileName) throws IOException{
        //Set up so files can be written on
        File resultFileName = new File("OutputFile.txt");
        FileWriter myWriter = new FileWriter(resultFileName);
        //Store first 10 values in a list
        // Create an array to hold the first ten elements
        MaxHeap inputHeap = fileToMaxHeap(inputFileName);
        int[] firstTenArray = new int[10];
        int[] nextTenArray = new int[10];


        // Copy the first ten elements from the inputHeap to the new array
        for(int i = 0; i<=10; i++){
            firstTenArray[i] = (int) inputHeap.getMax();
            inputHeap.removeMax();
        }
        //Next ten after removal from heap
        for(int i = 0; i<=10; i++){
            nextTenArray[i] = (int) inputHeap.getMax();
            inputHeap.removeMax();
        }
        //First Line of printing
        myWriter.write("Heap built using sequential insertions: " + firstTenArray);
        //Second Line of printing
        myWriter.write("Number of swaps in the heap creation: " + inputHeap.getSwaps());
        //Third Line of Printing
        myWriter.write("Heap after 10 removals: " + nextTenArray);

        myWriter.close();
        }
    

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
}
