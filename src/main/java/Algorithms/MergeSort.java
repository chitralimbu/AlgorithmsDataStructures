package Algorithms;

import java.util.Arrays;

/**
 * Merge sort O(n log n)
 *
 * Divide and conquer algorithm:
 *
 * Given array m of size n;
 *  Split array into half and create new array left and right.
 *  Repeat the process until you have an array with 1 item of array m.
 *
 *  Once you have create n number of arrays. sort and merge the arrays.
 *
 *  [5,4,3,2,1]
 *
 *  [5,4],[3,2,1]
 *
 *  [5], [4], [3], [2,1]
 *
 *  [5], [4], [3], [2], [1]
 *
 *  [4,5], [2,3], [1]
 *
 *   left    right
 *  [4,5] , [1,2,3]
 *   ^       ^
 *  Start with leftPointer and rightPointer at beginning of each array left and right.
 *  Compare left[leftPointer] (i) with right[rightPointer] (j)
 *  if(j < i)
 *  add j to result array
 *  result [1]
 *
 *  Because we copied the item from right we increment the rightPointer by 1;
 *   left    right
 *  [4,5] , [1,2,3]
 *   ^         ^
 *
 *  Repeat.
 *
 *  Compare left[leftPointer] (i) with right[rightPointer] (j)
 *  if(j < i)
 *  add j to result and increment rightPointer by 1.
 *
 *  result [1,2]
 *
 *  Repeat until array is sorted.
 *
 *  Note:
 *  if(j > i)
 *      add left[leftPointer] to result and increment leftPointer by 1
 *
 *  [1,2,3,4,5]
 */
public class MergeSort {

    public static int[] mergeSort(int[] array){
        System.out.println("\n**************************************************\n");
        System.out.println("Current Array:" + Arrays.toString(array));
        /*If array has only one item then return*/
        if(array.length <= 1){
            System.out.println("\n**************************************************\n");
            return array;
        }

        /*Find midpoint and create left and right array*/
        int midPoint = array.length /2;
        int[] left = new int[midPoint];
        int[] right;

        /*If even then create right of length /2 otherwise length /2 + 1*/
        if(array.length % 2 == 0){
            right = new int[midPoint];
        }else{
            right = new int[midPoint + 1];
        }

        /*Populate left array*/
        for(int i =0; i < left.length; i++){
            left[i] = array[i];
        }

        /*Populate right array*/
        for(int j =0; j < right.length; j++){
            right[j] = array[midPoint+j];
        }

        int[] result = new int[array.length];

        System.out.println(String.format("left: %s right: %s", Arrays.toString(left), Arrays.toString(right)));
        left = mergeSort(left);
        right = mergeSort(right);
        result = merge(left, right);
        return result;
    }

    private static int[] merge(int[] left, int[] right){
        System.out.println(String.format("Merging and sorting: left %s, right %s", Arrays.toString(left), Arrays.toString(right)));

        /*Creating new result array to store merged array*/
        int[] result = new int[left.length + right.length];

        /*Create pointers*/
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;

        //While there are items is both left and right array
        while(leftPointer < left.length || rightPointer < right.length){
            //If there are items in both the left and right array
            if(leftPointer < left.length && rightPointer < right.length){
                System.out.println("Items are present in both left and right");
                if(left[leftPointer] < right[rightPointer]){
                    //Add right[rightPointer] to result[resultPointer];
                    System.out.println("Left is less than right");
                    result[resultPointer++] = left[leftPointer++];
                }else{
                    //otherwise add left[leftPointer] to result[resultPointer]
                    System.out.println("Left is greater than right");
                    result[resultPointer++] = right[rightPointer++];
                }
            }else if(leftPointer < left.length){
                //if there are items only in the left array
                result[resultPointer++] = left[leftPointer++];
            }else if(rightPointer < right.length){
                //if there are items only in the right array
                result[resultPointer++] = right[rightPointer++];
            }
        }
        System.out.println("Result Array: " + Arrays.toString(result));
        return result;
    }

    public static void main(String[] args) {
        int[] toSort = {4,6,2,3,65,78,2,1,4,6,7,2,2,65,34,5,4,2,43,5,4,345,346,63,45,451,41,412,43,52,534,8888,534,63,4643,5,23,1234};
        System.out.println("Before sorting: " + Arrays.toString(toSort));
        int[] sorted = mergeSort(toSort);
        System.out.println("Sorted Array: " + Arrays.toString(sorted));
    }

}
