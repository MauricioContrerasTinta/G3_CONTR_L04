package Lab04;
public class QuickSelect {
    public static int hallarMenor(int[] arr, int k){
        return quickSelect(arr, 0, arr.length - 1, k -1);
    }
}
