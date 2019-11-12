import java.util.Arrays;
import static java.lang.System.*;

public class BinarySearch{
    public static void main(String[] args){
        //Given a sorted array
        int[] intArray = new int[]{1,2,3,4,5,6,7,8,9,10};

        //Test all elements can be found
        for(int i = 0; i < intArray.length; i++) {
            if (binarySearch(intArray[i], intArray)) out.println(intArray[i] + " Found");
            else out.println(intArray[i] + "Not Found");
        }

        //Negative test
        if (binarySearch(12, intArray)) out.println("12 Found");
        else out.println("12 Not Found");

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