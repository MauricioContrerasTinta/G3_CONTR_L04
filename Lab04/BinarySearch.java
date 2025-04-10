package Lab04;

public class BinarySearch {
    int binarySearch(int arr[], int lo, int hi, int x) {
        if(hi >= lo && lo < arr.length - 1) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == x)
            return mid;
    }
    
}
