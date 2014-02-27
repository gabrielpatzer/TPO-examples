package sortingalgorithms;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class MergeSort {

    static final int SIZE = 10000;

    public static void merge_sort(int[] v, int ini, int fim) {
        int meio;

        if (ini < fim) {
            meio = (ini + fim) / 2;
            merge_sort(v, ini, meio);
            merge_sort(v, meio + 1, fim);
            merge(v, ini, meio, fim);
        }
    }

    public static void merge(int[] v, int inicio, int meio, int fim) {
        int tamanho = fim - inicio + 1;

        /* Inicialização de um vetor temporario para auxiliar na ordenação O
         * vetor temporário é uma cópia do trecho que será ordenado
         */
        int[] temp = new int[fim - inicio + 1];
        System.arraycopy(v, inicio, temp, 0, tamanho);

        /* Laço para ordenação do vetor, utilizando o vetor temporário, usando
         * índices i e j para cada trecho de vetor da mesclagem
         */

        int i = 0;
        int j = meio - inicio + 1;

        //A depender das condições, recebe um elemento de um trecho ou outro
        for (int posicao = 0; posicao < tamanho; posicao++) {
            if (j <= tamanho - 1) {
                if (i <= meio - inicio) {
                    if (temp[i] < temp[j]) {
                        v[inicio + posicao] = temp[i++];
                    } else {
                        v[inicio + posicao] = temp[j++];
                    }
                } else {
                    v[inicio + posicao] = temp[j++];
                }
            } else {
                v[inicio + posicao] = temp[i++];
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] toBeSorted = new int[SIZE];
        Random r = new Random();
        for (int i = 0; i < SIZE; ++i) {
            toBeSorted[i] = r.nextInt(9999);
        }

        // vetor onde a ordenação ocorre
        int[] sorted = new int[SIZE];
        long startTime = System.nanoTime();

        /* Merge Sort 
         *  Stable
         *  Θ(n) extra space for arrays (as shown)
         *  Θ(lg(n)) extra space for linked lists
         *  Θ(n·lg(n)) time
         *  Not adaptive
         *  Does not require random access to data
         */
        int[] d = new int[8];
        d[0] = 1;
        d[1] = 3;
        d[2] = 4;
        d[3] = 8;
        d[4] = 2;
        d[5] = 6;
        d[6] = 7;
        d[7] = 5;
        //merge_sort(d, 0, d.length - 1);
        merge_sort(toBeSorted, 0, SIZE-1);

        long endTime = System.nanoTime();
        System.out.print("time: " + (endTime - startTime) + " ns\n"
                + "time: " + (endTime - startTime) / 1000 + " \u00B5s\n"
                + "time: " + (endTime - startTime) / 1000000 + " ms\n");
    }
}
