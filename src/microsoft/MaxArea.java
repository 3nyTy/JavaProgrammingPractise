package microsoft;

public class MaxArea {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 8, 6, 2, 5, 4, 8,3,7};
        System.out.println(findMaxArea(arr));
    }

    private static int findMaxArea(int[] arr) {
        int left = 0;
        int right = arr.length;
        if(right == 0) return 0;
        int maxArea = Integer.MIN_VALUE;
        int area =  0;
        
        while(right > left) {
            if(arr[left] < arr[right]) {
                area = arr[left] *  (left - right); 
                left++;
            } else if (arr[left] > arr[right]) {
                area =  arr[right] * (left - right);
                right--;
            } else {
                area = arr[left] * (left - right);
                right--;
                left++;
                
            }
            
            if (area > maxArea) {
                maxArea = area;
            }
        }
        
        return maxArea;
        
    }

}
