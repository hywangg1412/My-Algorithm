import java.util.Arrays;

public class genericAllSort {
    // ----------------------------- SELECTION SORT -----------------------------------------
    public <T extends Comparable<T>> void selectionSort(T[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j].compareTo(array[k]) < 0) {
                    k = j;
                }
            }
            swap(array, i, k);
        }
    }
    // ----------------------------- INSERTION SORT -----------------------------------------
    public <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T base = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(base) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = base;
        }
    }
    // ----------------------------- BUBBLE SORT -----------------------------------------

    public <T extends Comparable<T>> void bubbleSort(T[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }
    // ----------------------------- QUICK SORT -----------------------------------------

    public <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    // partition for quicksort
    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        T pivot = array[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (i <= right && array[i].compareTo(pivot) <= 0) {
                i++;
            }

            while (j >= left && array[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, left, j);
        return j;
    }
    // ----------------------------- MERGE SORT -----------------------------------------
    public <T extends Comparable<T>> void mergeSort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (left >= right) {
            return; // Base case: terminate recursion when subarray length is 1
        }

        int mid = left + (right - left) / 2; // Calculate the midpoint
        mergeSort(array, left, mid); // Recursively process the left subarray
        mergeSort(array, mid + 1, right); // Recursively process the right subarray

        // Merge the two sorted subarrays
        merge(array, left, mid, right);
    }

    private <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        T[] tmp = (T[]) new Comparable[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i].compareTo(array[j]) <= 0)
                tmp[k++] = array[i++];
            else
                tmp[k++] = array[j++];
        }

        while (i <= mid) {
            tmp[k++] = array[i++];
        }

        while (j <= right) {
            tmp[k++] = array[j++];
        }

        for (k = 0; k < tmp.length; k++) {
            array[left + k] = tmp[k];
        }
    }


    // ----------------------------- RADIX SORT -----------------------------------------
    // Get the k-th digit of element num, where exp = 10^(k-1)
    private int digit(int num, int exp) {
        // Passing exp instead of k can avoid repeated expensive exponentiation here
        return (num / exp) % 10;
    }

    // Counting sort (based on nums k-th digit)
    private void countingSortDigit(Integer[] nums, int exp) {
        // Decimal digit range is 0~9, therefore need a bucket array of length 10
        int[] counter = new int[10];
        int n = nums.length;

        // Count the occurrence of digits 0~9
        for (int i = 0; i < n; i++) {
            int d = digit(nums[i], exp); // Get the k-th digit of nums[i]
            counter[d]++;                // Count the occurrence of digit d
        }

        // Calculate prefix sum, converting "occurrence count" into "array index"
        for (int i = 1; i < 10; i++) {
            counter[i] += counter[i - 1];
        }

        // Traverse in reverse, based on bucket statistics, place each element into res
        Integer[] res = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            int d = digit(nums[i], exp);
            int j = counter[d] - 1; // Get the index j for d in the array
            res[j] = nums[i];       // Place the current element at index j
            counter[d]--;           // Decrease the count of d by 1
        }

        // Use result to overwrite the original array nums
        System.arraycopy(res, 0, nums, 0, n);
    }

    // Radix sort
    public void radixSort(Integer[] nums) {
        // Get the maximum element of the array, used to determine the maximum number of digits
        int m = Arrays.stream(nums).max(Integer::compare).orElse(Integer.MIN_VALUE);

        // Traverse from the lowest to the highest digit
        for (int exp = 1; exp <= m; exp *= 10) {
            // Perform counting sort on the k-th digit of array elements
            countingSortDigit(nums, exp);
        }
    }

    // ----------------------------- HEAP SORT -----------------------------------------
    // Heapify (Sift down) operation for generic elements
    private <T extends Comparable<T>> void siftDown(T[] array, int n, int i) {
        while (true) {
            // Determine the largest node among i, l, r, noted as ma
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int ma = i;

            if (l < n && array[l].compareTo(array[ma]) > 0) {
                ma = l;
            }
            if (r < n && array[r].compareTo(array[ma]) > 0) {
                ma = r;
            }

            // If node i is the largest or indices l, r are out of bounds, no further heapification needed, break
            if (ma == i) {
                break;
            }

            // Swap two nodes
            T temp = array[i];
            array[i] = array[ma];
            array[ma] = temp;

            // Loop downwards heapification
            i = ma;
        }
    }

    // Generic Heap Sort
    public <T extends Comparable<T>> void heapSort(T[] array) {
        // Build heap operation: heapify all nodes except leaves
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            siftDown(array, array.length, i);
        }

        // Extract the largest element from the heap and repeat for n-1 rounds
        for (int i = array.length - 1; i > 0; i--) {
            // Swap the root node with the rightmost leaf node (swap the first element with the last element)
            T tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;

            // Start heapifying the root node, from top to bottom
            siftDown(array, i, 0);
        }
    }


    public <T> void arrayTravers(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
