import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class bubblesort {
    public bubblesort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;
        while (!isSorted) {
            isSorted = true; // assume array is sorted
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    isSorted = false; // if you need to sort, then isSorted is false
                }
            }
            lastUnsorted--; // Once the last digits are sure to be largest number, shrink the array
        }
    }

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {

    }

}
