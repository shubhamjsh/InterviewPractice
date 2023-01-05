package org.example;

import java.util.*;

public class Main {

    /*
    * Given a pattern containing only I’s and D’s. I for increasing and D for decreasing. Devise an algorithm to print the minimum number following that pattern. Digits from 1-9 and digits can’t repeat.

Examples:
   Input: D        Output: 21
   Input: I        Output: 12
   Input: DD       Output: 321
   Input: II       Output: 123
   Input: DIDI     Output: 21435
   Input: IIDDD    Output: 126543
   Input: DDIDDIID Output: 321654798
    */


    static void PrintMinNumberForPattern(String seq) {
        // result store output string
        String result = "";

        // create an empty stack of integers
        Stack<Integer> stk = new Stack<Integer>();

        // run n+1 times where n is length of input sequence
        for (int i = 0; i <= seq.length(); i++) {
            // push number i+1 into the stack
            stk.push(i + 1);

            // if all characters of the input sequence are
            // processed or current character is 'I'
            // (increasing)
            if (i == seq.length() || seq.charAt(i) == 'I') {
                // run till stack is empty
                while (!stk.empty()) {
                    // remove top element from the stack and
                    // add it to solution
                    result += String.valueOf(stk.peek());
                    result += " ";
                    stk.pop();
                }
            }
        }

        System.out.println(result);
    }

    // main function
    public static void main(String[] args) {
//        PrintMinNumberForPattern("IDID");
//        Integer[][] matrix = {
//                { 1, 2, 3, 4},
//                { 5, 6, 7, 8 },
//                { 9, 10, 11, 12 }
//        };
//        ArrayList<Integer> mat = printSpiral(matrix);
//        for (Integer i : mat) {
//            System.out.println(i + " ");
//        }
        int[][] res = generateMatrix(3);

    }

    /*Print matrix in spiral order
     */

    public static int[][] insertInMatrix(){
        int[][] mat = new int[4][4];
        for(int i=0; i<4; i++) {
            for (int j=0; j<4; j++){
                mat[i][j] = (int) (Math.random() * 5);
            }
        }
        return mat;
    }

    public static void printMatrix(Integer[][] matrix) {
//        int[][] mat = insertInMatrix();

//         int[][] matrix = {
//                { 1, 2, 3 },
//                { 4, 5, 6 },
//                { 7, 8, 9 }
//        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> printSpiral(Integer[][] mat) {
        int top = 0;
        int down = mat.length-1;
        int left = 0;
        int right = mat[0].length-1;
        int dir = 0;
        ArrayList<Integer> result = new ArrayList<Integer>();

//        List<Integer> res = new ArrayList<>();

        while (top <= down && left <= right) {


            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    result.add(mat[top][i]);
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    result.add(mat[i][right]);
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[down][i]);
                }
                down--;
            } else if (dir == 3) {
                for (int i = down; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }
        return result;
    }

//    Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

    public static int[][] generateMatrix(int n) {
        int top = 0;
        int down = n-1;
        int left = 0;
        int right = n-1;
        int dir = 0;
        int count = 1;
        int[][] result = new int[n][n];

        while (top <= down && left <= right) {
            if (dir == 0) {
                for (int i = left; i <= right; i++) {
                    result[top][i] = count;
                    count++;
                }
                top++;
            } else if (dir == 1) {
                for (int i = top; i <= down; i++) {
                    result[i][right] = count;
                    count++;
                }
                right--;
            } else if (dir == 2) {
                for (int i = right; i >= left; i--) {
                    result[down][i] = count;
                    count++;
                }
                down--;
            } else if (dir == 3) {
                for (int i = down; i >= top; i--) {
                    result[i][left] = count;
                    count++;
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }
        return result;
        }

    }



