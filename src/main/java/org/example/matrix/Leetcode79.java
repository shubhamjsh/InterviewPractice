package org.example.matrix;


/* Given an m x n grid of characters board and a string word, return true if word exists in the grid.\
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells
are horizontally or vertically neighboring. The same letter cell may not be used more than once.*/

public class Leetcode79 {

    static char[] letter;
    static char[][] matrix;
    static boolean[][] visited;
    public static boolean exist(char[][] board, String word) {
        matrix = board;
        letter = word.toCharArray();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for(int i = 0; i < rowLen; i++) {
            for(int j = 0; j< colLen; j++) {
                if(matrix[i][j] == letter[0]) {
                    visited = new boolean[rowLen][colLen];
                    boolean res = dfs(i, j, 0);
                    if (res == true) return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int rowLen, int colLen, int index) {
        if(index == letter.length) return true;
        if(rowLen < 0 || rowLen >= matrix.length) return false;
        if(colLen < 0 || colLen >= matrix[0].length) return false;
        if(visited[rowLen][colLen] == true) return false;
        if(matrix[rowLen][colLen] != letter[index]) return false;

        visited[rowLen][colLen] = true;
        //dfs for all 4 directions
        boolean top = dfs(rowLen-1, colLen, index + 1);
        boolean down = dfs(rowLen + 1, colLen, index + 1);
        boolean left = dfs(rowLen, colLen - 1, index + 1);
        boolean right = dfs(rowLen, colLen + 1, index + 1);

        boolean res = top || down || left || right;
        if(res == false)
            visited[rowLen][colLen] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'A', 'E', 'C'},
                {'E', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String s = "CEA";
        System.out.println(exist(matrix, s));
    }
}
