package Algorithms;

import java.util.Arrays;

/**
 * Insertion sort: Time complexity O(n^2)
 *
 * array m with size n
 *
 * for i = 1 in range n
 *      key = m[i] //Setting current marker
 *      j = i - 1 //Setting j as i -1 to compare previous index from i
 *
 *      while(j >= 0 && m[j] > key)
 *          swap (set value of m[j + 1] to m[j])
 *          m[j + 1] = m[j]
 *          j--
 *      //set value of current m[j + 1] to key
 *      m[j + 1] = key
 *
 */
public class InsertionSort {

    public static int[] insertionSort(int[] arr){
        /*TODO - Complete Insertion Sort*/
        for(int i = 1; i < arr.length; i++){
            System.out.println("Current i: " + i);
            int key = arr[i];
            int j = i -1;
            System.out.println("Current key value: " + key);
            System.out.println("Current j value: " + j);

            while(j >= 0 && arr[j] > key){
                System.out.println(String.format("Value of j: %d > 0 and arr[j]: %d > key: %d", j, arr[j], key));
                arr[j+1] = arr[j];
                System.out.println("Reducing the value of j by 1");
                j--;
                System.out.println("Current value of j: " + j);
                System.out.println("Current array in while loop: " + Arrays.toString(arr));
            }

            arr[j + 1] = key;
            System.out.println(String.format("Array after %d iteration: %s", i, Arrays.toString(arr)));
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] toSort = {4,6,2,3,65,78,2,1,4,6,7,2,2,65,34,5,4,2,43,5,4,345,346,63,45,451,41,412,43,52,534,534,63,4643,5,23,1234};
        System.out.println("Before sorting: " + Arrays.toString(toSort));
        int[] sorted = insertionSort(toSort);
        System.out.println("After sorting: " + Arrays.toString(sorted));
    }
}
