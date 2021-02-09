package Algorithms;

import java.util.Arrays;

/**
 * Selection sort O(n^2)
 *
 * for array m of size n
 *
 * m = [64,25,12,22,11]
 *
 * for i in range n
 *      min_index = i;
 *      for j (i + 1) in range n
 *          if m[j] < m[min_index]
 *          min_index = j
 *
 *      temp = arr[min_index];
 *      arr[min_index] = arr[i]
 *      arr[i] = temp;
 */
public class SelectionSort {

    public static int[] selectionSort(int[] array){
        int len = array.length;
        for(int i = 0; i < len; i++){
            //Set minimum index as i to start
            int min_index = i;
            for(int j = i + 1; j < len; j++){
                //if the next item in the array is less than the current item in min index then set min_index to j
                if(array[j] < array[min_index]){
                    System.out.println(String.format("array[%d]: %d is less than the current min value array[%d]: %d", j, array[j], min_index, array[min_index]));
                    System.out.println("Setting min_index to j: " + j);
                    min_index = j;
                }
                System.out.println("Current min_index: " + min_index);
            }
            //swap values
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
            System.out.println("===================First iteration finished====================");
        }
        return array;
    }

    public static void main(String[] args) {
        int[] toSort = {4,6,2,3,65,78,2,1,4,6,7,2,2,65,34,5,4,2,43,5,4,345,346,63,45,451,41,412,43,52,534,8888,534,63,4643,5,23,1234};
        System.out.println("Unsorted Array: " + Arrays.toString(toSort));
        int[] sorted = selectionSort(toSort);
        System.out.println("Sorted Array: " + Arrays.toString(sorted));
    }

}
