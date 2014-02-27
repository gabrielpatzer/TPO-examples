package sortingalgorithms;

import java.util.Arrays;

/**
 *
 * @author Gabriel
 */
public class InsertionSort {

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

        /* Insertion Sort 
         *  Stable
         *  O(1) extra space
         *  O(n2) comparisons and swaps
         *  Adaptive: O(n) time when nearly sorted
         *  Very low overhead
         */
        
        for(int i=1;i<SIZE;i++){
            int k=i;
            for(; k>0 && toBeSorted[k] < toBeSorted[k-1];k--){
                int temp = toBeSorted[k];
            toBeSorted[k] = toBeSorted[k-1];
            toBeSorted[k-1] = temp;
            }
        }
        
        long endTime = System.nanoTime();
        System.out.print("time: " + (endTime - startTime) + " ns\n"
                + "time: " + (endTime - startTime) / 1000 + " \u00B5s\n"
                + "time: " + (endTime - startTime) / 1000000 + " ms\n");
    }
}
