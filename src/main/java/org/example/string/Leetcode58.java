package org.example.string;

public class Leetcode58 {

    public static int lengthOfLastWord(String s) {
        s.trim();
        String [] arr = s.split(" ");

        String st = arr[arr.length-1];
        return st.length();
    }

    public static void main(String[] args) {
        String s = "a dog is a   friend ";
        lengthOfLastWord(s);
    }
}
