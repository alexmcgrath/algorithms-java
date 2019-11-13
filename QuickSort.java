import static java.lang.System.*;
import java.util.Random;

public class QuickSort{
    public static void main(String[] args){
        int arraySize = Integer.parseInt(args[0]);

        //Generate random unsorted array
        int[] intArray = Utils.generateRandomIntArray(arraySize);
        out.println("Unsorted array:");
        Utils.printIntArray(intArray);

        int[] result = quickSort(intArray);

        out.println("Sorted array:");
        Utils.printIntArray(result);
    }

    private static int[] quickSort(int[] intArray){
        //If array is empty or length 1, it is sorted
        if(intArray.length <= 1) return intArray;

        //Choose pivot
        int pivotSelection = (int)(Math.random() * intArray.length);
        int pivotValue = intArray[pivotSelection];

        //Sort based on pivot
        int i = 0;
        int jstart = -1;
        int jend = -1;
        while(i < intArray.length){
            if(intArray[i] < pivotValue){
                //If element is next element lt pivot value after range of gt pivot values
                //swap i with jstart element
                if(jend != -1 && i == jend + 1){
                    int temp = intArray[i];
                    intArray[i] = intArray[jstart];
                    intArray[jstart] = temp;
                    jstart++;
                    jend++;
                }
                i++;
            }
            else{
                if(jstart == -1){
                    jstart = jend = i;
                }
                else{
                    jend++;
                }
                i++;
            }
        }

        //Pivot may have been sorted somewhere random in array, place it between sorted legs
        int currentPivotLocation = -1;
        int destinationPivotLocation = -1;

        for(int k = 0; k < intArray.length; k++){
            if(intArray[k] == pivotValue){
                currentPivotLocation = k;
                //If it's found at the last element
                if(k == (intArray.length - 1) && destinationPivotLocation == -1) destinationPivotLocation = k;
                continue;
            }
            if(destinationPivotLocation == -1 && intArray[k] > pivotValue){
                if(k > 0 && intArray[k-1] == pivotValue) destinationPivotLocation = k-1;
                //To deal with if pivot should be at the start
                else destinationPivotLocation = k;
                continue;
            }
        }

        //Move pivot if it isn't in the correct place
        if(currentPivotLocation != destinationPivotLocation){
            int temp = intArray[destinationPivotLocation];
            intArray[destinationPivotLocation] = intArray[currentPivotLocation];
            intArray[currentPivotLocation] = temp;
        }

        //Split array into subproblems around pivot
        int[] leftArray = new int[destinationPivotLocation];
        int[] rightArray = new int[intArray.length - destinationPivotLocation - 1];
        int j = 0;
        while(j < destinationPivotLocation){
            leftArray[j] = intArray[j];
            j++;
        }
        //Skip pivot
        j++;
        while(j < intArray.length){
            rightArray[j - destinationPivotLocation - 1] = intArray[j];
            j++;
        }

        //Merge subproblems with pivot
        return merge(quickSort(leftArray), pivotValue, quickSort(rightArray));
    }

    private static int[] merge(int[] intArray1, int pivotValue, int[] intArray2){
        int[] mergedArray = new int[intArray1.length + 1 + intArray2.length];
        int i = 0;
        while(i < intArray1.length){
            mergedArray[i] = intArray1[i];
            i++;
        }
        mergedArray[i] = pivotValue;
        int j = 0;
        while(j < intArray2.length){
            mergedArray[i+1+j] = intArray2[j];
            j++;
        }

        return mergedArray;
    }
}