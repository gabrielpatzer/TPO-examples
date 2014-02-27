package sortingalgorithms;

import java.util.Arrays;

/**
 *
 * @author Gabriel
 */
public class ShellSort {

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

        /* Shell Sort 
         *  Not Stable
         *  O(1) extra space
         *  O(n3/2) time
         *  Adaptive: O(n*log(n)) time when nearly sorted
         */


        int inner, outer;
        int temp;
        //find initial value of h
        int h = 1;
        while (h <= SIZE / 3) {
            h = h * 3 + 1; // (1, 4, 13, 40, 121, ...)
        }
        while (h > 0) // decreasing h, until h=1
        {
            // h-sort the file
            for (outer = h; outer < SIZE; outer++) {
                temp = toBeSorted[outer];
                inner = outer;
                // one subpass (eg 0, 4, 8)
                while (inner > h - 1 && toBeSorted[inner - h] >= temp) {
                    toBeSorted[inner] = toBeSorted[inner - h];
                    inner -= h;
                }
                toBeSorted[inner] = temp;
            }
            h = (h - 1) / 3; // decrease h
        }

        long endTime = System.nanoTime();

        System.out.print("time: " + (endTime - startTime) + " ns\n"
                + "time: " + (endTime - startTime) / 1000 + " \u00B5s\n"
                + "time: " + (endTime - startTime) / 1000000 + " ms\n");
    }
}