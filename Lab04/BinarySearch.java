package Lab04;

public class BinarySearch {
    int binarySearch(int arr[], int lo, int hi, int x) {
        if(hi >= lo && lo < arr.length - 1) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, lo, mid - 1, x);
            return binarySearch(arr, mid + 1, hi, x);
        }
        return -1;
    }
    
    public static void main(String[] args) {
        
    }
}
