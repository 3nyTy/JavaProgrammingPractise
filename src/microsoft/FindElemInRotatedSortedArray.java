package microsoft;

public class FindElemInRotatedSortedArray {
    public static void main(String args[]) 
    { 
       // Let us search 3 in below array 
       int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; 
       int n = arr1.length; 
       int key = 3; 
       System.out.println("Index of the element is : "
                      + pivotedBinarySearch(arr1, n, key)); 
    }

    private static int pivotedBinarySearch(int[] arr, int n, int key) {
        int pivot = findPivot(arr, 0, n-1);
        
        if(pivot == 0) {
            return binarySearch(arr, 0, n-1, key);
        }
        if(arr[pivot] == key) return pivot;
        if (arr[0] <= key) {
            return binarySearch (arr, 0, pivot - 1 , key);
        }
        return binarySearch(arr, pivot+1, n, key);
    }

    private static int binarySearch(int[] arr, int i, int j, int key) {
        // TODO Auto-generated method stub
        return 0;
    }

    private static int findPivot(int[] arr, int low, int high) {
        if(high < low) return -1;
        if(high == low) return low;
        while(low <= high) {
            int p = (low + high) / 2;
            //if(arr[pivot] > )
        }
        
        
        return 0;
    } 

}
