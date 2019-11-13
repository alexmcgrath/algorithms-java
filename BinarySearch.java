import java.util.Arrays;
import static java.lang.System.*;

public class BinarySearch{
    public static void main(String[] args){
        int arraySize = Integer.parseInt(args[0]);
        //Given a sorted array
        int[] intArray = Utils.generateSortedIntArray(arraySize);

        int valueToFind = Integer.parseInt(args[1]);

        if (binarySearch(valueToFind, intArray)) out.println(valueToFind + " Found");
        else out.println(valueToFind + " Not Found");

    }

    private static boolean binarySearch(int valueToFind, int[] intArray){
        int mid = intArray.length / 2;
        if(intArray[mid] == valueToFind) return true;
        if(intArray.length == 1) return false;

        if(valueToFind < intArray[mid]){
            return binarySearch(valueToFind, Arrays.copyOfRange(intArray, 0, mid));
        }
        else{
            return binarySearch(valueToFind, Arrays.copyOfRange(intArray, mid+1, intArray.length));
        }
    }
}