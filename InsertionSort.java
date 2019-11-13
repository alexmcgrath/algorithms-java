import static java.lang.System.*;

public class InsertionSort{
    public static void main(String[] args){
        //Given an unsorted array
        int arraySize = Integer.parseInt(args[0]);
        int[] intArray = Utils.generateRandomIntArray(arraySize);

        out.println("Unsorted array:");
        Utils.printIntArray(intArray);

        int[] result = insertionSort(intArray);

        out.println("Sorted array:");
        Utils.printIntArray(result);
    }

    private static int[] insertionSort(int[] intArray){
        for(int i = 1; i < intArray.length; i++){
            for(int j = 0; j < i; j++){
                if(intArray[i - j] < intArray[i - j - 1]) {
                    int temp = intArray[i - j];
                    intArray[i - j] = intArray[i - j - 1];
                    intArray[i - j - 1] = temp;
                }
            }
        }
        return intArray;
    }
}