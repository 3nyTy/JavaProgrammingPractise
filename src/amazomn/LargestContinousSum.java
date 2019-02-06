package amazomn;

public class LargestContinousSum {
    public static void main(String[] args) {
        int[] arr = new int[] {-40,1,40,-50,1,50,-20,1,20,0,0};
        int sum = findMaxContinousSum(arr);
        System.out.println(sum);
    }

    private static int findMaxContinousSum(int[] arr) {
        if (arr.length == 0) return 0;
        int max_sum = arr[0];
        int curr_sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            //imp to remember is not making the sum = 0 as mentioned in KAdanes Algo as it will not be able to 
            //find max continous sum if all are negative numbers
            curr_sum  = Integer.max(curr_sum + arr[i] , arr[i]);
            /* if (curr_sum + arr[i] > arr[i] ){
             * curr_sum = curr_sum + arr[i];
             * }
             * */
            max_sum = Integer.max(curr_sum, max_sum);
            /*if (curr_sum < 0) {
                curr_sum = 0;
            }
            if(curr_sum > max_sum) {
                max_sum = curr_sum;
            }*/
        }
        return max_sum; 
    }

}
