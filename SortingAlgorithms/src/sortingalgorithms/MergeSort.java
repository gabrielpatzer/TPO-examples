package sortingalgorithms;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Gabriel
 */
public class MergeSort {

    static int qtdTrocas = 0, qtdComp = 0, qtdRecursoes = 0, qtdLoop = 0;

    public static void merge_sort(int[] v, int ini, int fim) {
        qtdRecursoes++;
        int meio;

        if (ini < fim) {
            meio = (ini + fim) / 2;
            merge_sort(v, ini, meio);
            merge_sort(v, meio + 1, fim);
            merge(v, ini, meio, fim);
        }
    }

    public static void merge(int[] v, int inicio, int meio, int fim) {
        qtdLoop++;
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
            qtdTrocas++;
            if (j <= tamanho - 1) {
                if (i <= meio - inicio) {
                    qtdComp++;
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
        /**
         * vetores de teste v1 = { 3, 2, 7, 5, 1, 4, 6 } v2 = { 7, 6, 5, 4, 3,
         * 2, 1 } v3 = { 2, 3, 1, 4, 7, 5, 6 } v4 = { 1, 2, 3, 4, 5, 6, 7 }
         */
        int[] toBeSorted = new int[]{ 1, 2, 3, 4, 5, 6, 7 };
        int[] original = new int[toBeSorted.length];
        System.arraycopy(toBeSorted, 0, original, 0, original.length);
        
        merge_sort(toBeSorted, 0, toBeSorted.length-1);

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
        System.out.println("Quantidade de Merges: "+qtdLoop);
        System.out.println("Quantidade de comparações: " + qtdComp);
        System.out.println("Quantidade de trocas: " + qtdTrocas);
    }
}
