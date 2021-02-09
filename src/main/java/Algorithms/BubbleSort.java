package Algorithms;

import java.util.Arrays;

/**
 * Time Complexity: O(n^2)
 *
 * for array a of size m:
 *
 * boolean swap = false;
 *
 * for i in range m - 1
 *  for j in range m - 1
 *      if a[j] > a[j + 1]
 *          swap a[j] and a [j + 1]
 *          swap = true
 *  if swap == false
 *      break
 *
 */
public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        int iterate = arr.length;
        boolean swap = false;
        int swapCount = 0;
        for (int i = 0; i < iterate -1; i++){
            for (int j = 0; j < iterate -1; j ++){
                System.out.println("arr[j]:\n" + arr[j]);
                System.out.println("arr[j + 1]:\n" + arr[j + 1]);
                int current = arr[j];
                int next = arr[j + 1];
                if(arr[j] > arr[j + 1]){
                    System.out.println(String.format("arr[j]: %d is greater than arr[j + 1]: %d swapping the two values", current, next));
                    arr[j] = next;
                    arr[j + 1] = current;
                    System.out.println(String.format("Array after swapping values: %s", Arrays.toString(arr)));
                    swap = true;
                    swapCount++;
                }
                System.out.println("==============NEXT=================");
            }
            if(!swap){
                System.out.println("No values were swapped, already sorted");
                break;
            }
        }
        System.out.println("Total Swap Count: " + swapCount);
        return arr;
    }

    public static void main(String[] args) {
        int[] toSort = {9,8,7,6,5,4,3,2,1};
        System.out.println("Unsorted Array: " + Arrays.toString(toSort));
        int[] sorted = bubbleSort(toSort);
        System.out.println("Sorted Array: " + Arrays.toString(sorted));
    }
}
