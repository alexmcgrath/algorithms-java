import java.util.Arrays;
import static java.lang.System.*;

public class MergeSort{
    public static void main(String[] args){
        //Given unsorted array
        int[] intArray = new int[]{10,4,6,3,8,2,9,1,5,7};

        int[] result = mergeSort(intArray);

        for(int i = 0; i < result.length; i++){
            out.println(result[i]);
        }
    }

    private static int[] mergeSort(int[] intArray){
        if(intArray.length == 1){
            return intArray;
        }

        int mid = intArray.length / 2;

        //Splice the array into two smaller arrays
        int[] array1 = new int[mid];
        int[] array2 = new int[intArray.length - mid];

        for (int i = 0; i < mid; i++){
            array1[i] = intArray[i];
        }
        for (int i = mid; i < intArray.length; i++){
            array2[i-mid] = intArray[i];
        }

        //Merge the two sorted returns
        return merge(mergeSort(array1), mergeSort(array2));
    }

    private static int[] merge(int[] intArray1, int[] intArray2){
        int i = 0;
        int j = 0;
        int[] mergedArray = new int[intArray1.length + intArray2.length];

        //Two finger algorithm until either of the arrays have been fully traversed, then switch to simple iteration
        while(i < intArray1.length && j < intArray2.length){
            if(intArray1[i] < intArray2[j]){
                mergedArray[i+j] = intArray1[i];
                i++;
            }
            else{
                mergedArray[i+j] = intArray2[j];
                j++;
            }
        }

        //Simple iteration of remaining results
        while(i < intArray1.length){
            mergedArray[i+j] = intArray1[i];
            i++;
        }

        while(j < intArray2.length){
            mergedArray[i+j] = intArray2[j];
            j++;
        }

        return mergedArray;
    }
}