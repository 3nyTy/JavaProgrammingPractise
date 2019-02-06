package amazomn;

public class SearchInSortedInfiniteArray {
    public static void main(String[] args) throws Exception {
        int arr[] = new int[] {
                3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170, 200, 350, 890
        };
        int ans = findPos(arr, 10);

        if (ans == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + ans);
    }

    private static int findPos(int[] arr, int key) throws Exception  {
        if (arr.length == 0) return -1;
        int low = 0; int high = 1;
        int val = arr[0];
        while (val < key) {
            low = high;
            high = 2 * high; // dont know the upper bound so everytime double it and check if it comes in the range.
            val = arr[high];           
        }
       
        System.out.println(low+ " , " + high);
        return binarySearch(arr, low, high, key);
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
       while(low <= high) {
           int mid = (low + high)/2;
           if (key == arr[mid]) return mid;
           else if (key > arr[mid]) {
                low = mid + 1;
           } else {
               high =  mid - 1;
           }
       }
       return -1;
    }

}
