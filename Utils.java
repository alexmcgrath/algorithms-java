import static java.lang.System.*;

public class Utils{
    public static int[] generateRandomIntArray(int n){
        return fisherYatesShuffle(generateSortedIntArray(n));
    }

    public static int[] generateSortedIntArray(int n){
        int[] sortedArray = new int[n];
        for(int i = 0; i < n; i++){
            sortedArray[i] = i;
        }
        return sortedArray;
    }

    public static int[] fisherYatesShuffle(int[] sortedArray){
        for(int i = sortedArray.length-1; i > 0 ; i--){
            //Generate random number between 0 and i
            int randomNum = (int)(Math.random() * (i+1));
            //Swap ith element with randomNum element
            int temp = sortedArray[randomNum];
            sortedArray[randomNum] = sortedArray[i];
            sortedArray[i] = temp;
        }
        return sortedArray;
    }

    public static void main(String[] args){
        int arraySize = Integer.parseInt(args[0]);
        printIntArray(generateRandomIntArray(arraySize));
    }

    public static void printIntArray(int[] intArray){
        for(int i = 0; i < intArray.length; i++){
            out.print(intArray[i] + " ");
        }
        out.print("\n");
    }
}