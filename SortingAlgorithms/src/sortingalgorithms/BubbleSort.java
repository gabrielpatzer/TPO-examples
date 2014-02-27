package sortingalgorithms;

import java.util.Arrays;

/**
 *
 * @author Gabriel
 */
public class BubbleSort {
static final int SIZE = 10000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] toBeSorted = new int[SIZE];
        for(int i=0;i<SIZE;++i) toBeSorted[i] = (int)(Math.random()*9999);
        int[] copied = new int[SIZE];
        System.arraycopy(toBeSorted, 0, copied, 0, copied.length);
        long startTime = System.nanoTime();
        
        /* Bubble Sort 
         *  stable
         *  O(1) extra space
         *  O(n2) comparisons and swaps
         *  Adaptive: O(n) when nearly sorted 
         */
        for (int i = 0; i<SIZE;i++){
            boolean swapped = false;
            for(int j=SIZE-1; j>i ; j--){
                if (toBeSorted[j] < toBeSorted[j-1]){
                    int temp = toBeSorted[j];
                    toBeSorted[j] = toBeSorted[j - 1];
                    toBeSorted[j - 1] = temp;
                    swapped=true;
                }
            }
            if (!swapped) break;
        }
        
        long endTime = System.nanoTime();
        System.out.print("time: "+(endTime-startTime)+" ns\n"+
                "time: "+(endTime-startTime)/1000+" \u00B5s\n"+
                "time: "+(endTime-startTime)/1000000+" ms\n");
    }
}
