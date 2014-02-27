package sortingalgorithms;

import java.util.Arrays;

/**
 *
 * @author Gabriel
 */
public class SelectionSort {

    static final int SIZE = 10000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] toBeSorted = new int[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            toBeSorted[i] = (int) (Math.random() * 9999);
        }
        int[] copied = new int[SIZE];
        System.arraycopy(toBeSorted, 0, copied, 0, copied.length);
        long startTime = System.nanoTime();

        /* Selection Sort 
         *  Not stable
         *  O(1) extra space
         *  Θ(n2) comparisons
         *  Θ(n) swaps
         *  Not adaptive
         */
        
        for (int i = 0; i < SIZE-1; i++) {
            int min = i;
            for (int j = i + 1; j < SIZE; j++) {
                if (toBeSorted[j] < toBeSorted[min]) {
                    min = j;
                }
            }
            int temp = toBeSorted[min];
            toBeSorted[min] = toBeSorted[i];
            toBeSorted[i] = temp;
        }

        long endTime = System.nanoTime();
        System.out.print("time: " + (endTime - startTime) + " ns\n"
                + "time: " + (endTime - startTime) / 1000 + " \u00B5s\n"
                + "time: " + (endTime - startTime) / 1000000 + " ms\n");
    }
}
