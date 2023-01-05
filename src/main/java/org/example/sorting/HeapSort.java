package org.example.sorting;

public class HeapSort {

    public void sort(int[] arr) {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    public void heapify(int[] arr, int N, int i) {
            int largest = i;
            int lChild = 2*i + 1;
            int rChild = 2*i + 2;

            if(lChild < N && arr[lChild] > arr[largest])
                largest = lChild;
            if(rChild < N && arr[rChild] > arr[largest])
                largest = rChild;
            if(largest != i) {
                int swap = arr[i];
                arr[i] = arr[largest];
                arr[largest] = swap;

                heapify(arr, N, largest);
            }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        HeapSort obj = new HeapSort();
        obj.sort(arr);

        for(int a : arr) {
            System.out.print(a + " ");
        }
    }
}
