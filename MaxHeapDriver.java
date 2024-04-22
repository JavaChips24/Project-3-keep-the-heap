import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class MaxHeapDriver {
    public static void main(String[] args) throws IOException {
        resultFileWriter("data_random.txt");
    }
    public static MaxHeap<Integer> fileToMaxHeap(String filename){
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
    public static void resultFileWriter(String inputFileName) throws IOException{
        System.out.println("line 34");
        //Set up so files can be written on
        File resultFileName = new File("OutputFile.txt");
        FileWriter myWriter = new FileWriter(resultFileName);
        //Store first 10 values in a list
        // Create an array to hold the first ten elements
        MaxHeap<Integer> inputHeap = fileToMaxHeap(inputFileName);
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
}
