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
        boolean isRunning = true;
        Scanner scnr = new Scanner(System.in);
        String inputFileName, outputFileName, response;

        System.out.println( "Welcome to Keep the Heap!");
        for( int i = 0; i < 40; i++ )
        {
            System.out.print("-");
        }
        System.out.println();
        System.out.print("Enter 'n' to skip the user interface: ");
        response = scnr.next();
        if( response.equals("n")){
            outputFinalFile("data_sorted.txt", "output1.txt");
            outputFinalFile("data_random.txt", "output2.txt");
            System.out.println( "\nOutput files created...");
        }
        else{
            while(isRunning){
                System.out.print("Please enter the name or path of an input file: ");
                inputFileName = scnr.next();
                System.out.print("Please enter the name of the outputfile: ");
                outputFileName = scnr.next();
                outputFinalFile(inputFileName, outputFileName);
                System.out.println( "\nOutput file created.");
                for( int i = 0; i < 40; i++ )
                {
                    System.out.print("-");
                }
                System.out.print("\nIf you would like to read another file, enter 'y' (enter anything else to exit): ");
                response = scnr.next();
                if( !response.equals("y") )
                    isRunning = false;
            }
            System.out.println("Thank you for using our program...");
        }
        scnr.close();

    }

    public static void outputFinalFile( String filename, String outputFileName) throws IOException{
        resultFileWriterSequential( filename, outputFileName );
        resultFileWriterSmart( filename, outputFileName);
    }
    public static MaxHeap<Integer> fileToSequentialMaxHeap(String filename){
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
        Integer[]dataArray = dataArrayList.toArray(new Integer[0]);
        MaxHeap<Integer> newMaxHeap = new MaxHeap<>();
        newMaxHeap.createHeap_Sequential(dataArray);
        return newMaxHeap;
    }

    public static MaxHeap<Integer> fileToSmartMaxHeap(String filename){
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
        Integer[]dataArray = dataArrayList.toArray(new Integer[0]);
        MaxHeap<Integer> newMaxHeap = new MaxHeap<>();
        newMaxHeap.createHeap_SmartWay(dataArray);
        return newMaxHeap;
    }

    public static void resultFileWriterSequential(String inputFileName, String outputFileName) throws IOException{
        //Set up so files can be written on
        File resultFileName = new File(outputFileName);
        FileWriter myWriter = new FileWriter(resultFileName, true);
        //Store first 10 values in a list
        // Create an array to hold the first ten elements
        MaxHeap<Integer> inputHeap = fileToSequentialMaxHeap(inputFileName);
        int[] firstTenArray = new int[10];
        int[] nextTenArray = new int[10];

        // Copy the first ten elements from the inputHeap to the new array
        for(int i = 0; i<10; i++){
            firstTenArray[i] = (int) inputHeap.getMax();
            inputHeap.removeMax();
        }
        //Next ten after removal from heap
        for(int i = 0; i<10; i++){
            nextTenArray[i] = (int) inputHeap.getMax();
            inputHeap.removeMax();
        }
        //First Line of printing
        myWriter.write("\nHeap built using sequential insertions: " + Arrays.toString(firstTenArray));
        //Second Line of printing
        myWriter.write("\nNumber of swaps in the heap creation: " + inputHeap.getSwaps());
        //Third Line of Printing
        myWriter.write("\nHeap after 10 removals: " + Arrays.toString(nextTenArray) + "\n\n\n");
  
        myWriter.flush();
        myWriter.close();
    }

    
    public static void resultFileWriterSmart(String inputFileName, String outputFileName) throws IOException{
        //Set up so files can be written on
        File resultFileName = new File(outputFileName);
        FileWriter myWriter = new FileWriter(resultFileName, true);
        //Store first 10 values in a list
        // Create an array to hold the first ten elements
        MaxHeap<Integer> inputHeap = fileToSmartMaxHeap(inputFileName);
        int[] firstTenArray = new int[10];
        int[] nextTenArray = new int[10];
  
  
        // Copy the first ten elements from the inputHeap to the new array
        for(int i = 0; i<10; i++){
            firstTenArray[i] = (int) inputHeap.getMax();
            inputHeap.removeMax();
        }
        //Next ten after removal from heap
        for(int i = 0; i<10; i++){
            nextTenArray[i] = (int) inputHeap.getMax();
            inputHeap.removeMax();
        }
        //First Line of printing
        myWriter.write("\nHeap built using optimal method: " + Arrays.toString(firstTenArray));
        //Second Line of printing
        myWriter.write("\nNumber of swaps in the heap creation: " + inputHeap.getSwaps());
        //Third Line of Printing
        myWriter.write("\nHeap after 10 removals: " + Arrays.toString(nextTenArray));
  
        myWriter.flush();
        myWriter.close();
    }

}
