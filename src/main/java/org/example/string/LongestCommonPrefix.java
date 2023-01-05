package org.example.string;


//leetcode 14
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
            String res = "";
            String first = strs[0];
            for(int i = 1; i < strs.length; i++) {
                while(strs[i].startsWith(first)) {
                    first = first.substring(0, first.length()-1);
                }
            }
            return first;

    }

    public static void main(String[] args) {
        String[] arr = {"flower", "flowf", "flora"};
        longestCommonPrefix(arr);
    }
}
