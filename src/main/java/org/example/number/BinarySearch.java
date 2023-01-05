package org.example.number;

public class BinarySearch {

    public static int bsearchRecursive(int []nums, int num, int left, int right) {
        int mid = left + (right-left)/2;
        while(left <= right) {
            if(nums[mid] == num)
                return mid;
            if(nums[mid] < num) {
                return bsearchRecursive(nums, num, mid+1, right);
            }
            else{
                return bsearchRecursive(nums, num, left, mid-1);
            }
        }
        return -1;
    }

    //leetcode 35
    public static int bSearchIterative(int[] nums, int key) {
        int left =0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = left + (right - left)/2;
            if(nums[mid] == key)
                return mid;
            else if(nums[mid] > key)
                right = mid - 1;
            else left = mid+1;
        }
        return right+1;
    }
    public static void main(String[] args) {
        int[] num = {1,2,4,5,6};
        int left = 0;
        int right = num.length-1;
//        System.out.println(bsearchRecursive(num, 0, left, right));
        System.out.println(bSearchIterative(num, 3));

    }




}
