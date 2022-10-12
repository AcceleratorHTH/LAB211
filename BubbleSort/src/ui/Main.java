package ui;

import bo.BubbleSort;
import utils.ArrayUtils;
import utils.NumberUtils;


public class Main {

    public static void main(String[] args) {
        int arrLength = NumberUtils.inputInt("Enter number of array: ", 1, Integer.MAX_VALUE);
        int arr[] = ArrayUtils.randomIntArray(arrLength, 0, 500);
        BubbleSort b = new BubbleSort(arr);
        b.displayCompare();
        
    }
}
