package bo;

import utils.ArrayUtils;

public class BubbleSort {

    private int arr[];

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    private int[] sort(boolean sortOnOriginArr, boolean isAsc) {
        int array[] = arr;
        if (!sortOnOriginArr) {
            array = ArrayUtils.cloneArray(arr);
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (isAsc ? array[i] > array[j] : array[i] < array[j]) {
                    ArrayUtils.swap(array, i, j);
                }
            }
        }

        return array;
    }

    private int[] getSortedArray(boolean isAsc) {
        return sort(false, isAsc);
    }

    public void displayCompare() {
        System.out.print("Unsorted array: ");
        ArrayUtils.displayIntArray(arr);
        System.out.print("Sorted array: ");
        ArrayUtils.displayIntArray(getSortedArray(true));

    }
}
