package sortingalgorithms;

import java.util.Arrays;

/**
 * Ordenação de vetor de inteiros por BubbleSort com contadores de comparações,
 * trocas e laços.
 *
 * @author Gabriel
 */
public class BubbleSort {

    static int qtdTrocas = 0, qtdComp = 0, qtdLoopExterno = 0, qtdLoopInterno = 0;

    public static void main(String[] args) {
        /**
         * vetores de teste v1 = { 3, 2, 7, 5, 1, 4, 6 } v2 = { 7, 6, 5, 4, 3,
         * 2, 1 } v3 = { 2, 3, 1, 4, 7, 5, 6 } v4 = { 1, 2, 3, 4, 5, 6, 7 }
         */
        int[] toBeSorted = new int[]{ 1, 2, 3, 4, 5, 6, 7 };
        int[] original = new int[toBeSorted.length];
        System.arraycopy(toBeSorted, 0, original, 0, original.length);

        for (int i = 0; i < toBeSorted.length; i++) {
            boolean swapped = false;
            for (int j = toBeSorted.length - 1; j > i; j--) {
                qtdComp++;
                if (toBeSorted[j] < toBeSorted[j - 1]) {
                    int temp = toBeSorted[j];
                    toBeSorted[j] = toBeSorted[j - 1];
                    toBeSorted[j - 1] = temp;
                    swapped = true;
                    qtdTrocas++;
                }
                qtdLoopInterno++;
            }
            qtdLoopExterno++;
            if (!swapped) {
                break;
            }
        }

        System.out.print("Vetor original: [ ");
        for (int n:original) System.out.print(n+" ");
        System.out.println("]");
        System.out.print("Vetor ordenado: [ ");
        for (int n:toBeSorted) System.out.print(n+" ");
        System.out.println("]");
        System.out.println();
        
        System.out.println("Quantidade de Laços:\n\tExternos: "+qtdLoopExterno+
                "\tInternos: "+qtdLoopInterno);
        System.out.println("Quantidade de comparações: "+qtdComp);
        System.out.println("Quantidade de trocas: "+qtdTrocas);
        
    }
}
