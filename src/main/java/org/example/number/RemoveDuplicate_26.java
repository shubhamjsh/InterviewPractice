package org.example.number;

//leetcode 26
public class RemoveDuplicate_26 {

    public static int removeDuplicates(int[] nums) {

        int i=0;
        for(int j=1;j<nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }

        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,1,2,3};
        removeDuplicates(arr);
    }
}
