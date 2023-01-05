package org.example.number;

public class Leetcode167 {

    public static int[] twoSum(int[] numbers, int target) {

        int a = 0;
        int b = numbers.length-1;

        while(a<=b) {
            int sum = numbers[a] + numbers[b];
            if(sum > target) {
                b--;
            } else if (sum< target) {
                a++;
            } else return new int[]{a+1, b+1};
        }
        return new int[]{a+1,b+1};
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2,4,6,8,9,10,11};
        int [] ans = twoSum(arr, 19);
        System.out.println(ans);
    }
}
