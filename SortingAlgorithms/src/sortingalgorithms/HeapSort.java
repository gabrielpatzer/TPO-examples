package sortingalgorithms;

import java.util.Arrays;

/**
 *
 * @author Gabriel
 */
public class HeapSort {

    static int qtdTrocas = 0, qtdComp = 0, qtdRecursoes = 0;

    public static void heapSort(int[] v) {
        buildMaxHeap(v );
        int n = v.length;

        for (int i = v.length - 1; i > 0; i--) {
            swap(v, i, 0);
            qtdRecursoes++;
            maxHeapify(v, 0, --n);
        }
    }

    private static void buildMaxHeap(int[] v) {
        for (int i = v.length / 2 - 1; i >= 0; i--) {
            maxHeapify(v, i, v.length);
        }
    }

    private static void maxHeapify(int[] v, int pos, int n) {
        int maxi;
        int l = 2 * pos + 1;
        int right = 2 * pos + 2;
        qtdComp++;
        if ((l < n) && (v[l] > v[pos])) {
            maxi = l;
        } else {
            maxi = pos;
        }
        qtdComp++;
        if (right < n && v[right] > v[maxi]) {
            maxi = right;
        }
        if (maxi != pos) {
            swap(v, pos, maxi);
            maxHeapify(v, maxi, n);
        }
    }

    public static void swap(int[] v, int j, int aposJ) {
        qtdTrocas++;
        int aux = v[ j];
        v[ j] = v[ aposJ];
        v[ aposJ] = aux;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * vetores de teste v1 = { 3, 2, 7, 5, 1, 4, 6 } v2 = { 7, 6, 5, 4, 3,
         * 2, 1 } v3 = { 2, 3, 1, 4, 7, 5, 6 } v4 = { 1, 2, 3, 4, 5, 6, 7 }
         */
        int[] toBeSorted = new int[]{ 4, 2, 3, 1, 5, 7, 6 };
        int[] original = new int[toBeSorted.length];
        System.arraycopy(toBeSorted, 0, original, 0, original.length);

        heapSort(toBeSorted);

        System.out.print("Vetor original: [ ");
        for (int n : original) {
            System.out.print(n + " ");
        }
        System.out.println("]");
        System.out.print("Vetor ordenado: [ ");
        for (int n : toBeSorted) {
            System.out.print(n + " ");
        }
        System.out.println("]");
        System.out.println();

        System.out.println("Quantidade de recursões: "+qtdRecursoes);
        System.out.println("Quantidade de comparações: " + qtdComp);
        System.out.println("Quantidade de trocas: " + qtdTrocas);
    }
}
