import static java.lang.System.*;

public class InsertionSort{
    public static void main(String[] args){
        //Given an unsorted array
        int[] intArray = {5,2,4,6,1,3};
        int[] result = insertionSort(intArray);

        for(int i = 0; i < result.length; i++){
            out.println(result[i]);
        }
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