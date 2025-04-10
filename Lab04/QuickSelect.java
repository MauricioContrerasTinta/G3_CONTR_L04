package Lab04;

import java.util.Random;

public class QuickSelect {
    public static int hallarMenor(int[] arr, int k){
        return quickSelect(arr, 0, arr.length - 1, k -1);
    }

     private static int quickSelect(int[] arr, int left, int rigth, int k){
        if (left == rigth) {
            return arr[left];
        }

        Random random = new Random();
        int pivote = left + random.nextInt(rigth - left + 1);
        pivote = dividir(arr, left, rigth, pivote);

        if (k == pivote) {
            return arr[k];
        } else if (k < pivote) {
            return quickSelect(arr, left, pivote -1, k);
        } else {
            return quickSelect(arr, pivote + 1, rigth, k);
        }
    }

    private static void cambio(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int dividir(int[] arr, int left, int rigth, int pivote){
        int valorPivote = arr[pivote];
        cambio(arr, pivote, rigth);
        int almacen = left;

        for(int i = left; i < rigth; i++){
            if (arr[i] < valorPivote) {
                cambio(arr, almacen, i);
                almacen++;
            }
        }

        cambio(arr, rigth, almacen);

        return almacen;
    }

}
