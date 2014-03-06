package sortingalgorithms;

import java.util.Arrays;

/**
 *
 * @author Gabriel
 */
public class QuickSort {

    static int qtdTrocas = 0, qtdComp = 0, qtdRecursoes = 0, qtdLoop = 0;

    public static void quick_sort(int[] v, int ini, int fim) {
        qtdRecursoes++;
        int meio;

        if (ini < fim) {
            meio = partition(v, ini, fim);
            quick_sort(v, ini, meio);
            quick_sort(v, meio + 1, fim);
        }
    }

    public static int partition(int[] v, int ini, int fim) {
        qtdLoop++;
        int pivo, topo, i;
        pivo = v[ini];
        topo = ini;

        for (i = ini + 1; i <= fim; i++) {
            qtdComp++;
            if (v[i] < pivo) {
                qtdTrocas++;
                v[topo] = v[i];
                v[i] = v[topo + 1];
                topo++;
            }
        }
        qtdTrocas++;
        v[topo] = pivo;
        return topo;
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
        
        quick_sort(toBeSorted,0,toBeSorted.length-1);

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
        System.out.println("Quantidade de Partitions: "+qtdLoop);
        System.out.println("Quantidade de comparações: " + qtdComp);
        System.out.println("Quantidade de trocas: " + qtdTrocas);
    }
}
