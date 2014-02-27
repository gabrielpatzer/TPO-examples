package sortingalgorithms;

import java.util.Arrays;

/**
 *
 * @author Gabriel
 */
public class QuickSort {

    static final int SIZE = 10000;

    public static void quick_sort(int[] v, int ini, int fim) {
        int meio;

        if (ini < fim) {
            meio = partition(v, ini, fim);
            quick_sort(v, ini, meio);
            quick_sort(v, meio + 1, fim);
        }
    }

    public static int partition(int[] v, int ini, int fim) {
        int pivo, topo, i;
        pivo = v[ini];
        topo = ini;

        for (i = ini + 1; i <= fim; i++) {
            if (v[i] < pivo) {
                v[topo] = v[i];
                v[i] = v[topo + 1];
                topo++;
            }
        }
        v[topo] = pivo;
        return topo;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] toBeSorted = new int[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            toBeSorted[i] = (int) (Math.random() * 9999);
        }

        long startTime = System.nanoTime();

        /* Quick Sort 
         *  Not stable
         *  O(lg(n)) extra space
         *  O(n2) time, but typically O(n·lg(n)) time
         *  Not adaptive
         */
        
        quick_sort(toBeSorted,0,toBeSorted.length-1);

        long endTime = System.nanoTime();
        System.out.print("time: " + (endTime - startTime) + " ns\n"
                + "time: " + (endTime - startTime) / 1000 + " \u00B5s\n"
                + "time: " + (endTime - startTime) / 1000000 + " ms\n");
    }
}
