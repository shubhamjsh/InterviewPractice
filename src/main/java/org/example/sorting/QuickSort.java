package org.example.sorting;

public class QuickSort {

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j <= high-1; j++){
            if(arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i+1);
    }

    static void sort(int[] arr, int low, int high) {
        if(low<high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi+1, high);
        }
    }
    public static void main(String[] args) {

        int[] arr = {1, 2, 9, 12, 13, 8};
        sort(arr, 0, arr.length-1);
        for(int a : arr){
            System.out.println(a + " ");
        }
    }

    /* worst case time complexity is n^2
    * Worst case comes when array is already sorted if you pick 1st or last element as pivot it will take n^2 time
    * Space complexity is log n
    * To avoid worst case pick a pivot in middle*/
}
