package StringsArrays;

import java.util.*;

public class findKthSmallest {
    public static void main(String[] args) {
        Set<Integer> hset = new HashSet<>();
        hset.add(2);
        hset.add(8);
        hset.add(4);
        hset.add(3);
        hset.add(7);
        hset.add(6);
        hset.add(1);
        
        System.out.println(kthSmallest(hset, 3));

        
    }

    private static int kthSmallest(Set<Integer> hset, int k) {
        Integer[] arr = hset.toArray(new Integer[hset.size()]);
        int size = arr.length;
        return quickSelect(0, size - 1, k, arr);
        
        
    }

    private static int quickSelect(int left, int right, int k_smallest, Integer[] nums) {
        if (left == right) {
            return nums[left];
        }
        //Random rndm = new Random();
        //int pivot_index = left + rndm.nextInt(right - left);
        int pivot_index = partition(left, right, nums);
        System.out.println(pivot_index);
        System.out.println(nums.toString());

        if (k_smallest == pivot_index) {
            return nums[pivot_index];
        } else if (k_smallest < pivot_index) {
            return quickSelect(left, pivot_index -1, k_smallest, nums);
        } //else { 
            return quickSelect(pivot_index + 1, right, k_smallest, nums);
        //}
        
    }

    private static int partition(int start, int end, Integer[] nums) {
        int pivot = nums[end];
        int pIndx = start;
        for (int i = start ; i < end - 1; i ++) {
            if (nums[i] <= pivot) {
                swap(i, pIndx, nums);
                pIndx = pIndx + 1;
            }
        }
        swap(pIndx, end, nums);
        return pIndx;   
    }

    private static void swap(int pivot_index, int right, Integer[] nums) {
        int temp = nums[pivot_index];
        nums[pivot_index] = nums[right];
        nums[right] = temp;
        
    }

}
