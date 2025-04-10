package Lab04;
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
}
